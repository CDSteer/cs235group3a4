/**
 * @author Tom Werner
 * @brief A test for SplashScreen
 * @details
 * 
 * SplashScreen.initGUI is tested one time(s)
 *          
 */
public class TestSplashScreen {

	private static SplashScreen m_screen;
	
	public static void main(String[] args) {
		
		/*
		 * SplashScreen.initGUI Test One
		 */
		
		m_screen = new SplashScreen();
		try {
			m_screen.initGUI();
			System.out.println("SplashScreen.initGUI Test One Evaluated: Correct");
		} catch(Exception e) {
			System.out.println("SplashScreen.initGUI Test One Evaluated: Incorrect");			
		}
		
		
	}
}
