/**
 * @author Thomas Werner
 * @date 25/2/2014
 * @version 1.0.3 
 * @brief Provides the win condition for a game of C4,
 * to be evaluated after every player move.
 */
public class C4Rules {
	
	// Constants used by the class
	private final int ROW_LENGTH = 10;
	private final int COLUMN_LENGTH = 7;
	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	
	private final int EMPTY = 0;
	private final int WIN_LENGTH = 4;
	
	// integers for holding current line length
	private int m_RowLineOne = 0;
	private int m_RowLineTwo = 0;
	private int m_ColLineOne = 0;
	private int m_ColLineTwo = 0;
	private int m_DownDiagLineOne = 0;
	private int m_DownDiagLineTwo = 0;
	private int m_UpDiagLineOne = 0;
	private int m_UpDiagLineTwo = 0;
	
	// boolean variables for if a player has won
	private boolean m_PlayerOneWin = false;
	private boolean m_PlayerTwoWin = false;
	
	// variables for analysing the board state
	private C4Square[][] m_currentBoard;
	private C4Square m_currentSquare;
	
	
	
	// Accessor methods for class variables
	/**
	 * get row line one
	 * @return m_RowLineOne
	 */
	private int getRowLineOne() {
		return m_RowLineOne;
	}
	
	/**
	 * set row line one
	 * @param value
	 */
	private void setRowLineOne(int value) {
		m_RowLineOne = value;
	}
	
	/**
	 * get row line two
	 * @return m_RowLineTwo
	 */
	private int getRowLineTwo() {
		return m_RowLineTwo;
	}
	
	/**
	 * set row line two
	 * @param value
	 */
	private void setRowLineTwo(int value) {
		m_RowLineTwo = value;
	}
	
	/**
	 * get column line one
	 * @return m_ColLineOne
	 */
	private int getColLineOne() {
		return m_ColLineOne;
	}
	
	/**
	 * set column line one
	 * @param value
	 */
	private void setColLineOne(int value) {
		m_ColLineOne = value;
	}
	
	/**
	 * get column line two
	 * @return m_ColLineTwo
	 */
	private int getColLineTwo() {
		return m_ColLineTwo;
	}
	
	/**
	 * set column line two
	 * @param value
	 */
	private void setColLineTwo(int value) {
		m_ColLineTwo = value;
	}
	
	/**
	 * get down diag line one
	 * @return m_DownDiagLineOne
	 */
	private int getDownDiagLineOne() {
		return m_DownDiagLineOne;
	}
	
	/**
	 * set down diag line one
	 * @param value
	 */
	private void setDownDiagLineOne(int value) {
		m_DownDiagLineOne = value;
	}
	
	/**
	 * get down diag line two
	 * @return m_DownDiagLineTwo
	 */
	private int getDownDiagLineTwo() {
		return m_DownDiagLineTwo;
	}
	
	/**
	 * set down diag line two
	 * @param value
	 */
	private void setDownDiagLineTwo(int value) {
		m_DownDiagLineTwo = value;
	}
	
	/** 
	 * get up diag line one
	 * @return m_UpDiagLineOne
	 */
	private int getUpDiagLineOne() {
		return m_UpDiagLineOne;
	}
	
	/**
	 * set up diag line one
	 * @param value
	 */
	private void setUpDiagLineOne(int value) {
		m_UpDiagLineOne = value;
	}
	
	/**
	 * get up diag line two
	 * @return m_UpDiagLineTwo
	 */
	private int getUpDiagLineTwo() {
		return m_UpDiagLineTwo;
	}
	
	/**
	 * set up diag line two
	 * @param value
	 */
	private void setUpDiagLineTwo(int value) {
		m_UpDiagLineTwo = value;
	}
	
	/**
	 * get player one win
	 * @return m_PlayerOneWin
	 */
	private boolean getPlayerOneWin() {
		return m_PlayerOneWin;
	}
	
	/**
	 * set that player one wins
	 * @param value
	 */
	private void setPlayerOneWin(boolean value) {
		m_PlayerOneWin = value;
	}
	
	/**
	 * get player two win state
	 * @return m_PlayerTwoWin
	 */
	private boolean getPlayerTwoWin() {
		return m_PlayerTwoWin;
	}
	
	/**
	 * set player two win state
	 * @param value
	 */
	private void setPlayerTwoWin(boolean value) {
		m_PlayerTwoWin = value;
	}
	
	/**
	 * get the current board state
	 * @return m_currentBoard
	 */
	private C4Square[][] getCurrentBoard() {
		return m_currentBoard;
	}
	
	/**
	 * set current board state
	 * @param board
	 */
	private void setCurrentBoard(C4Square[][] board) {
		m_currentBoard = board;
	}
	
	/**
	 * get current c4 square state
	 * @return m_currentSquare
	 */
	private C4Square getCurrentSquare() {
		return m_currentSquare;
	}
	
	/**
	 * set current c4 square state
	 * @param square
	 */
	private void setCurrentSquare(C4Square square) {
		m_currentSquare = square;
	}
	
	// Accessor methods end
	
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
	
		setCurrentBoard(board.getBoard());
		
		checkColumns();
		checkRows();
		checkDownDiag();
		checkUpDiag();
		
		if (getPlayerOneWin() == true) {
			return PLAYER_ONE;
		} else if (getPlayerTwoWin() == true) {
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
			setColLineOne(EMPTY);
			setColLineTwo(EMPTY);
			
			// Loops through Columns
			for (int y = 0; y < COLUMN_LENGTH; y++) {
				
				// Analyses the current Square indicated by the index
				setCurrentSquare(getCurrentBoard()[y][x]);
				if (getCurrentSquare().getPlayer() == PLAYER_ONE) {
					setColLineOne(getColLineOne() + 1);
					setColLineTwo(EMPTY);
				} else if (getCurrentSquare().getPlayer() == PLAYER_TWO) {
					setColLineTwo(getColLineTwo() + 1);
					setColLineOne(EMPTY);
				} else {
					setColLineOne(EMPTY);
					setColLineTwo(EMPTY);
				}
				
				// Check if a win condition was reached
				if (getColLineOne() >= WIN_LENGTH) {
					setPlayerOneWin(true);
				}
				
				if (getColLineTwo() >= WIN_LENGTH) {
					setPlayerTwoWin(true);
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
			setRowLineOne(EMPTY);
			setRowLineTwo(EMPTY);
			
			// Loops through Rows
			for (int x = 0; x < ROW_LENGTH; x++) {
				
				// Analyses the current Square indicated by the index
				setCurrentSquare(getCurrentBoard()[y][x]);
				if (getCurrentSquare().getPlayer() == PLAYER_ONE) {
					setRowLineOne(getRowLineOne() + 1);
					setRowLineTwo(EMPTY);
				} else if (getCurrentSquare().getPlayer() == PLAYER_TWO) {
					setRowLineTwo(getRowLineTwo() + 1);
					setRowLineOne(EMPTY);
				} else {
					setRowLineOne(EMPTY);
					setRowLineTwo(EMPTY);
				}
				
				// Check if a win condition was reached
				if (getRowLineOne() >= WIN_LENGTH) {
					setPlayerOneWin(true);
				}
				
				if (getRowLineTwo() >= WIN_LENGTH) {
					setPlayerTwoWin(true);
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
				
				setDownDiagLineOne(EMPTY);
				setDownDiagLineTwo(EMPTY);
				
				// Loops through a diagonal direction (opposite to UpDiag)
				setCurrentSquare(getCurrentBoard()[y][x]);
				downDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y+1][x+1]);
				downDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y+2][x+2]);
				downDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y+3][x+3]);
				downDiagSquares(getCurrentSquare());			
			}
		}
	}
	
	/**
	 * Checks individual tiles as called by the checkDownDiag() method
	 * and updates the player boolean.
	 */
	private void downDiagSquares(C4Square square) {
			
		// Analyses the current Square indicated by the index		
		if (getCurrentSquare().getPlayer() == PLAYER_ONE) {
			setDownDiagLineOne(getDownDiagLineOne() + 1);
			setDownDiagLineTwo(EMPTY);
		} else if (getCurrentSquare().getPlayer() == PLAYER_TWO) {
			setDownDiagLineTwo(getDownDiagLineTwo() + 1);
			setDownDiagLineOne(EMPTY);
		} else {
			setDownDiagLineOne(EMPTY);
			setDownDiagLineTwo(EMPTY);
		}
		
		// Check if a win condition was reached
		if (getDownDiagLineOne() >= WIN_LENGTH) {
			setPlayerOneWin(true);
		}
				
		if (getDownDiagLineTwo() >= WIN_LENGTH) {
			setPlayerTwoWin(true);
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

				setUpDiagLineOne(EMPTY);
				setUpDiagLineTwo(EMPTY);
				
				// Loops through a diagonal direction (opposite to DownDiag)
				setCurrentSquare(getCurrentBoard()[y][x]);
				upDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y-1][x+1]);
				upDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y-2][x+2]);
				upDiagSquares(getCurrentSquare());
				
				setCurrentSquare(getCurrentBoard()[y-3][x+3]);
				upDiagSquares(getCurrentSquare());
								
			}
		}
	}
	
	/**
	 * Checks individual tiles as called by the checkUpDiag() method
	 * and updates the player boolean.
	 */
	private void upDiagSquares(C4Square square) {
			
		// Analyses the current Square indicated by the index		
		if (getCurrentSquare().getPlayer() == PLAYER_ONE) {
			setUpDiagLineOne(getUpDiagLineOne() + 1);
			setUpDiagLineTwo(EMPTY);
		} else if (getCurrentSquare().getPlayer() == PLAYER_TWO) {
			setUpDiagLineTwo(getUpDiagLineTwo() + 1);
			setUpDiagLineOne(EMPTY);
		} else {
			setUpDiagLineOne(EMPTY);
			setUpDiagLineTwo(EMPTY);
		}
		
		// Check if a win condition was reached
		if (getUpDiagLineOne() >= WIN_LENGTH) {
			setPlayerOneWin(true);
		}
				
		if (getUpDiagLineTwo() >= WIN_LENGTH) {
			setPlayerTwoWin(true);
		}
	}
	
	
}
	
	
	
	
	
	
	
