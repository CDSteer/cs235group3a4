
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

	private static OthSquare m_othSquare;
	
	public static void main(String[] args) {
		
	
		/*
		 * OthSquare.setLegal Test One
		 * Called after constructing a square object with 0 values
		 */
		m_othSquare = new OthSquare(0,0,0,0,true);
		m_othSquare.setlegal(true);
		
		if(m_othSquare.islegal() == true) {
			System.out.println("OthSquare.setlegal Test One Evaluated: Correct");
		} else {
			System.out.println("OthSquare.setlegal Test One Evaluated: Incorrect");
		}
		
			
	}
}
