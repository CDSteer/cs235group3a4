/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 28/01/2014
 * @version *.*
 */

import org.lwjgl.opengl.Display;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws InterruptedException{
        Time.setUpTimer();
        AbstractDisplay display = new C4Display();
        AbstractGame game = new C4Game();
        AbstractInput gameInput = new C4Input();

        Scanner scanner = new Scanner(System.in);
        String userGame;

        System.out.print("Enter game: ");
        userGame = scanner.next();
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

        while (game.isRunning()) {
            gameInput.inputLoop(game.getCurrentCounter());
            game.gameLoop(game);
            display.render(game.getBoard(), game.getCurrentCounter(), game.getOnScreenCounters());
            Display.update();
            Display.sync(60);
            if (Display.isCloseRequested()) {
                game.setRunning(false);
            }
        }
        Display.destroy();
        System.exit(0);
    }

}
