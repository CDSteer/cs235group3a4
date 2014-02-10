/**
 * @mainpage Connect 4 and Othello
 *
 * Description of the project
 * The games Connect 4 and Othello <br>
 *
 * @author Cameron Steer
 */

/**
 * @file Main.java
 *
 * @brief file the has the class Main which contains the main method to start the program
 *
 * @author Cameron Steer
 *
 * @date 01.02.2014
 **/

import org.lwjgl.opengl.Display;

import java.io.IOException;
import java.util.Scanner;

/**
 * @class Main
 *
 * @brief Class contains the main method to start the program
 *
 * This class sets up the game objects and starts the game loop, we also declare a static constant for our frames
 * games frame rate this is set to 60.
 */
public class Main {

    /**
    *<A short one line description>
    *
    *<Longer description>
    *<May span multiple lines or paragraphs as needed>
    *
    *@param  Description of method's or function's input parameter
    *@param  ...
    *@return Description of the return value
    */
    public static void main(String args[]) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time();
        time.setUpTimer();
        AbstractDisplay display = new C4Display();
        AbstractGame game = new C4Game();
        AbstractInput gameInput = new C4Input();

        //get user game selection
        System.out.print("Enter game: ");
        String userGame = scanner.next();

        if (userGame.equals("c4")){
            display = new C4Display();
            game = new C4Game();
            gameInput = new C4Input();
        }
        if (userGame.equals("oth")){
            display = new OthDisplay();
            game = new OthGame();
            gameInput = new OthInput();
        }

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
        game.getBoard().unBind();
        Display.destroy();
        System.exit(0);
    }

}
