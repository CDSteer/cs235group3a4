/**
 * @file TestOthRules.java
 * @detail A test class for OthRules.java
 * 
 * 		   winCondition is tested 3 times.
 * 
 * 		   checkValidSet is tested 1 time(s). (need to do more of these)
 * 		   during this test, methods X,Y,Z are also called
 * 
 * 		   flipCounters is tested X times. (need to do these)
 * 
 * @author Tom
 *
 */
public class TestOthRules {
	
	private static final int COLUMN = 8;
	private static final int ROW = 8;
	private static final int NO_MATCH = 0;
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	
	private static OthRules othRules;
	
	
	public static void main(String args[]) {
		
		/*
		 * OthRules.winCondition Test One:
		 * Filled board of PLAYER_ONE counters
		 */
		othRules = new OthRules();
		
		OthCounter[][] m_testBoard1 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(1);
				m_testBoard1[i][j] = counter;
			}
		}
		
		if(othRules.winCondition(m_testBoard1) == PLAYER_ONE) {
			System.out.println("winCondition Test One Evaluated: Correct");
		} else {
			System.out.println("winCondition Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthRules.winCondition Test Two:
		 * Filled board of PLAYER_TWO counters
		 */
		othRules = new OthRules();
		
		OthCounter[][] m_testBoard2 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(2);
				m_testBoard2[i][j] = counter;
			}
		}
		
		if(othRules.winCondition(m_testBoard2) == PLAYER_TWO) {
			System.out.println("winCondition Test Two Evaluated: Correct");
		} else {
			System.out.println("winCondition Test Two Evaluated: Incorrect");
		}
		
		
		/*
		 * OthRules.winCondition Test Two:
		 * Empty board (counters of player 0 are not visible)
		 */
		othRules = new OthRules();
		
		OthCounter[][] m_testBoard3 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(0);
				m_testBoard3[i][j] = counter;
			}
		}
		
		if(othRules.winCondition(m_testBoard3) == NO_MATCH) {
			System.out.println("winCondition Test Three Evaluated: Correct");
		} else {
			System.out.println("winCondition Test Three Evaluated: Incorrect");
		}
		
		
		/*
		 * OthRules.checkValidSet Test One:
		 * Testing the filled board of PLAYER_ONE counters
		 * All positions filled, so no valid moves should be possible
		 */
		othRules = new OthRules();
		
		int[][] validSet1 = othRules.checkValidSet(m_testBoard1);
		boolean correct1 = true;
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				if(validSet1[i][j] != 0) {
					correct1 = false;
				} 
			}
		}
		
		if(correct1 == true) {
			System.out.println("checkValidSet Test One Evaluated: Correct");
		} else {
			System.out.println("checkValidSet Test One Evaluated: Incorrect");
		}

	}
}
