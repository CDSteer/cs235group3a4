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

    public C4Display(){
        super(WIDTH, HEIGHT, "Connect 4");
    }

    @Override
    public void render(AbstractBoard c4Board, Counter currentCounter, List<Counter> onScreenCounters) {
        glClear(GL_COLOR_BUFFER_BIT);

        currentCounter.draw();
        for (Counter counters : onScreenCounters) {
            counters.draw();
        }

        c4Board.draw();


    }

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
}
