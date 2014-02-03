/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 28/01/2014
 * @version *.*
 */

import org.lwjgl.opengl.Display;

public class Main {

    public static void main(String args[]) throws InterruptedException{
        Time.setUpTimer();

        AbstractDisplay display = new C4Display();
        C4Game game = new C4Game();

        display.setUpDisplay();
        display.setUpOpenGL();

        while (game.isRunning()) {

            Input.moveC4Counter(game.getCurrentCounter());

            game.getCurrentCounter().drop();
            game.getCurrentCounter().dropCounter(Time.getDelta());
            game.getBoard().placeCounter(game);

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
