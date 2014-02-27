
/**
 * @file TestC4Board
 * @detail A test for C4Board.java
 *         
 *         C4Board.fillBoard is tested one time(s).
 *         C4Board.placeCounter is tested one time(s).       
 *         
 * @author Tom
 *
 */
public class TestC4Board {
	
	private static final int ROW = 10;
	private static final int COLUMN = 7;
	private static final int NO_PLAYER = 0;
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	
	
	private static C4Game c4Game;
	private static C4Counter c4Counter;
	private static C4Board c4Board;
	
	public static void main(String[] args) {
		
		/*
		 * C4Board.fillBoard Test One
		 */
		c4Board = new C4Board();
		c4Game = new C4Game();
		
		c4Board.fillBoard();
		
		boolean testing1 = true;
		for(int i = 0; i < COLUMN; i++) {
			for(int j = 0; j < ROW; j++) {
				if(!(c4Board.getBoard()[i][j].getPlayer() == NO_PLAYER)) {
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
		c4Board = new C4Board();
		c4Counter = new C4Counter();
		c4Game = new C4Game();
				
		try {
			c4Board.placeCounter(c4Counter, c4Game.getOnScreenCounters());
			System.out.println("C4Board.placeCounter Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Board.placeCounter Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Board.draw ?
		 */
		
		
		
		
	}
}
