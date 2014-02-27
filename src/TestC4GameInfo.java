/**
 * @file TestC4GameInfo.java
 * @brief A test class for C4GameInfo
 * 
 * 		C4GameInfo.draw is tested one time(s).
 * 
 * @author Tom
 *
 */
public class TestC4GameInfo {
	
	private static C4GameInfo c4GameInfo;
	
	public static void main(String[] args) {
		
		/*
		 * C4GameInfo.draw Test One
		 */
		try {
			C4GameInfo.draw();
			System.out.println("C4GameInfo.draw Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4GameInfo.draw Test One Evaluated: Incorrect");
		}
	}

}
