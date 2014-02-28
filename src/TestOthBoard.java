
/**
 * @author Tom Werner
 * @brief A test for OthBoard
 * @details
 * 
 * 		   OthBoard.startingCounters is tested one time(s).
 * 		   OthBoard.fillBoard is tested one time(s).
 * 		   OthBoard.placeCounter is tested one time(s).
 */
public class TestOthBoard {
	
	private static final int ROW_EIGHT = 8;
	private static final int COLUMN_EIGHT = 8;
	private static final int COLUMN_CHECK = 3;
	private static final int ROW_CHECK = 3;
	private static final int NO_PLAYER = 0;
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	
	
	private static OthGame m_othGame;
	private static OthBoard m_othBoard;
	
	/**
	 * main method to run tests
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * OthBoard.startingCounters Test One
		 * Calls the method after the constructors for an Oth Game and board
		 * Default counters place has a player2 counter at [3][3], so this is checked
		 */
		m_othBoard = new OthBoard();
		m_othGame = new OthGame();
		
		m_othBoard.startingCounters(m_othGame.getOnScreenCounters(), m_othGame.getInPlayCounters());
		
		if(m_othGame.getInPlayCounters()[COLUMN_CHECK][ROW_CHECK].getPlayer() == PLAYER_TWO) {
			System.out.println("OthBoard.startinCounters Test One Evaluated: Correct");
		} else {
			System.out.println("OthBoard.startinCounters Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthBoard.fillBoard Test One
		 * Calls the method after the constructors for an Oth Game and board
		 * As the method fills the board with counters of player(0), this is checked for
		 */
		m_othBoard = new OthBoard();
		m_othGame = new OthGame();
		
		m_othBoard.fillBoard();
		
		boolean testing1 = true;
		for(int i = 0; i < COLUMN_EIGHT; i++) {
			for(int j = 0; j < ROW_EIGHT; j++) {
				if(!(m_othBoard.getBoard()[i][j].getPlayer() == NO_PLAYER)) {
					testing1 = false;
				}
			}
		}
		
		if(testing1 == true) {
			System.out.println("OthBoard.fillBoard Test One Evaluated: Correct");
		} else {
			System.out.println("OthBoard.fillBoard Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthBoard.placeCounter Test One
		 * Calls the method after the constructors for an Oth Game and board
		 */
		m_othBoard = new OthBoard();
		m_othGame = new OthGame();
		
		try {
			m_othBoard.placeCounter(m_othGame);
			System.out.println("OthBoard.placeCounter Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthBoard.placeCounter Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthBoard.checkGameOver
		 * OthBoard.draw ?
		 */
		
		
	
	}
}
