/**
 * @brief A test class for OthCounter
 * @details
 * 
 * 		   OthCounter.playPlaceSound is tested one time(s).
 * 		   OthCounter.playNegSound is tested one time(s).
 * 		   The constructor OthGame() calls the method OthGame.setSoundFiles.
 * 		   
 * @author Tom Werner
 *
 */
public class TestOthCounter {

	private static final int NO_PLAYER = 0;
	
	private static OthCounter othCounter;
	
	public static void main(String[] args) {
		
		/*
		 * OthCounter.playPlaceSound Test One
		 * Call the method after the constructor has been called
		 * Constructor calls the OthCounter.setSoundFiles method
		 */
		othCounter = new OthCounter(NO_PLAYER);
		try {
			othCounter.playPlaceSound();
			System.out.println("OthCounter.playPlaceSound Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthCounter.playPlaceSound Test One Evaluated: Incorrect");
		}
		
		/*
		 * OthCounter.playNegSound Test One
		 * Call the method after the constructor has been called
		 * Constructor calls the OthCounter.setSoundFiles method
		 */
		othCounter = new OthCounter(NO_PLAYER);
		try {
			othCounter.playNegSound();
			System.out.println("OthCounter.playNegSound Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthCounter.playNegSound Test One Evaluated: Incorrect");
		}
		
		
	}
}
