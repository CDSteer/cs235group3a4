
/**
 * @file C4Rules.java
 * @author Thomas Werner
 * @date 25/2/2014
 * @version 1.0.2
 * 	
 * 
 * @details Provides the win condition for a game of C4,
 * to be evaluated after every player move.
 */
public class C4Rules { // extends GameRules (temporarily taken out)
	
	private final int ROW_LENGTH = 10;
	private final int COLUMN_LENGTH = 7;
	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	
	// integers for holding current line length
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
	
	private C4Square[][] currentBoard;
	private C4Square currentSquare;
	
	/** 
	 * Constructor
	 */
	public C4Rules() {}
	
	/**
	 * Takes a C4Board object as input and reviews if a player has won
	 * according to the rules of Connect4.
	 * @param board The current board being played. Holds 2d array of counters
	 * @return An integer representing the winning player; 0: No winner, 1: Player One, 2: Player Two.
	 */
	public int winCondition(C4Board board) {
	
		currentBoard = board.getBoard();
		
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
	 * Checks the board Columns (vertical) for 4 counters in a row, 
	 * and sets the corresponding player boolean to true if found.
	 */
	private void checkColumns() {
		
		// Loops through Rows
		for (int x = 0; x < ROW_LENGTH; x++) {
			ColLineOne = EMPTY;
			ColLineTwo = EMPTY;
			
			// Loops through Columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
				
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
				
				// Check if a win condition was reached
				if (ColLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (ColLineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
			}
		}
	}
	
	/**
	 * Checks the board Rows (horizontal) for 4 counters in a row,
	 * and sets the corresponding player boolean to true if found.
	 */
	private void checkRows() {
		
		// Loops through Columns
		for (int y = 0; y < COLUMN_LENGTH; y++) {
			RowLineOne = EMPTY;
			RowLineTwo = EMPTY;
			
			// Loops through Rows
			for (int x = 0; x < ROW_LENGTH; x++) {
				
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
				
				// Check if a win condition was reached
				if (RowLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (RowLineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
			}
		}
	}
	
	/**
	 * Checks the Board DownwardDiagonal (TopLeft -> BottomRight) for 4 counters in a row.
	 * For each array index, 4 tiles in the diagonal direction are checked and the player
	 * boolean updated if necessary.
	 */
	private void checkDownDiag() {
	
		// Loops through Rows
		for (int x = 0; (x + 3) < ROW_LENGTH; x++) {

			// Loops through Columns
			for (int y = 0; ( y + 3) < COLUMN_LENGTH; y++) {
				
				DownDiagLineOne = EMPTY;
				DownDiagLineTwo = EMPTY;
				
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
	 * Checks individual tiles as called by the checkDownDiag() method
	 * and updates the player boolean.
	 */
	private void downDiagSquares(C4Square square) {
			
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
		
		// Check if a win condition was reached
		if (DownDiagLineOne >= WIN_LENGTH) {
			PlayerOneWin = true;
		}
				
		if (DownDiagLineTwo >= WIN_LENGTH) {
			PlayerTwoWin = true;
		}
		
	}
		
	/**
	 * Checks the Board UpwardsDiagonal (BottomLeft -> TopRight) for 4 counters in a row
	 * For each array index, 4 tiles in the diagonal direction are checked and the player
	 * boolean updated if necessary.
	 */
	private void checkUpDiag() {
	
		// Loops through rows
		for (int x = 0; x < (ROW_LENGTH - 3); x++) {

			// Loops through columns
			for (int y = 3; y < COLUMN_LENGTH ; y++) {

				UpDiagLineOne = EMPTY;
				UpDiagLineTwo = EMPTY;
				
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
	 * Checks individual tiles as called by the checkUpDiag() method
	 * and updates the player boolean.
	 */
	private void upDiagSquares(C4Square square) {
			
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
		
		// Check if a win condition was reached
		if (UpDiagLineOne >= WIN_LENGTH) {
			PlayerOneWin = true;
		}
				
		if (UpDiagLineTwo >= WIN_LENGTH) {
			PlayerTwoWin = true;
		}
	}
	
	
}
	
	
	
	
	
	