
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
	private final int WIN_LENGTH = 4;
	private boolean PlayerOneWin = false;
	private boolean PlayerTwoWin = false;
	private final int ROW_LENGTH = 10;
	private final int COLUMN_LENGTH = 7;
	private Square[][] currentBoard;
	private Square currentSquare;
	private Square testSquare;
	private boolean testing = false;
	
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
		
		if (testing == true) {
			// Loops through Rows
			for (int x = 0; x < ROW_LENGTH; x++) {
				// Loops through Columns
				for (int y = 0; y < COLUMN_LENGTH; y++) {
					testSquare = currentBoard[y][x];
					System.out.print(testSquare.getPlayer());
				}
			}
		}
		
		
		
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
					ColLineTwo = 0;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					ColLineTwo++;
					ColLineOne = 0;
				} else {
					ColLineOne = 0;
					ColLineTwo = 0;
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
					RowLineTwo = 0;
				} else if (currentSquare.getPlayer() == PLAYER_TWO) {
					RowLineTwo++;
					RowLineOne = 0;
				} else {
					RowLineOne = 0;
					RowLineTwo = 0;
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
					if (DownDiagLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
					}
					
					if (DownDiagLineTwo >= WIN_LENGTH) {
						PlayerTwoWin = true;
					}
					
					// Analyses the current Square indicated by the index
					currentSquare = currentBoard[b][a];
					
					if (currentSquare.getPlayer() == PLAYER_ONE) {
						DownDiagLineOne++;
						DownDiagLineTwo = 0;
					} else if (currentSquare.getPlayer() == PLAYER_TWO) {
						DownDiagLineTwo++;
						DownDiagLineOne = 0;
					} else {
						DownDiagLineOne = 0;
						DownDiagLineTwo = 0;
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
					if (UpDiagLineOne >= WIN_LENGTH) {
					PlayerOneWin = true;
					}
					
					if (UpDiagLineTwo >= WIN_LENGTH) {
						PlayerTwoWin = true;
					}
					
					// Analyses the current Square indicated by the index
					currentSquare = currentBoard[b][a];
					
					if (currentSquare.getPlayer() == PLAYER_ONE) {
						UpDiagLineOne++;
						UpDiagLineTwo = 0;
					} else if (currentSquare.getPlayer() == PLAYER_TWO) {
						UpDiagLineTwo++;
						UpDiagLineOne = 0;
					} else {
						UpDiagLineOne = 0;
						UpDiagLineTwo = 0;
					}
				}
			}
		}
	}	
}
	
	
	
	
	
	