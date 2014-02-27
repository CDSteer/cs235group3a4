/**
 * @mainpage	Software Engineering 2 - Group3 PDM Assignment 4
 * 
 * @file 	Main.java
 * @author 	Jamie Irving Davies, Cameron Steer
 * @date	January 28, 2014
 * @see		http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
 * @version	1.1.2
 * @brief	Main class for GUI Splash
 * @details	Main class for displaying gui splash window to allow the player to select which game to play
 * 
 */

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    public static void main(String args[]) throws InterruptedException, IOException {
        /** call GUI method */
        GUI gui = new GUI();
        gui.initGUI();
    }


}