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

    private static boolean isRunning = true;

    public static void main(String args[]) throws InterruptedException{
        C4Display c4Display = new C4Display();
        C4Game c4Game = new C4Game();
        c4Display.setUpDisplay();
        c4Display.setUpOpenGL();
        Time.setUpTimer();

        while (isRunning) {
            Counter currentCounter = c4Game.getCurrentCounter();
            C4Board c4Board = c4Game.getC4Board();

            if (Keyboard.next()){
                Input.moveC4Counter(c4Game.getCurrentCounter());
            }
            currentCounter.drop();
            currentCounter.dropCounter(Time.getDelta());
            c4Board.placeCounter(c4Game);

            c4Display.render(c4Game.getC4Board(), c4Game.getCurrentCounter(), c4Game.getOnScreenCounters());
            Display.update();
            Display.sync(60);
            if (Display.isCloseRequested()) {
                isRunning = false;
            }
        }
        Display.destroy();
        System.exit(0);
    }

}
