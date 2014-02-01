import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.List;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class C4Display extends AbstractDisplay{
    @Override
    public void setUpDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Connect Four");
            Display.create();
        } catch (LWJGLException e) {
            Display.destroy();
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void render(C4Board c4Board, Counter currentCounter, List<Counter> onScreenCounters) {
        glClear(GL_COLOR_BUFFER_BIT);
        c4Board.draw();
        currentCounter.draw();

        for (Counter counters : onScreenCounters) {
            counters.draw();
        }
    }
}
