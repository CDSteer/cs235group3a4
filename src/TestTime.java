/**
 * @author Tom Werner
 * @brief A test for Time
 * @details
 * 
 * Time.getFrameRate is tested one time(s)
 *          
 */
public class TestTime {
	
	private static final int EXPECTED_FRAME_RATE = 60;
	
	private static Time timeTest;
	
	public static void main(String[] args) {
		
		/*
		 * Time.getFrameRate Test One
		 * Frame Rate is in Frames per second
		 */
		timeTest = new Time();
		if(timeTest.getFrameRate() == EXPECTED_FRAME_RATE) {
			System.out.println("Time.getFrameRate Test One Evaluated: Correct");
		} else {
			System.out.println("Time.getFrameRate Test One Evaluated: Incorrect");
		}
		
	}
}
