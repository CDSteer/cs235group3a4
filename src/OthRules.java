
/**
 * @file OthRules.java
 * @author Thomas Werner
 * @date 25/2/2014
 * @version 1.0.1
 *
 * @details Provides the win condition for a game of Othello,
 * 			to be evaluated after every player move.
 * 			Provides method for flipping counters
 * 			Provides method for calculating available moves for players
 */
public class OthRules { // extends GameRules (temporarily taken out)

	private final int OTH_ROWS = 8;
	private final int OTH_COLUMNS = 8;
	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private final int BOTH_PLAYERS = 3;
	private final int NO_MATCH = 0;
	
	private int player1Counters;
	private int player2Counters;
	
	private OthCounter currentCounter;
	private OthCounter checkCounter;
	private int[][] validMoves;	
	private int current_x;
	private int current_y;
	
	

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

		player1Counters = 0;
		player2Counters = 0;

		for(int i = 0; i < OTH_ROWS; i++) {
			for (int j = 0; j < OTH_COLUMNS; j++) {

				currentCounter = board[j][i];
				if(currentCounter.getPlayer() == PLAYER_ONE) {
					player1Counters++;
				} else if(currentCounter.getPlayer() == PLAYER_TWO) {
					player2Counters++;
				}
			}
		}

		if (player1Counters > player2Counters) {
			return PLAYER_ONE;
		} else if (player2Counters > player1Counters) {
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
		System.out.println("col: " + col);
		System.out.println("row " + row);
	


		// Vertical Down first
		if(col + 1 != OTH_COLUMNS && initialBoard[col+1][row].getPlayer() != NO_MATCH) {
			VD: for (int j = col + 1; j < OTH_COLUMNS; j++) {			
				checkCounter = initialBoard[j][row];		
				if(checkCounter.getPlayer() == player) {
					for(int y = j; y > col; y--) {
						initialBoard[y][row].setPlayer(player);						
					}
					break VD;
				}				
			}
		}
		
		
		// Vertical Up
		if(col != 0 && initialBoard[col-1][row].getPlayer() != NO_MATCH) {
			VD: for (int j = col - 1; j >= 0; j--) {		
				checkCounter = initialBoard[j][row];
				if(checkCounter.getPlayer() == player) {
					for(int y = j; y < col; y++) {
						initialBoard[y][row].setPlayer(player);						
					}
					break VD;
				}
				
			}
		}

		
		
		
		// Rows right
		if(row + 1 != OTH_ROWS && initialBoard[col][row+1].getPlayer() != NO_MATCH) {
			RR: for(int i = row + 1; i < OTH_ROWS; i++) {		
				checkCounter = initialBoard[col][i];
				if(checkCounter.getPlayer() == player) {
					for(int x = i; x > row; x--) {
						initialBoard[col][x].setPlayer(player);
					}
					break RR;
				}
				
			}
		}

		// Rows left
		if(row != 0 && initialBoard[col][row-1].getPlayer() != NO_MATCH) {
			RL: for(int i = row - 1; i >= 0; i--) {		
				checkCounter = initialBoard[col][i];
				if(checkCounter.getPlayer() == player) {
					for(int x = i; x < row; x++) {
						initialBoard[col][x].setPlayer(player);
					}
					break RL;
				}
				
			}
		}

		
		
		// Diagonal up-right
		if(col != 0 && row + 1 != OTH_ROWS && initialBoard[col-1][row+1].getPlayer() != NO_MATCH) {
			DUR: for (int i = row + 1, j = col - 1; i < OTH_ROWS && j >= 0; i++, j--) {
				checkCounter = initialBoard[j][i];
				if(checkCounter.getPlayer() == player) {
					for(int x = i - 1, y = j + 1; x > row && y < col; x--, y++) {
						initialBoard[y][x].setPlayer(player);
					}
					break DUR;
				}
			}
		}
		
		// Diagonal up-left
		if(col!= 0 && row != 0 && initialBoard[col-1][row-1].getPlayer() != NO_MATCH) {
			DUL: for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
				checkCounter = initialBoard[j][i];
				if(checkCounter.getPlayer() == player) {
					for(int x = i + 1, y = j + 1; x < row && y < col; x++, y++) {
						initialBoard[y][x].setPlayer(player);
					}
					break DUL;
				}
			}
		}
		
		// Diagonal down-right
		if(col + 1 != OTH_COLUMNS && row + 1 != OTH_ROWS && initialBoard[col+1][row+1].getPlayer() != NO_MATCH) {
			DDR: for(int i = row + 1, j = col + 1; i < OTH_ROWS && j < OTH_COLUMNS; i++, j++) {
				checkCounter = initialBoard[j][i];
				if(checkCounter.getPlayer() == player) {
					for(int x = i - 1, y = j - 1; x > row && y > col; x--, y--) {
						initialBoard[y][x].setPlayer(player);
					}
					break DDR;
				}
			}
		}
		
		// Diagonal down-left
		if(col + 1 != OTH_COLUMNS && row != 0 && initialBoard[col+1][row-1].getPlayer() != NO_MATCH) {
			DDL: for(int i = row - 1, j = col + 1; i >= 0 && j < OTH_COLUMNS; i--, j++) {
				checkCounter = initialBoard[j][i];
				if(checkCounter.getPlayer() == player) {
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
	 * validMoves[col][row] = 0; No Player has a valid move here
	 * validMoves[col][row] = 1; Player 1 has a valid move here
	 * validMoves[col][row] = 2; Player 2 has a valid move here
	 * validMoves[col][row] = 3; Both players have a valid move here
	 *
	 * @param board An array holding the current board state
	 * @return The validMoves[][] array of integer values representing players
	 */
	public int[][] checkValidSet(OthCounter[][] board) {
		
		validMoves = new int[OTH_COLUMNS][OTH_ROWS];
		
		// Sets all tiles to 0 (no player has a valid move)
		for(int j = 0; j < OTH_COLUMNS; j++) {
			for (int i = 0; i < OTH_ROWS; i++) {
				validMoves[j][i] = NO_MATCH;
			}
		}
		
		// Analyses each tile for valid moves, using the input array
		for(int j = 0; j < OTH_COLUMNS; j++) {
			for (int i = 0; i < OTH_ROWS; i++) {
			
				current_y = j;
				current_x = i;
				// Checking for valid moves is done for each player individually
				checkAvailableMatch(board, j, i, PLAYER_ONE);
				checkAvailableMatch(board, j, i, PLAYER_TWO);
				
					
				
			}
		}
		
		return validMoves;
	
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
		if((col + 1) != OTH_COLUMNS) {
			if( (board[col+1][row].getPlayer() != player) && (board[col+1][row].getPlayer() != NO_MATCH) ) {
				VD: for (int j = col + 2; j < OTH_COLUMNS; j++) {
					checkCounter = board[j][row];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break VD;
					}
				}
			}
		}
		
		// Vertical up
		if(col != 0) {
			if( (board[col-1][row].getPlayer() != player) && (board[col-1][row].getPlayer() != NO_MATCH) ) {
				VU: for (int j = col - 2; j >= 0; j--) {		
					checkCounter = board[j][row];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break VU;
					}
				}
			}
		}
		
		// Rows right
		if((row + 1) != OTH_ROWS) {
			if( (board[col][row+1].getPlayer() != player) && (board[col][row+1].getPlayer() != NO_MATCH) ) {
				RR: for(int i = row + 2; i < OTH_ROWS; i++) {
					checkCounter = board[col][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break RR;
					}
				}
			}
		}
		
		// Rows left
		if(row != 0) {
			if( (board[col][row-1].getPlayer() != player) && (board[col][row-1].getPlayer() != NO_MATCH) ) {
				RL: for(int i = row - 2; i >= 0; i--) {			
					checkCounter = board[col][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break RL;
					}
				}
			}
		}
		
		// Diagonal up-right
		if(col != 0 && (row + 1) != OTH_ROWS) {
			if( (board[col-1][row+1].getPlayer() != player) && (board[col-1][row+1].getPlayer() != NO_MATCH) ) {
				DUR: for (int i = row + 2, j = col - 2; i < OTH_ROWS && j >= 0; i++, j--) {
					checkCounter = board[j][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break DUR;
					}
				}
			}
		}
		
		// Diagonal up-left
		if(col != 0 && row != 0) {
			if( (board[col-1][row-1].getPlayer() != player) && (board[col-1][row-1].getPlayer() != NO_MATCH) ) {
				DUL: for (int i = row - 2, j = col - 2; i >= 0 && j >= 0; i--, j--) {
					checkCounter = board[j][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break DUL;
					}
				}
			}
		}
				
		// Diagonal down-right
		if(col + 1 != OTH_COLUMNS && row + 1 != OTH_ROWS) {
			if( (board[col+1][row+1].getPlayer() != player) && (board[col+1][row+1].getPlayer() != NO_MATCH) ) {
				DDR: for(int i = row + 2, j = col + 2; i < OTH_ROWS && j < OTH_COLUMNS; i++, j++) {
					checkCounter = board[j][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break DDR;
					}
				}
			}
		}
		
		// Diagonal down-left
		if(col + 1 != OTH_COLUMNS && row != 0) {
			if( (board[col+1][row-1].getPlayer() != player) && (board[col+1][row-1].getPlayer() != NO_MATCH) ) {
				DDL: for(int i = row - 2, j = col + 2; i >= 0 && j < OTH_COLUMNS; i--, j++) {
					checkCounter = board[j][i];
					checkPlayerMatch(player);
					if(checkCounter.getPlayer() == 0) {
						break DDL;
					}
				}
			}
		}
		
		
	}
	
	/**
	 * This method updates whether there is a valid move at [current_y][current_x]
	 * based on the analysis of the current counter stored in checkCounter .
	 * 
	 * @param player An integer value representing which player is being checking
	 */
	private void checkPlayerMatch(int player) {
		
		if (checkCounter.getPlayer() == NO_MATCH) {
			return;
		} else if (checkCounter.getPlayer() == player) {
			if(validMoves[current_y][current_x] == BOTH_PLAYERS) {
				// do nothing
			} else if(validMoves[current_y][current_x] == NO_MATCH) {
				validMoves[current_y][current_x] = player;
			} else if(validMoves[current_y][current_x] != player) {
				validMoves[current_y][current_x] = BOTH_PLAYERS;
			}
		} 
	
	}
	
			
				
}

