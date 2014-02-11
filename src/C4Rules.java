
/*
 * C4Rules Class
 * Thomas Werner
 * Draft 1
 * Last Edit 11th Feb 2014
 *
 * WORK IN PROGRESS!!
 * Provides the win condition for a game of C4,
 * to be evaluated after every player move.
 */
public class C4Rules extends GameRules {
	
	private final int PLAYER_ONE = 0;
	private final int PLAYER_TWO = 1;
	private final int NO_WINNER = 2;
	private int LineOne = 0;
	private int LineTwo = 0;
	private final int WIN_LENGTH = 4;
	private boolean PlayerOneWin = false;
	private boolean PlayerTwoWin = false;
	private final int ROW_LENGTH = 10;
	private final int COLUMN_LENGTH = 7;
	private Square[][] currentBoard;
	private Square currentSquare;
	
	/* Constructor
	 * Could put something about setting the integers for players here
	 */
	public C4Rules() {}
	
	/* Takes a Board object as input and analyses it
	 * Returns an int representing a player:
	 * 0 : Player One
	 * 1 : Player Two
	 * 2 : No Winner
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
	
	/*
	 * Checks the Board Columns (vertical) for 4 counters in a row
	 */
	private void checkColumns() {
		
		// Loops through Rows
		for (int x = 0; x < ROW_LENGTH; x++) {
			// Loops through Columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
			
				// Checks if a win condition was reached by a previous loop
				if (LineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (LineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
				
				// Analyses the current Square indicated by the index
				currentSquare = currentBoard[x][y];
				if (currentSquare.getPlayer() == PLAYER_ONE) {
					LineOne++;
					LineTwo = 0;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					LineTwo++;
					LineOne = 0;
				} else {
					LineOne = 0;
					LineTwo = 0;
				}
			}
		}
	}
	
	/*
	 * Checks the Board Rows (horizontal) for 4 counters in a row
	 */
	private void checkRows() {
		
		// Loops through Columns
		for (int y = 0; y < COLUMN_LENGTH; y++) {
			// Loops through Rows
			for (int x = 0; x < ROW_LENGTH; x++) {
			
				// Checks if a win condition was reached by a previous loop
				if (LineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
				}
				
				if (LineTwo >= WIN_LENGTH) {
					PlayerTwoWin = true;
				}
				
				// Analyses the current Square indicated by the index
				currentSquare = currentBoard[x][y];
				if (currentSquare.getPlayer() == PLAYER_ONE) {
					LineOne++;
					LineTwo = 0;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					LineTwo++;
					LineOne = 0;
				} else {
					LineOne = 0;
					LineTwo = 0;
				}
			}
		}
	}
	
	/*
	 * Checks the Board DownwardDiagonal (TopLeft -> BottomRight) for 4 counters in a row
	 */
	private void checkDownDiag() {
	
		// Loops through Rows
		for (int x = 0; x < ROW_LENGTH; x++) {
			// Loops through Columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
				// Loops through a diagonal direction (opposite to UpDiag)
				for( int a = x, b = y ; a < ROW_LENGTH && b < COLUMN_LENGTH ;  a++, b++ ) {
				
					// Checks if a win condition was reached by a previous loop
					if (LineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
					}
					
					if (LineTwo >= WIN_LENGTH) {
						PlayerTwoWin = true;
					}
					
					// Analyses the current Square indicated by the index
					currentSquare = currentBoard[a][b];
					
					if (currentSquare.getPlayer() == PLAYER_ONE) {
						LineOne++;
						LineTwo = 0;
					} else if (currentSquare.getPlayer() == PLAYER_TWO) {
						LineTwo++;
						LineOne = 0;
					} else {
						LineOne = 0;
						LineTwo = 0;
					}
				}
			}
		}
	}
	
	/*
	 * Checks the Board UpwardsDiagonal (BottomLeft -> TopRight) for 4 counters in a row
	 */
	private void checkUpDiag() {
	
		// Loops through rows
		for (int x = 0; x < ROW_LENGTH; x++) {
			// Loops through columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
				// Loops through a diagonal direction (opposite to DownDiag)
				for( int a = x, b = y ;  a < ROW_LENGTH && b >= 0 ;  a++, b-- ) {
				
					// Checks if a win condition was reached by a previous loop
					if (LineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
					}
					
					if (LineTwo >= WIN_LENGTH) {
						PlayerTwoWin = true;
					}
					
					// Analyses the current Square indicated by the index
					currentSquare = currentBoard[a][b];
					
					if (currentSquare.getPlayer() == PLAYER_ONE) {
						LineOne++;
						LineTwo = 0;
					} else if (currentSquare.getPlayer() == PLAYER_TWO) {
						LineTwo++;
						LineOne = 0;
					} else {
						LineOne = 0;
						LineTwo = 0;
					}
				}
			}
		}
	}	
}
	
	
	
	
	
	