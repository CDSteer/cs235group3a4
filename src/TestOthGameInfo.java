
/**
 * @file TestOthGameInfo.java
 * @brief A test class for OthGameInfo
 * 
 * 		OthGameInfo.draw is tested one time(s).
 * 		Message methods cannot be called in isolation.
 * 
 * @author Tom
 *
 */
public class TestOthGameInfo {
	
	
	public static void main(String[] args) {
		
		/*
		 * OthGameInfo.draw Test One
		 * Call the method from a static context
		 */
		try {
			OthGameInfo.draw();
			System.out.println("OthGameInfo.draw Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthGameInfo.draw Test One Evaluated: Incorrect");
		}
		
		
	}
}
