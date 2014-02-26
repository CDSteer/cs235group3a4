
/**
 * @file OthRules.java
 * @author Thomas Werner
 * @date 25/2/2014
 * @version 1.0.2
 *
 * @details Provides the win condition for a game of Othello,
 * 			to be evaluated after every player move.
 * 			Provides method for flipping counters
 * 			Provides method for calculating available moves for players
 */
public class OthRules { // extends GameRules (temporarily taken out)

	// Constants used by the class
	private final int OTH_ROWS = 8;
	private final int OTH_COLUMNS = 8;
	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private final int BOTH_PLAYERS = 3;
	private final int NO_MATCH = 0;
	
	// variables holding counter numbers
	private int m_player1Counters;
	private int m_player2Counters;
	
	private OthCounter m_currentCounter;
	private OthCounter m_checkCounter;
	private int[][] m_validMoves;	
	private int m_currentX;
	private int m_currentY;
	
	// Accessor methods for class variables
	
	private int getPlayer1Counters() {
		return m_player1Counters;
	}
	
	private void setPlayer1Counters(int value) {
		m_player1Counters = value;
	}
	
	private int getPlayer2Counters() {
		return m_player2Counters;
	}
	
	private void setPlayer2Counters(int value) {
		m_player2Counters = value;
	}
	
	private OthCounter getCurrentCounter() {
		return m_currentCounter;
	}
	
	private void setCurrentCounter(OthCounter counter) {
		m_currentCounter = counter;
	}
	
	private OthCounter getCheckCounter() {
		return m_checkCounter;
	}
	
	private void setCheckCounter(OthCounter counter) {
		m_checkCounter = counter;
	}
	
	private int[][] getValidMoves() {
		return m_validMoves;
	}
	
	private void setValidMoves(int[][] array) {
		m_validMoves = array;
	}
	
	private int getCurrentX() {
		return m_currentX;
	}
	
	private void setCurrentX(int value) {
		m_currentX = value;
	}
	
	private int getCurrentY() {
		return m_currentY;
	}
	
	private void setCurrentY(int value) {
		m_currentY = value;
	}
	
	// Accessor methods end
	
	/** 
	 * Constructor
	 */
	public OthRules() {}
	
	
	/**
	 * Takes a 2D array of OthCounter objects as input and reviews if a player has won
	 * according to the rules of Othello
	 * 
	 * @param board An array holding the current board state
	 * @return An integer representing the winning player; 0: No winner, 1: Player One, 2: Player Two.
	 */
	public int winCondition(OthCounter[][] board) {

		setPlayer1Counters(0);
		setPlayer2Counters(0);

		for(int i = 0; i < OTH_ROWS; i++) {
			for (int j = 0; j < OTH_COLUMNS; j++) {

				setCurrentCounter(board[j][i]);
				if(getCurrentCounter().getPlayer() == PLAYER_ONE) {
					setPlayer1Counters(getPlayer1Counters() + 1);
				} else if(getCurrentCounter().getPlayer() == PLAYER_TWO) {
					setPlayer2Counters(getPlayer2Counters() + 1);
				}
			}
		}

		if (getPlayer1Counters() > getPlayer2Counters()) {
			return PLAYER_ONE;
		} else if (getPlayer2Counters() > getPlayer1Counters()) {
			return PLAYER_TWO;
		} else {
			return NO_WINNER;
		}
		
	}
	
	/**
	 * This method handles changing of counters between players after a move has been made.
	 * For the array index specified by [col][row], it attempts to move in all 8 directions
	 * until it finds a counter of the same player colour or is stopped by an empty tile.
	 * After finding a matching counter, all tiles between these 2 points are swapped to the same colour.
	 * Note: Does no checking for valid moves, and so must only be called after valid move checking is done.
	 *
	 * @param initialBoard An array holding the current board state
	 * @param col The column value for the requested move
	 * @param row The row value for the requested move
	 * @param player The player value for the requested move
	 */
	public void flipCounters(OthCounter[][] initialBoard, int col, int row, int player) {

		// Vertical Down first
		flipVerticalDown(initialBoard, col, row, player);
		
		// Vertical Up
		flipVerticalUp(initialBoard, col, row, player);
		
		// Rows right
		flipRowsRight(initialBoard, col, row, player);

		// Rows left
		flipRowsLeft(initialBoard, col, row, player);
				
		// Diagonal up-right
		flipDiagonalUpRight(initialBoard, col, row, player);
		
		// Diagonal up-left
		flipDiagonalUpLeft(initialBoard, col, row, player);
		
		// Diagonal down-right
		flipDiagonalDownRight(initialBoard, col, row, player);
		
		// Diagonal down-left
		flipDiagonalDownLeft(initialBoard, col, row, player);
					
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipVerticalDown(OthCounter[][] initialBoard, int col, int row, int player) {
		
		if(col + 1 != OTH_COLUMNS 
		&& initialBoard[col+1][row].getPlayer() != NO_MATCH) {
		
			VD: 
			for (int j = col + 1; j < OTH_COLUMNS; j++) {			
				setCheckCounter(initialBoard[j][row]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break VD;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int y = j; y > col; y--) {
					initialBoard[y][row].setPlayer(player);						
					}
					break VD;
				}				
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipVerticalUp(OthCounter[][] initialBoard, int col, int row, int player) {
		
		if(col != 0 && initialBoard[col-1][row].getPlayer() != NO_MATCH) {
		
			VU: 
			for (int j = col - 1; j >= 0; j--) {		
				setCheckCounter(initialBoard[j][row]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break VU;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int y = j; y < col; y++) {
						initialBoard[y][row].setPlayer(player);						
					}
					break VU;
				}				
			}
		}
	}	
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipRowsRight(OthCounter[][] initialBoard, int col, int row, int player) {
		
		if(row + 1 != OTH_ROWS && initialBoard[col][row+1].getPlayer() != NO_MATCH) {
		
			RR: 
			for(int i = row + 1; i < OTH_ROWS; i++) {		
				setCheckCounter(initialBoard[col][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break RR;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i; x > row; x--) {
						initialBoard[col][x].setPlayer(player);
					}
					break RR;
				}
				
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipRowsLeft(OthCounter[][] initialBoard, int col, int row, int player) {
		
		if(row != 0 && initialBoard[col][row-1].getPlayer() != NO_MATCH) {
		
			RL: 
			for(int i = row - 1; i >= 0; i--) {		
				setCheckCounter(initialBoard[col][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break RL;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i; x < row; x++) {
						initialBoard[col][x].setPlayer(player);
					}
					break RL;
				}
				
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipDiagonalUpRight(OthCounter[][] initialBoard, int col, int row, int player) {	
		
		if(col != 0 && row + 1 != OTH_ROWS 
		&& initialBoard[col-1][row+1].getPlayer() != NO_MATCH) {
		
			DUR: 
			for (int i = row + 1, j = col - 1; i < OTH_ROWS && j >= 0; i++, j--) {
				setCheckCounter(initialBoard[j][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break DUR;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i - 1, y = j + 1; x > row && y < col; x--, y++) {
						initialBoard[y][x].setPlayer(player);
					}
					break DUR;
				}
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipDiagonalUpLeft(OthCounter[][] initialBoard, int col, int row, int player) {	
		
		if(col!= 0 && row != 0 
		&& initialBoard[col-1][row-1].getPlayer() != NO_MATCH) {
		
			DUL: 
			for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
				setCheckCounter(initialBoard[j][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break DUL;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i + 1, y = j + 1; x < row && y < col; x++, y++) {
						initialBoard[y][x].setPlayer(player);
					}
					break DUL;
				}
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipDiagonalDownRight(OthCounter[][] initialBoard, int col, int row, int player) {
		if(col + 1 != OTH_COLUMNS && row + 1 != OTH_ROWS 
		&& initialBoard[col+1][row+1].getPlayer() != NO_MATCH) {
		
			DDR: 
			for(int i = row + 1, j = col + 1; i < OTH_ROWS && j < OTH_COLUMNS; i++, j++) {
				setCheckCounter(initialBoard[j][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break DDR;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i - 1, y = j - 1; x > row && y > col; x--, y--) {
						initialBoard[y][x].setPlayer(player);
					}
					break DDR;
				}
			}
		}
	}
	
	/** Specific direction flipping
	 * @brief see flipCounters for parameters
	 */
	private void flipDiagonalDownLeft(OthCounter[][] initialBoard, int col, int row, int player) {
	
		if(col + 1 != OTH_COLUMNS && row != 0 
		&& initialBoard[col+1][row-1].getPlayer() != NO_MATCH) {
		
			DDL: 
			for(int i = row - 1, j = col + 1; i >= 0 && j < OTH_COLUMNS; i--, j++) {
				setCheckCounter(initialBoard[j][i]);
				if(getCheckCounter().getPlayer() == NO_MATCH) {
					break DDL;
				} else if(getCheckCounter().getPlayer() == player) {
					for(int x = i + 1, y = j - 1; x < row && y > col; x++, y--) {
						initialBoard[y][x].setPlayer(player);
					}
					break DDL;
				}
			}
		}
	}
	
		
	/**
	 * This method creates a 2D array of integers, representing each tile on an Othello board, 
	 * where each integer value states which players have valid moves on this tile.
	 * The integer values are:
	 * 
	 * m_validMoves[col][row] = 0; No Player has a valid move here
	 * m_validMoves[col][row] = 1; Player 1 has a valid move here
	 * m_validMoves[col][row] = 2; Player 2 has a valid move here
	 * m_validMoves[col][row] = 3; Both players have a valid move here
	 *
	 * @param board An array holding the current board state
	 * @return The m_validMoves[][] array of integer values representing players
	 */
	public int[][] checkValidSet(OthCounter[][] board) {
		
		setValidMoves(new int[OTH_COLUMNS][OTH_ROWS]);
		
		// Sets all tiles to 0 (no player has a valid move)
		for(int j = 0; j < OTH_COLUMNS; j++) {
			for (int i = 0; i < OTH_ROWS; i++) {
				getValidMoves()[j][i] = NO_MATCH;
			}
		}
		
		// Analyses each tile for valid moves, using the input array
		for(int j = 0; j < OTH_COLUMNS; j++) {
			for (int i = 0; i < OTH_ROWS; i++) {
			
				setCurrentY(j);
				setCurrentX(i);
				// Checking for valid moves is done for each player individually
				checkAvailableMatch(board, j, i, PLAYER_ONE);
				checkAvailableMatch(board, j, i, PLAYER_TWO);
				
					
				
			}
		}
		
		return getValidMoves();
	
	}
	
	/**
	 * This method uses the current [col][row] value from the loop to analyse a specific tile,
	 * checking in all 8 directions if a line can be formed from the counter at the specified tile 
	 * to another counter of the same colour, with no empty tiles in between.
	 * 
	 * Note: 
	 * Before each direction is analysed, a small check is done to make sure the current array index
	 * is not on the edge of the board, as this would cause an out of bounds exception in the next steps.
	 * 
	 * Another check is done to disregard lines formed from matching adjacent counters of the same colour,
	 * as these do not form valid moves in Othello. Actual checking is then started at 2 tiles away in each direction.
	 * 
	 * @param board An array holding the current board state
	 * @param col The column value for the requested move
	 * @param row The row value for the requested move
	 * @param player The player value for the requested move
	 */
	private void checkAvailableMatch(OthCounter[][] board, int col, int row, int player) {
				
		// Vertical down first
		checkVerticalDown(board, col, row, player);
			
		// Vertical up
		checkVerticalUp(board, col, row, player);
		
		// Rows right
		checkRowsRight(board, col, row, player);
		
		// Rows left
		checkRowsLeft(board, col, row, player);
		
		// Diagonal up-right
		checkDiagonalUpRight(board, col, row, player);
			
		// Diagonal up-left
		checkDiagonalUpLeft(board, col, row, player);
				
		// Diagonal down-right
		checkDiagonalDownRight(board, col, row, player);
		
		// Diagonal down-left
		checkDiagonalDownLeft(board, col, row, player);
		
		
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkVerticalDown(OthCounter[][] board, int col, int row, int player) {
		
		if((col + 1) != OTH_COLUMNS) {
			if( (board[col+1][row].getPlayer() != player) 
			&& (board[col+1][row].getPlayer() != NO_MATCH) ) {
				
				VD: 
				for (int j = col + 2; j < OTH_COLUMNS; j++) {
					setCheckCounter(board[j][row]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break VD;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkVerticalUp(OthCounter[][] board, int col, int row, int player) {
		
		if(col != 0) {
			if( (board[col-1][row].getPlayer() != player) 
			&& (board[col-1][row].getPlayer() != NO_MATCH) ) {
				
				VU: 
				for (int j = col - 2; j >= 0; j--) {		
					setCheckCounter(board[j][row]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break VU;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkRowsRight(OthCounter[][] board, int col, int row, int player) {
		
		if((row + 1) != OTH_ROWS) {
			if( (board[col][row+1].getPlayer() != player) 
			&& (board[col][row+1].getPlayer() != NO_MATCH) ) {
				
				RR: 
				for(int i = row + 2; i < OTH_ROWS; i++) {
					setCheckCounter(board[col][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break RR;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkRowsLeft(OthCounter[][] board, int col, int row, int player) {
		
		if(row != 0) {
			if( (board[col][row-1].getPlayer() != player) 
			&& (board[col][row-1].getPlayer() != NO_MATCH) ) {
				
				RL: 
				for(int i = row - 2; i >= 0; i--) {			
					setCheckCounter(board[col][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break RL;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkDiagonalUpRight(OthCounter[][] board, int col, int row, int player) {
		
		if(col != 0 && (row + 1) != OTH_ROWS) {
			if( (board[col-1][row+1].getPlayer() != player) 
			&& (board[col-1][row+1].getPlayer() != NO_MATCH) ) {
				
				DUR: 
				for (int i = row + 2, j = col - 2; i < OTH_ROWS && j >= 0; i++, j--) {
					setCheckCounter(board[j][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break DUR;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkDiagonalUpLeft(OthCounter[][] board, int col, int row, int player) {
		
		if(col != 0 && row != 0) {
			if( (board[col-1][row-1].getPlayer() != player) 
			&& (board[col-1][row-1].getPlayer() != NO_MATCH) ) {
				
				DUL: 
				for (int i = row - 2, j = col - 2; i >= 0 && j >= 0; i--, j--) {
					setCheckCounter(board[j][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break DUL;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkDiagonalDownRight(OthCounter[][] board, int col, int row, int player) {
		
		if(col + 1 != OTH_COLUMNS && row + 1 != OTH_ROWS) {
			if( (board[col+1][row+1].getPlayer() != player) 
			&& (board[col+1][row+1].getPlayer() != NO_MATCH) ) {
				
				DDR: 
				for(int i = row + 2, j = col + 2; i < OTH_ROWS && j < OTH_COLUMNS; i++, j++) {
					setCheckCounter(board[j][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break DDR;
					}
				}
			}
		}
	}
	
	/** Specific direction checking
	 * @brief see checkVerticalSet for parameters
	 */
	private void checkDiagonalDownLeft(OthCounter[][] board, int col, int row, int player) {
		
		if(col + 1 != OTH_COLUMNS && row != 0) {
			if( (board[col+1][row-1].getPlayer() != player) 
			&& (board[col+1][row-1].getPlayer() != NO_MATCH) ) {
				
				DDL: 
				for(int i = row - 2, j = col + 2; i >= 0 && j < OTH_COLUMNS; i--, j++) {
					setCheckCounter(board[j][i]);
					checkPlayerMatch(player);
					if(getCheckCounter().getPlayer() == 0) {
						break DDL;
					}
				}
			}
		}
	}
	
	
	/**
	 * This method updates whether there is a valid move at [m_currentY][m_currentX]
	 * based on the analysis of the current counter stored in m_checkCounter .
	 * 
	 * @param player An integer value representing which player is being checking
	 */
	private void checkPlayerMatch(int player) {
		
		if (getCheckCounter().getPlayer() == NO_MATCH) {
			return;
		} else if (getCheckCounter().getPlayer() == player) {
			if(getValidMoves()[getCurrentY()][getCurrentX()] == BOTH_PLAYERS) {
				// do nothing
			} else if(getValidMoves()[getCurrentY()][getCurrentX()] == NO_MATCH) {
				getValidMoves()[getCurrentY()][getCurrentX()] = player;
			} else if(getValidMoves()[getCurrentY()][getCurrentX()] != player) {
				getValidMoves()[getCurrentY()][getCurrentX()] = BOTH_PLAYERS;
			}
		} 
	
	}
	
			
				
}

