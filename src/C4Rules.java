
/**
 * C4Rules Class
 * @author Thomas Werner
 * @since 11/2/2014
 * @version *1.0.2*
 * 			-update 20/2/2014
 * WORK IN PROGRESS!!
 * Provides the win condition for a game of C4,
 * to be evaluated after every player move.
 */
public class C4Rules { // extends GameRules (temporarily taken out)
	
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private final int NO_WINNER = 0;
	private int RowLineOne = 0;
	private int RowLineTwo = 0;
	private int ColLineOne = 0;
	private int ColLineTwo = 0;
	private int DownDiagLineOne = 0;
	private int DownDiagLineTwo = 0;
	private int UpDiagLineOne = 0;
	private int UpDiagLineTwo = 0;
	private final int EMPTY = 0;
	private final int WIN_LENGTH = 4;
	private boolean PlayerOneWin = false;
	private boolean PlayerTwoWin = false;
	private final int ROW_LENGTH = 10;
	private final int COLUMN_LENGTH = 7;
	private C4Square[][] currentBoard;
	private C4Square currentSquare;
	private boolean testing = false;
	
	/** 
	 * Constructor
	 * Could put something about setting the integers for players here
	 */
	public C4Rules() {}
	
	/* Takes a Board object as input and analyses it
	 * Returns an int representing a player:
	 * 0 : Player One
	 * 1 : Player Two
	 * 2 : No Winner
	 */
	 
	/**
	 *  Takes a C4Board object as input and reviews if a player has won
	 * according to the rules of Connect4
	 * @param C4Board
	 * @return int
	 */
	public int winCondition(C4Board board) {
	
		currentBoard = board.getBoard();
		
//		if (testing == true) {
//			// Loops through Rows
//			for (int x = 0; x < ROW_LENGTH; x++) {
//				// Loops through Columns
//				for (int y = 0; y < COLUMN_LENGTH; y++) {
//					testSquare = currentBoard[y][x];
//					System.out.print(testSquare.getPlayer());
//				}
//			}
//		}



		checkColumns();
		checkRows();
		checkDownDiag();
		checkUpDiag();
		
		if (PlayerOneWin == true) {
			return PLAYER_ONE;
		} else if (PlayerTwoWin == true) {
			return PLAYER_TWO;
		} else {
			return NO_WINNER;
		}
		
	}
	
	/**
	 * Checks the Board Columns (vertical) for 4 counters in a row
	 * @param null
	 * @return null
	 */
	private void checkColumns() {
		
		// Loops through Rows
		for (int x = 0; x < ROW_LENGTH; x++) {
			// ColLineOne = EMPTY;
			// ColLineTwo = EMPTY;
			// Loops through Columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
			
				if (testing == true) { System.out.println(ColLineOne); }
				// Checks if a win condition was reached by a previous loop
				if (RowLineOne >= WIN_LENGTH || ColLineOne >= WIN_LENGTH || DownDiagLineOne >= WIN_LENGTH || UpDiagLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (RowLineTwo >= WIN_LENGTH || ColLineTwo >= WIN_LENGTH || DownDiagLineTwo >= WIN_LENGTH || UpDiagLineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
				
				// Analyses the current Square indicated by the index
				currentSquare = currentBoard[y][x];
				if (currentSquare.getPlayer() == PLAYER_ONE) {
					ColLineOne++;
					ColLineTwo = EMPTY;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					ColLineTwo++;
					ColLineOne = EMPTY;
				} else {
					ColLineOne = EMPTY;
					ColLineTwo = EMPTY;
				}
			}
		}
	}
	
	/**
	 * Checks the Board Rows (horizontal) for 4 counters in a row
	 * @param null
	 * @return null
	 */
	private void checkRows() {
		
		// Loops through Columns
		for (int y = 0; y < COLUMN_LENGTH; y++) {
			// RowLineOne = EMPTY;
			// RowLineTwo = EMPTY;
			// Loops through Rows
			for (int x = 0; x < ROW_LENGTH; x++) {
			
				// Checks if a win condition was reached by a previous loop
				if (RowLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (RowLineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
				
				// Analyses the current Square indicated by the index
				currentSquare = currentBoard[y][x];
				if (currentSquare.getPlayer() == PLAYER_ONE) {
					RowLineOne++;
					RowLineTwo = EMPTY;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					RowLineTwo++;
					RowLineOne = EMPTY;
				} else {
					RowLineOne = EMPTY;
					RowLineTwo = EMPTY;
				}
			}
		}
	}
	
	/**
	 * Checks the Board DownwardDiagonal (TopLeft -> BottomRight) for 4 counters in a row
	 * @param null
	 * @return null
	 */
	private void checkDownDiag() {
	
		// Loops through Rows
		for (int x = 0; (x + 3) < ROW_LENGTH; x++) {
			// DownDiagLineOne = EMPTY;
			// DownDiagLineTwo = EMPTY;
			// Loops through Columns
			for (int y = 0; ( y + 3) < COLUMN_LENGTH; y++) {
				// DownDiagLineOne = EMPTY;
				// DownDiagLineTwo = EMPTY;
				// Loops through a diagonal direction (opposite to UpDiag)
				currentSquare = currentBoard[y][x];
				downDiagSquares(currentSquare);
				currentSquare = currentBoard[y+1][x+1];
				downDiagSquares(currentSquare);
				currentSquare = currentBoard[y+2][x+2];
				downDiagSquares(currentSquare);
				currentSquare = currentBoard[y+3][x+3];
				downDiagSquares(currentSquare);				
			}
		}
	}
	/**
	* Description plz~
	* @param C4Square
	* @return null
	*/
	private void downDiagSquares(C4Square square) {
		// Checks if a win condition was reached by a previous loop
		if (DownDiagLineOne >= WIN_LENGTH) {
			PlayerOneWin = true;
		}
		
		if (DownDiagLineTwo >= WIN_LENGTH) {
			PlayerTwoWin = true;
		}
		
		// Analyses the current Square indicated by the index
		
		if (currentSquare.getPlayer() == PLAYER_ONE) {
			DownDiagLineOne++;
			DownDiagLineTwo = EMPTY;
		} else if (currentSquare.getPlayer() == PLAYER_TWO) {
			DownDiagLineTwo++;
			DownDiagLineOne = EMPTY;
		} else {
			DownDiagLineOne = EMPTY;
			DownDiagLineTwo = EMPTY;
		}
	}
		
	/**
	 * Checks the Board UpwardsDiagonal (BottomLeft -> TopRight) for 4 counters in a row
	 * @param null
	 * @return null
	 */
	private void checkUpDiag() {
	
		// Loops through rows
		for (int x = 0; x < (ROW_LENGTH - 3); x++) {
			// UpDiagLineOne = EMPTY;
			// UpDiagLineTwo = EMPTY;
			// Loops through columns
			for (int y = 3; y < COLUMN_LENGTH ; y++) {
				// UpDiagLineOne = EMPTY;
				// UpDiagLineTwo = EMPTY;
				// Loops through a diagonal direction (opposite to DownDiag)
				currentSquare = currentBoard[y][x];
				upDiagSquares(currentSquare);
				currentSquare = currentBoard[y-1][x+1];
				upDiagSquares(currentSquare);
				currentSquare = currentBoard[y-2][x+2];
				upDiagSquares(currentSquare);
				currentSquare = currentBoard[y-3][x+3];
				upDiagSquares(currentSquare);	
					
				
			}
		}
	}
	
	/**
	* Description plz~
	* @param C4Square
	* @return null
	*/
	private void upDiagSquares(C4Square square) {
		
		// Checks if a win condition was reached by a previous loop
		if (UpDiagLineOne >= WIN_LENGTH) {
			PlayerOneWin = true;
		}
		
		if (UpDiagLineTwo >= WIN_LENGTH) {
			PlayerTwoWin = true;
		}
		
		
		// Analyses the current Square indicated by the index		
		if (currentSquare.getPlayer() == PLAYER_ONE) {
			UpDiagLineOne++;
			UpDiagLineTwo = EMPTY;
		} else if (currentSquare.getPlayer() == PLAYER_TWO) {
			UpDiagLineTwo++;
			UpDiagLineOne = EMPTY;
		} else {
			UpDiagLineOne = EMPTY;
			UpDiagLineTwo = EMPTY;
		}
	}
}
	
	
	
	
	
	