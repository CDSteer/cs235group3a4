/**
 * @file TestOthInput.java
 * @detail A test class for OthInput.java
 * 
 * 		   OthInput.inputLoop is tested one time(s).
 * 		   
 *         
 * @author Tom
 *
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class TestOthInput {
	
	private static OthInput othInput;
	
	public static void main(String[] args) {
		
		/*
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