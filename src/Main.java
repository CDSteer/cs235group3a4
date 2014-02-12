/**
 * @mainpage	Software Engineering 2 - Group3 PDM Assignment 4
 * 
 * @file 	Main.java
 * @author 	Jamie Irving Davies, Cameron Steer
 * @date	January 28, 2014
 * @see		http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
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

		/** initialise JFrame */
	    setTitle("A4 Partial Implementation : Group 3 ");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
	}	

	/** initC4 method for calling C4 game board */
	public void initC4() {
		/** create C4 objects */
		AbstractDisplay display = new C4Display();
        AbstractGame game = new C4Game();
        AbstractInput gameInput = new C4Input();
        
        /** set up timer for C4 game */
        Time time = new Time();
        time.setUpTimer();
        
        /** display the C4 game board */
        display = new C4Display();
        game = new C4Game();
        gameInput = new C4Input();
        
        display.setUpDisplay();
        display.setUpOpenGL();
        Square.setTexture();

        while (game.isRunning()) {
            gameInput.inputLoop(game.getCurrentCounter());
            game.gameLoop(game, time.getDelta());
            display.render(game.getBoard(), game.getCurrentCounter(), game.getOnScreenCounters());
            Display.update();
            Display.sync(time.getFrameRate());
            if (Display.isCloseRequested()) {
                game.setRunning(false);
            }
        }
        
        /** kill game on close */
        Display.destroy();
        System.exit(0);
	}

	/** initOthello method for calling Othello game board */
	public void initOthello() {
		System.out.println("No Othello game yet, exiting...");
        System.exit(0);
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