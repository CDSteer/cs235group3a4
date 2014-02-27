/**
 * @author Tom Werner
 * @brief A test class for C4Counter
 * @details 
 *  		   
 * C4Counter.playPlaceSound is tested one time(s).
 * C4Counter.playNegSound is tested one time(s).
 * C4Counter.playDropSound is tested one time(s).
 * C4Counter.dropCounter is tested one time(s).
 * The constructor C4Game calls the method C4Game.setSoundFiles.
 */
public class TestC4Counter {

	private static final int TEST_VALUE = 20;
	
	private static C4Counter c4Counter;
	
	public static void main(String[] args) {
		
		/*
		 * C4Counter.playPlaceSound Test One
		 * Call the method after the constructor has been called
		 * Constructor calls the C4Counter.setSoundFiles method
		 */
		c4Counter = new C4Counter();
		try {
			c4Counter.playPlaceSound();
			System.out.println("C4Counter.playPlaceSound Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Counter.playPlaceSound Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Counter.playNegSound Test One
		 * Call the method after the constructor has been called
		 * Constructor calls the C4Counter.setSoundFiles method
		 */
		c4Counter = new C4Counter();
		try {
			c4Counter.playNegSound();
			System.out.println("C4Counter.playNegSound Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Counter.playNegSound Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Counter.playDropSound Test One
		 * Call the method after the constructor has been called
		 * Constructor calls the C4Counter.setSoundFiles method
		 */
		c4Counter = new C4Counter();
		try {
			c4Counter.playDropSound();
			System.out.println("C4Counter.playDropSound Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Counter.playDropSound Test One Evaluated: Incorrect");
		}
		
		/*
		 * C4Counter.dropCounter Test One
		 * Call the method after the constructor has been called
		 */
		c4Counter = new C4Counter();
		try {
			c4Counter.dropCounter(TEST_VALUE);
			System.out.println("C4Counter.dropCounter Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Counter.dropCounter Test One Evaluated: Incorrect");
		}
		
		
		
	}
}
