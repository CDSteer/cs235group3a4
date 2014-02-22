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

import org.lwjgl.opengl.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {

	public Main() {
		/** call GUI method */
		initGUI();
	}

	public void initGUI() {		      
        /** 2 cols 1 row JPanel */
		JPanel panel = new JPanel(new GridLayout(1,2));
	       getContentPane().add(panel);

	       /** initialise buttons, set fonts and tooltips */
	       JButton c4Button = new JButton("Play Connect 4!");
	       JButton othButton = new JButton("Play Othello!");
	       c4Button.setFont(new Font("Arial", Font.BOLD, 34));
	       othButton.setFont(new Font("Arial", Font.BOLD, 34));
	       c4Button.setToolTipText("Click Me to Play Connect 4!");
	       othButton.setToolTipText("Click Me to Play Othello! (Although we haven't done it yet..)");

	       /** c4 button action listener */
	       c4Button.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent event) {
	               initC4();
	          }
	       });

	     /** othello button action listener */
	       othButton.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent event) {
	               initOthello();
	          }
	       });

	       /** add buttons to the JPanel */
	       panel.add(c4Button);
	       panel.add(othButton);
	       //bobglasses
	       panel.add(new JLabel(new ImageIcon("bob.gif")));
	       
		/** initialise JFrame */
	    setTitle("A4 Partial Implementation : Group 3 ");
        setSize(1024, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
	}	

	/** initC4 method for calling C4 game board */
	public void initC4() {

        
        /** set up timer for C4 game */
        Time time = new Time();
        time.setUpTimer();
        
        /** display the C4 game board */
        C4Display display = new C4Display();
        C4Game game = new C4Game();
        C4Input gameInput = new C4Input();
        
        display.setUpDisplay();
        display.setUpOpenGL();
        C4Square.setTexture();

        while (game.isRunning()) {
            gameInput.inputLoop(game.getCurrentCounter(), game.getC4Board());
            game.gameLoop(game, time.getDelta());
            display.render(game.getC4Board(), game.getCurrentCounter(), game.getOnScreenCounters());
            Display.update();
            Display.sync(time.getFrameRate());
            if (Display.isCloseRequested()) {
                game.setRunning(false);
            }
        }
        
        /** kill game on close */
        Display.destroy();
        //System.exit(0);
	}

	/** initOthello method for calling Othello game board */
	public void initOthello() {
        /** set up timer for othello game */
        Time time = new Time();
        time.setUpTimer();

        /** display the othello game board */
        OthDisplay display = new OthDisplay();
        OthGame game = new OthGame();
        OthInput gameInput = new OthInput();

        display.setUpDisplay();
        display.setUpOpenGL();

        while (game.isRunning()) {
            gameInput.inputLoop(game);
            game.gameLoop(game, time.getDelta());
            display.render(game.getOthBoard(), game.getCurrentCounter(), game.getOnScreenCounters());
            Display.update();
            Display.sync(time.getFrameRate());
            if (Display.isCloseRequested()) {
                game.setRunning(false);
            }
        }
        Display.destroy();
        //System.exit(0);
	}

    public static void main(String args[]) throws InterruptedException, IOException {
      
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main splash = new Main();
                splash.setVisible(true);
            }
        });
    }


}