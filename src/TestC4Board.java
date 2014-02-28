
/**
 * @author Tom Werner
 * @brief A test for C4Board
 * @details
 *         
 * C4Board.fillBoard is tested one time(s).
 * C4Board.placeCounter is tested one time(s). 
 */
public class TestC4Board {
	
	private static final int ROW = 10;
	private static final int COLUMN = 7;
	private static final int NO_PLAYER = 0;
	
	
	private static C4Game m_c4Game;
	private static C4Counter m_c4Counter;
	private static C4Board m_c4Board;
	
	/**
	 * main method to run tests
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * C4Board.fillBoard Test One
		 */
		m_c4Board = new C4Board();
		m_c4Game = new C4Game();
		
		m_c4Board.fillBoard();
		
		boolean testing1 = true;
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				if(!(m_c4Board.getBoard()[i][j].getPlayer() == NO_PLAYER)) {
					testing1 = false;
				}
			}
		}
		
		if(testing1 == true) {
			System.out.println("C4Board.fillBoard Test One Evaluated: Correct");
		} else {
			System.out.println("C4Board.fillBoard Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Board.placeCounter Test One
		 * Calls the method after the constructors for an C4 Game and board
		 */
		m_c4Board = new C4Board();
		m_c4Counter = new C4Counter();
		m_c4Game = new C4Game();
				
		try {
			m_c4Board.placeCounter(m_c4Counter, m_c4Game.getOnScreenCounters());
			System.out.println("C4Board.placeCounter Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Board.placeCounter Test One Evaluated: Incorrect");
		}
	}
}
