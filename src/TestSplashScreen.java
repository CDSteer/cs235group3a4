/**
 * @author Tom Werner
 * @brief A test for SplashScreen
 * @details
 * 
 * SplashScreen.initGUI is tested one time(s)
 *          
 */
public class TestSplashScreen {

	private static SplashScreen screen;
	
	public static void main(String[] args) {
		
		screen = new SplashScreen();
		try {
			screen.initGUI();
			System.out.println("SplashScreen.initGUI Test One Evaluated: Correct");
		} catch(Exception e) {
			System.out.println("SplashScreen.initGUI Test One Evaluated: Incorrect");			
		}
		
		
	}
}
