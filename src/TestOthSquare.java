
/**
 * @author Tom Werner
 * @brief A test for OthSquare
 * @details
 *         
 * OthSquare.setlegal is tested one time(s).
 * OthSquare.draw and OthSquare.releaseTexture cannot be tested in isolation.
 * 
 */
public class TestOthSquare {

	private static OthSquare othSquare;
	
	public static void main(String[] args) {
		
	
		/*
		 * OthSquare.setLegal Test One
		 * Called after constructing a square object with 0 values
		 */
		othSquare = new OthSquare(0,0,0,0,true);
		othSquare.setlegal(true);
		
		if(othSquare.islegal() == true) {
			System.out.println("OthSquare.setlegal Test One Evaluated: Correct");
		} else {
			System.out.println("OthSquare.setlegal Test One Evaluated: Incorrect");
		}
		
			
	}
}
