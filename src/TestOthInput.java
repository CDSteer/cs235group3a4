/**
 * @brief A test class for OthInput
 * @details
 * 
 * OthInput.inputLoop is tested one time(s).
 * @author Tom Werner
 *
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class TestOthInput {
	
	private static OthInput othInput;
	
	/**
	 * main method containing tests
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * OthInput.inputLoop Test One
		 */
		othInput = new OthInput();
		
		try {
			Display.create();
		} catch (LWJGLException e) {
			System.out.println("OthInput.inputLoop Test One Evaluated: Incorrect");
		}
		OthGame testGame = new OthGame();
		try {
			othInput.inputLoop(testGame);
			System.out.println("OthInput.inputLoop Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("OthInput.inputLoop Test One Evaluated: Incorrect");
		}
	}
}