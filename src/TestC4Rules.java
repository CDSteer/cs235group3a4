/**
 * @brief A test class for C4Rules
 * @details
 * 
 * 		   C4Rules.winCondition is tested 3 times.
 * 
 * @author Tom Werner
 *
 */
public class TestC4Rules {

	// Constants used by the class
	private static final int C4_ROWS = 10;
	private static final int C4_COLUMNS = 7;
	private static final int NO_WINNER = 0;
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	
	// Constants used in testing
	private static final int WINNING_LENGTH = 4;
	private static final int LEFT_BORDER = 0;
	private static final int RIGHT_BORDER = 7;
	
	private static C4Rules m_c4Rules;

	public static void main(String[] args) {
		
				
		/*
		 * C4Rules.winCondition Test One:
		 * Vertical line of player1 squares on left edge
		 */
		m_c4Rules = new C4Rules();
		C4Board testBoard1 = new C4Board();
		
		for(int i = 0; i < WINNING_LENGTH; i++) {
			C4Square testSquare1 = new C4Square(0,0,0,0,true);
			testSquare1.setPlayer(PLAYER_ONE);
			testBoard1.getBoard()[i][LEFT_BORDER] = testSquare1;			
		}
		
		if(m_c4Rules.winCondition(testBoard1) == PLAYER_ONE) {
			System.out.println("C4Rules.winCondition Test One Evaluated: Correct");
		} else {
			System.out.println("C4Rules.winCondition Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Rules.winCondition Test Two:
		 * Vertical line of player2 squares on right edge
		 */
		m_c4Rules = new C4Rules();
		C4Board testBoard2 = new C4Board();
		for(int i = 0; i < WINNING_LENGTH; i++) {
			C4Square testSquare2 = new C4Square(0,0,0,0,true);
			testSquare2.setPlayer(PLAYER_TWO);
			testBoard2.getBoard()[i][RIGHT_BORDER] = testSquare2;			
		}
		
		if(m_c4Rules.winCondition(testBoard2) == PLAYER_TWO) {
			System.out.println("C4Rules.winCondition Test Two Evaluated: Correct");
		} else {
			System.out.println("C4Rules.winCondition Test Two Evaluated: Incorrect");
		}
		
		/*
		 * C4Rules.winCondition Test Three:
		 * A blank board
		 */
		m_c4Rules = new C4Rules();
		C4Board testBoard3 = new C4Board();
			
		if(m_c4Rules.winCondition(testBoard3) == NO_WINNER) {
			System.out.println("C4Rules.winCondition Test Two Evaluated: Correct");
		} else {
			System.out.println("C4Rules.winCondition Test Two Evaluated: Incorrect");
		}
		
				
		
	}
}