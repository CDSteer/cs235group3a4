/**
 * @mainpage	Software Engineering 2 - Group3 PDM Assignment 4
 * 
 * @author Jamie I Davies, Cameron Steer
 * @date 28/01/2014
 * @since 27/02/2014
 * @see	http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
 * @version	1.1.2
 * @brief Main class for GUI Splash
 * @details	Main class for displaying gui splash window to allow the player to select which game to play 
 */

import org.lwjgl.openal.AL;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    /**
     * main method to create new SplashScreen and then initiate the GUI
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
	public static void main(String args[]) throws InterruptedException, IOException {
        /** call GUI method */
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.initGUI();
        if (AL.isCreated()){
            AL.destroy();
        }
    }


}