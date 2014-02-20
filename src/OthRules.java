
/**
 * OthRules Class
 * @author Thomas Werner
 * @since 20/2/2014
 * @version 1.0.0
 * 			-update 20/2/2014
 * WORK IN PROGRESS!!
 * Provides the win condition for a game of Othello,
 * to be evaluated after every player move.
 */
public class OthRules { // extends GameRules (temporarily taken out)

	private final int NO_WINNER = 0;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private int player1Counters = 0;
	private int player2Counters = 0;
	private final int OTH_ROWS = 8;
	private final int OTH_COLUMNS = 8;
	private OthSquare[][] currentBoard;
	private OthSquare currentSquare;
	
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
}
