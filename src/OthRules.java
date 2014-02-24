

/**
 * OthRules Class
 * @author Thomas Werner
 * @since 20/2/2014
 * @version 1.0.0
 * 			-update 20/2/2014
 * WORK IN PROGRESS!!
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
	private int player1Counters;
	private int player2Counters;
	private final int OTH_ROWS = 8;
	private final int OTH_COLUMNS = 8;
	private OthCounter[][] boardCounters;
	private OthSquare[][] currentBoard;
	private OthSquare currentSquare;
	private OthCounter currentCounter;
	private int[][] newBoard;
	private OthCounter[][] oldBoard;
	private int[][] validMoves;
	private OthCounter checkCounter;
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
	 * @param OthCounter[][]
	 * @return int
	 */
	// NOTE: Old methods with different parameters removed
	public int winCondition(OthCounter[][] board) {

		player1Counters = 0;
		player2Counters = 0;

		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {

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
	public void flipCounters(OthCounter[][] initialBoard, int col, int row, int player) {
		System.out.println("col: " + col);
		System.out.println("row " + row);
		
		
		newBoard = new int[OTH_COLUMNS][OTH_ROWS];
		
		/*
		 * NOTE!!!!!!!!:::::::
		 * ARRAY PLACES ARE IN THE FORM [COLUMN][ROW], IGNORE EVERYTHING ELSE, THIS IS THE WAY
		 */
		
		/*
		// Set newBoard with the player numbers from before the move
		for(int a = 0; a < OTH_ROWS; a++) {
			for (int b = 0; b < OTH_COLUMNS; b++) {
				currentCounter = initialBoard[a][b];
				newBoard[a][b] = currentCounter.getPlayer();
			}
		}
		*/
		
		// Ridiculous explanation:
		// Attempts to go in one direction until it hits a square where
		// checkCounter.getPlayer == player (i.e. a square that matches the input square's player)
		// Then it backtracks until it reaches the initial input square, swapping all squares along the way
		// to that of the input player
		// IN THEORY!
		// The for loop parameters are always exact opposites for the first/second parts
	


		// Vertical Down first
		VD: for (int j = col + 1; j < OTH_COLUMNS; j++) {			
			checkCounter = initialBoard[j][row];		
			if(checkCounter.getPlayer() == player) {
				for(int y = j; y > col; y--) {
					newBoard[y][row] = player;
					initialBoard[y][row].setPlayer(player);						
				}
				break VD;
			}
			
		}
		
		
		// Vertical Up
		VD: for (int j = col - 1; j >= 0; j--) {		
			checkCounter = initialBoard[j][row];
			if(checkCounter.getPlayer() == player) {
				for(int y = j; y < col; y++) {
					newBoard[y][row] = player;
					initialBoard[y][row].setPlayer(player);						
				}
				break VD;
			}
			
		}

		
		
		
		// Rows right
		RR: for(int i = row + 1; i < OTH_ROWS; i++) {		
			checkCounter = initialBoard[col][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i; x > row; x--) {
					newBoard[col][x] = player;
					initialBoard[col][x].setPlayer(player);
				}
				break RR;
			}
			
		}

		// Rows left 
		RL: for(int i = row - 1; i >= 0; i--) {
			
			checkCounter = initialBoard[col][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i; x < row; x++) {
					newBoard[col][x] = player;
					initialBoard[col][x].setPlayer(player);
				}
				break RL;
			}
			
		}

		
		
		// Diagonal up-right
		DUR: for (int i = row + 1, j = col - 1; i < OTH_ROWS && j >= 0; i++, j--) {
			checkCounter = initialBoard[j][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i - 1, y = j + 1; x > row && y < col; x--, y++) {
					newBoard[y][x] = player;
					initialBoard[y][x].setPlayer(player);
				}
				break DUR;
			}
		}
		
		// Diagonal up-left
		DUL: for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			checkCounter = initialBoard[j][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i + 1, y = j + 1; x < row && y < col; x++, y++) {
					newBoard[y][x] = player;
					initialBoard[y][x].setPlayer(player);
				}
				break DUL;
			}
		}
	
		// Diagonal down-right
		DDR: for(int i = row + 1, j = col + 1; i < OTH_ROWS && j < OTH_COLUMNS; i++, j++) {
			checkCounter = initialBoard[j][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i - 1, y = j - 1; x > row && y > col; x--, y--) {
					newBoard[y][x] = player;
					initialBoard[y][x].setPlayer(player);
				}
				break DDR;
			}
		}
		
		// Diagonal down-left
		DDL: for(int i = row - 1, j = col + 1; i >= 0 && j < OTH_COLUMNS; i--, j++) {
			checkCounter = initialBoard[j][i];
			if(checkCounter.getPlayer() == player) {
				for(int x = i + 1, y = j - 1; x < row && y > col; x++, y--) {
					newBoard[y][x] = player;
					initialBoard[y][x].setPlayer(player);
				}
				break DDL;
			}
		}
		
		
	
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
	
	// PROBABLY NOT WORKING YET, STILL ON [ROW][COLUMN], needs to be [COLUMN][ROW]
	public int[][] checkValidSet(OthCounter[][] board) {
		
		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {
				validMoves[j][i] = NO_MATCH;
			}
		}
		
		for(int i = 0; i < OTH_COLUMNS; i++) {
			for (int j = 0; j < OTH_ROWS; j++) {
			
				current_y = i;
				current_x = j;
				checkAvailableMatch(board, i, j);
					
				
			}
		}
		
		return validMoves;
	
	}
	
	private void checkAvailableMatch(OthCounter[][] board, int col, int row) {
		
		int i = col;
		int j = row;
		
		// Vertical down first
		for(i = col + 1; i < OTH_COLUMNS; i++) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Vertical up
		for(i = col - 1; i >= 0; i --) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Rows right
		for(j = row + 1; j < OTH_ROWS; j ++) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Rows left
		for(j = row - 1 ; j >= 0; j --) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Diagonal up-right
		for(j = row + 1, i = col - 1; j < OTH_ROWS && i >= 0 ; j ++, i--) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Diagonal up-left
		for(j = row - 1 , i = col - 1; j >= 0 && i >= 0 ; j --, i--) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
				
		// Diagonal down-right
		for(j = row + 1 , i = col + 1; j < OTH_ROWS && i < OTH_COLUMNS ; j ++, i++) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
		
		// Diagonal down-left
		for(j = row - 1, i = col + 1; j >= 0 && i < OTH_COLUMNS ; j --, i++) {
			checkCounter = board[j][i];
			checkPlayerMatch();
		}
	}
	
	private void checkPlayerMatch() {
		
		if	(checkCounter.getPlayer() == PLAYER_ONE) {
			if(validMoves[current_x][current_y] == PLAYER_TWO) {
				validMoves[current_x][current_y] = BOTH_PLAYERS;
			} else {
				validMoves[current_x][current_y] = PLAYER_ONE;
			}
		} else if (checkCounter.getPlayer() == PLAYER_TWO) {
			if(validMoves[current_x][current_y] == PLAYER_ONE) {
				validMoves[current_x][current_y] = BOTH_PLAYERS;
			} else {
				validMoves[current_x][current_y] = PLAYER_TWO;
			}
		}
	}
	
				
		
				
}
	