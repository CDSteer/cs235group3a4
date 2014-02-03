/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 28/01/2014
 * @version *.*
 */

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Main {

    public static void main(String args[]) throws InterruptedException{
        C4Display display = new C4Display();
        C4Game game = new C4Game();

        display.setUpDisplay();
        display.setUpOpenGL();
        Time.setUpTimer();

        while (game.isRunning()) {
            Counter currentCounter = game.getCurrentCounter();
            C4Board c4Board = game.getC4Board();

            if (Keyboard.next()){
                Input.moveC4Counter(game.getCurrentCounter());
            }
            currentCounter.drop();
            currentCounter.dropCounter(Time.getDelta());
            c4Board.placeCounter(game);

            display.render(game.getC4Board(), game.getCurrentCounter(), game.getOnScreenCounters());
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
