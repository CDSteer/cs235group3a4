/**
 * @brief A test class for OthRules
 * @details
 * 
 * OthRules.winCondition is tested 3 times.
 * 
 * OthRules.checkValidSet is tested 1 time(s).
 * during this test, methods:
 * 		OthRules.checkAvailableMatch
 * 		OthRules.checkVerticalDown
 * 		OthRules.checkVerticalUp
 * 		OthRules.checkRowsRight
 * 		OthRules.checkRowsLeft
 * 		OthRules.checkDiagonalUpRight
 * 		OthRules.checkDiagonalUpLeft
 * 		OthRules.checkDiagonalDownRight
 * 		OthRules.checkDiagonalDownLeft
 * 		are also called.
 * 
 * 		OthRules.flipCounters is tested one time(s). 
 * 		during this test, methods:
 * 		OthRules.flipVerticalDown
 * 		OthRules.flipVerticalUp
 * 		OthRules.flipRowsRight
 * 		OthRules.flipRowsLeft
 * 		OthRules.flipDiagonalUpRight
 * 		OthRules.flipDiagonalUpLeft
 * 		OthRules.flipDiagonalDownRight
 * 		OthRules.flipDiagonalDownLeft
 * 		are also called.
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
	private static final int FLIP_COL = 5;
	private static final int FLIP_ROW = 4;
	private static final int CHECK_COL = 4;
	private static final int CHECK_ROW = 4;
	
	private static OthGame m_othGame;
	private static OthRules m_othRules;
	
	
	public static void main(String args[]) {
		
		/*
		 * OthRules.winCondition Test One:
		 * Filled board of PLAYER_ONE counters
		 */
		m_othRules = new OthRules();
		
		OthCounter[][] m_testBoard1 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(1);
				m_testBoard1[i][j] = counter;
			}
		}
		
		if(m_othRules.winCondition(m_testBoard1) == PLAYER_ONE) {
			System.out.println("OthRules.winCondition Test One Evaluated: Correct");
		} else {
			System.out.println("OthRules.winCondition Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthRules.winCondition Test Two:
		 * Filled board of PLAYER_TWO counters
		 */
		m_othRules = new OthRules();
		
		OthCounter[][] m_testBoard2 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(2);
				m_testBoard2[i][j] = counter;
			}
		}
		
		if(m_othRules.winCondition(m_testBoard2) == PLAYER_TWO) {
			System.out.println("OthRules.winCondition Test Two Evaluated: Correct");
		} else {
			System.out.println("OthRules.winCondition Test Two Evaluated: Incorrect");
		}
		
		
		/*
		 * OthRules.winCondition Test Two:
		 * Empty board (counters of player 0 are not visible)
		 */
		m_othRules = new OthRules();
		
		OthCounter[][] m_testBoard3 = new OthCounter[COLUMN][ROW];
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				OthCounter counter = new OthCounter(0);
				m_testBoard3[i][j] = counter;
			}
		}
		
		if(m_othRules.winCondition(m_testBoard3) == NO_MATCH) {
			System.out.println("OthRules.winCondition Test Three Evaluated: Correct");
		} else {
			System.out.println("OthRules.winCondition Test Three Evaluated: Incorrect");
		}
		
		
		/*
		 * OthRules.checkValidSet Test One:
		 * Testing the filled board of PLAYER_ONE counters
		 * All positions filled, so no valid moves should be possible
		 */
		m_othRules = new OthRules();
		
		int[][] validSet1 = m_othRules.checkValidSet(m_testBoard1);
		boolean correct1 = true;
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				if(validSet1[i][j] != 0) {
					correct1 = false;
				} 
			}
		}
		
		if(correct1 == true) {
			System.out.println("OthRules.checkValidSet Test One Evaluated: Correct");
		} else {
			System.out.println("OthRules.checkValidSet Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthRules.flipCounters Test One
		 * Constructs an OthGame with default counter setup, 
		 * then places a specific counter at [FLIP_COL][FLIP_ROW] and tests expected result.
		 */
		m_othRules = new OthRules();
		m_othGame = new OthGame();
		
		m_othRules.flipCounters(m_othGame.getInPlayCounters(), FLIP_COL, FLIP_ROW, PLAYER_ONE);
		if(m_othGame.getInPlayCounters()[CHECK_COL][CHECK_ROW].getPlayer() == PLAYER_ONE) {
			System.out.println("OthRules.flipCounters Test One Evaluated: Correct");
		} else {
			System.out.println("OthRules.flipCounters Test One Evaluated: Incorrect");
		}
		
				

	}
}
