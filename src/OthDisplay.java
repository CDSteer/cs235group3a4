import java.util.List;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class OthDisplay extends AbstractDisplay{
    public OthDisplay() {
        super(WIDTH, HEIGHT, "Othello");
    }

    @Override
    public void render(AbstractBoard board, AbstractCounter currentCounter, List<AbstractCounter> onScreenCounters) {
        glClear(GL_COLOR_BUFFER_BIT);
        board.draw();
    }

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
}
