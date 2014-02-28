
/**
 * @author Tom Werner
 * @brief A test for C4Square
 * @details
 *         
 * C4Square.getPlayer is tested one time(s). 
 */
public class TestC4Square {

	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;

	private static C4Square c4Square;
	
	public static void main(String[] args) {
		
		/*
		 * C4Square.getPlayer Test One
		 * Testing of the setPlayer and getPlayer methods for C4Square
		 */
		c4Square = new C4Square(0,0,0,0,true);
		c4Square.setPlayer(PLAYER_ONE);
		
		if(c4Square.getPlayer() == PLAYER_ONE) {
			System.out.println("C4Square.getPlayer Test One Evaluates: Correct");
		} else {
			System.out.println("C4Square.getPlayer Test One Evaluates: Incorrect");
		}
		
	}
}