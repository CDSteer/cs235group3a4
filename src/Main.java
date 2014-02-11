/**
 *
 * @author cdsteer, jidavies
 *         - created 28/01/2014
 * @version *.*
 */

import org.lwjgl.opengl.Display;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

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
            Display.sync(FRAMESPERSEC);
            if (Display.isCloseRequested()) {
                game.setRunning(false);
            }
        }
        Display.destroy();
        System.exit(0);
    }

    private static final int FRAMESPERSEC = 60;

}
