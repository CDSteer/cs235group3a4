
/**
 * @brief A test class for OthGame
 * @details
 * 
 * 		  OthGame.playGame is tested one time(s).
 * 		  OthGame.nextTurn is tested one time(s).
 *        OthGame.calcCounters is tested one time(s).
 *        OthGame.init / OthGame.gameLoop runs in an infinite loop and cannot be tested in isolation.
 *         
 * @author Tom Werner
 *
 */
public class TestOthGame {
	
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	private static final int COLUMN = 8;
	private static final int ROW = 8;
    private static final int PRESET_COUNTERS = 2;
	
	private static OthGame m_othGame;
	
	public static void main(String[] args) {
		
		/*
		 * OthGame.playGame Test One
		 * Call the method after a constructor
		 */	
		m_othGame = new OthGame();
		
		try {
			m_othGame.playGame();
			System.out.println("OthGame.playgame Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthGame.playgame Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthGame.nextTurn Test One
		 * Call the method for the first time after the game begins
		 * Method only possible if OthGame.playGame succeeds
		 */	
		m_othGame = new OthGame();
		try {
			m_othGame.playGame();
		} catch (Exception e) {
			System.out.println("OthGame.nextTurn Test One Evaluated: Incorrect");
		}
		
		m_othGame.nextTurn();
		if(m_othGame.getTurn() == PLAYER_TWO) {
			System.out.println("OthGame.nextTurn Test One Evaluated: Correct");
		} else {
			System.out.println("OthGame.nextTurn Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthGame.calcCounters Test One
		 * Call the method on a board with no moves made
		 * Only the default 4 counters should be present
		 */
		m_othGame = new OthGame();
		m_othGame.calcCounters();
		if(m_othGame.getCounters1() == PRESET_COUNTERS || m_othGame.getCounters2() == PRESET_COUNTERS) {
			System.out.println("OthGame.calcCounters Test One Evaluated: Correct");
		} else {
			System.out.println("OthGame.calcCounters Test One Evaluated: Incorrect");
		}
		
		
	}
}