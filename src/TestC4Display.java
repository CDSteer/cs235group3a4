/**
 * @author Tom Werner
 * @brief A test for C4Display
 * @details
 * 
 * C4Display.loadTextures is tested one time(s)
 * C4Display.render cannot be called in isolation.
 *          
 */
public class TestC4Display {

	private static C4Display m_c4Display;
	
	public static void main(String[] args) {
		
		/*
		 * C4Display.loadTextures Test One
		 * Call method after constructor
		 */
		m_c4Display = new C4Display();
		try {
			m_c4Display.loadTextures();
			System.out.println("C4Display.loadTextures Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Display.loadTextures Test One Evaluated: Incorrect");
		}
		
	}

}
