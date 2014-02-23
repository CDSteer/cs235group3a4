

/**
 * OthRules Class
 * @author Thomas Werner
 * @since 20/2/2014
 * @version 1.0.0
 * 			-update 20/2/2014
 * WORK IN PROGRESS!!
 * For the sake of your sanity, don't try and understand this code yet
 * unless you enjoy pain
 *
 *
 * Provides the win condition for a game of Othello,
 * to be evaluated after every player move.
 * Provides method for flipping counters
 * Provides method for calculating avaiable moves for players
 */
public class OthRules { // extends GameRules (temporarily taken out)

	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private final int BOTH_PLAYERS = 3;
	private int player1Counters = 0;
	private int player2Counters = 0;
	private final int OTH_ROWS = 8;
	private final int OTH_COLUMNS = 8;
	private OthSquare[][] currentBoard;
	private OthSquare currentSquare;
	private int[][] newBoard;
	private OthSquare[][] oldBoard;
	private int[][] validMoves;
	private OthSquare checkSquare;
	private int current_x;
	private int current_y;
	private boolean matched;
	private int matchedPlayer;
	private final int NO_MATCH = 0;
	

	/** 
	 * Constructor
	 * Could put something about setting the integers for players here
	 */
	public OthRules() {}

	/**
	 * Takes an OthBoard object as input and reviews if a player has won
	 * according to the rules of Othello
	 * @param C4Board
	 * @return int
	 */
	public int winCondition(OthBoard board) {

		currentBoard = board.getBoard();

		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {
				currentSquare = currentBoard[i][j];
				if(currentSquare.getPlayer() == PLAYER_ONE) { // not sure if getPlayer() method currently exists
					player1Counters++;
				} else if(currentSquare.getPlayer() == PLAYER_TWO) {
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
	
	/*
	 * Takes as input: the old board state before the move, and two ints for the row/column of the requested move
	 * also needs an int for the player making the move
	 *
	 * Returns an array int[][] that represents the new board state
	 * where:
	 * array[a][b] = 0 for no counter
	 * array[a][b] = 1 for player 1
	 * array[a][b] = 2 for player 2
	 */
	public int[][] flipCounters(OthBoard initialBoard, int row, int col, int player) {
		
		oldBoard = initialBoard.getBoard();
		
		// Set newBoard with the player numbers from before the move
		for(int a = 0; a < OTH_COLUMNS; a++) {
			for (int b = 0; b < OTH_ROWS; a++) {
				currentSquare = oldBoard[a][b];
				newBoard[a][b] = currentSquare.getPlayer();
			}
		}
		
		// Ridiculous explanation:
		// Attempts to go in one direction until it hits a square where
		// checkSquare.getPlayer == player (i.e. a square that matches the input square's player)
		// Then it backtracks until it reaches the initial input square, swapping all squares along the way
		// to that of the input player
		// IN THEORY!
		// The for loop parameters are always exact opposites for the first/second parts
		
		int i = col;
		int j = row;
		
		// Vertical down first
		for(i = col + 1; i < OTH_COLUMNS; i++) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(i = i - 1; i > col; i --) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Vertical up
		for(i = col - 1; i >= 0; i --) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(i = i + 1; i < col; i ++) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Rows right
		for(j = row + 1; j < OTH_ROWS; j ++) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j - 1; j > row; j--) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Rows left
		for(j = row - 1 ; j >= 0; j --) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j + 1; j < row; j++) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Diagonal up-right
		for(j = row + 1, i = col - 1; j < OTH_ROWS && i >= 0 ; j ++, i--) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j - 1, i = i + 1; j > row && i < col; j--, i++) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Diagonal up-left -
		for(j = row - 1 , i = col - 1; j >= 0 && i >= 0 ; j --, i--) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j + 1, i = i + 1; j < row && i < col; j++, i++) {
					newBoard[i][j] = player;
				}
			}
		}
				
		// Diagonal down-right
		for(j = row + 1 , i = col + 1; j < OTH_ROWS && i < OTH_COLUMNS ; j ++, i++) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j - 1, i = i - 1; j > row && i > col; j--, i--) {
					newBoard[i][j] = player;
				}
			}
		}
		
		// Diagonal down-left
		for(j = row - 1, i = col + 1; j >= 0 && i < OTH_COLUMNS ; j --, i++) {
			checkSquare = oldBoard[i][j];
			if(checkSquare.getPlayer() == player) {
				for(j = j + 1, i = i - 1; j < row && i > col; j++, i--) {
					newBoard[i][j] = player;
				}
			}
		}
	
		
		return newBoard;
	}
		
		
	
	
	/*
	 * Takes as input: the board state 
	 *
	 * Returns an array int[][] that represents the avaiable moves for players
	 * where:
	 * array[a][b] = 0 for neither player can move
	 * array[a][b] = 1 for player 1 can move
	 * array[a][b] = 2 for player 2 can move
	 * array[a][b] = 3 for both players can move
	 *
	 * IN THEORY!
	 */
	public int[][] checkValidSet(OthBoard board) {
		
		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {
				validMoves[i][j] = NO_MATCH;
			}
		}
		
		currentBoard = board.getBoard();
		
		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {
			
				current_y = i;
				current_x = j;
				checkAvailableMatch(board, i, j);
					
				
			}
		}
		
		return validMoves;
	
	}
	
	private void checkAvailableMatch(OthBoard board, int col, int row) {
		
		int i = col;
		int j = row;
		
		// Vertical down first
		for(i = col + 1; i < OTH_COLUMNS; i++) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Vertical up
		for(i = col - 1; i >= 0; i --) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Rows right
		for(j = row + 1; j < OTH_ROWS; j ++) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Rows left
		for(j = row - 1 ; j >= 0; j --) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Diagonal up-right
		for(j = row + 1, i = col - 1; j < OTH_ROWS && i >= 0 ; j ++, i--) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Diagonal up-left
		for(j = row - 1 , i = col - 1; j >= 0 && i >= 0 ; j --, i--) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
				
		// Diagonal down-right
		for(j = row + 1 , i = col + 1; j < OTH_ROWS && i < OTH_COLUMNS ; j ++, i++) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
		
		// Diagonal down-left
		for(j = row - 1, i = col + 1; j >= 0 && i < OTH_COLUMNS ; j --, i++) {
			checkSquare = currentBoard[i][j];
			checkPlayerMatch();
		}
	}
	
	private void checkPlayerMatch() {
		
		if	(checkSquare.getPlayer() == PLAYER_ONE) {
			if(validMoves[current_y][current_x] == PLAYER_TWO) {
				validMoves[current_y][current_x] = BOTH_PLAYERS;
			} else {
				validMoves[current_y][current_x] = PLAYER_ONE;
			}
		} else if (checkSquare.getPlayer() == PLAYER_TWO) {
			if(validMoves[current_y][current_x] == PLAYER_ONE) {
				validMoves[current_y][current_x] = BOTH_PLAYERS;
			} else {
				validMoves[current_y][current_x] = PLAYER_TWO;
			}
		}
	}
		
				
		
				
}
	