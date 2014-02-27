/**
 * @brief A test class for C4Input
 * @details
 * 		   
 * C4Input.inputLoop is tested one time(s).
 *         
 * @author Tom Werner
 *
 */

import org.lwjgl.input.Keyboard;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class TestC4Input {
	
	private static C4Input c4Input;
	
	/**
	 * main method containing tests
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * C4Input.inputLoop Test One
		 */
		c4Input = new C4Input();
		
		try {
			Display.create();
			Keyboard.create();
		} catch (LWJGLException e) {
			System.out.println("C4Input.inputLoop Test One Evaluated: Incorrect");
		}
		C4Counter testCounter1 = new C4Counter();
		try {
			c4Input.inputLoop(testCounter1);
			System.out.println("C4Input.inputLoop Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Input.inputLoop Test One Evaluated: Incorrect");
		}
	}
}
