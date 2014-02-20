import java.util.List;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;



/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 * @since 01/02/2014
 *			-update 20/2/2014		
 * @version *1.0.1*
 */
public class C4Display extends AbstractDisplay{

    public C4Display(){
        super(WIDTH, HEIGHT, "Connect 4");
    }

    @Override
	
	/**
	* Description plz~
	* @param AbstractBoard, AbstractCounter
	* @return null
	*/
    public void render(AbstractBoard c4Board, AbstractCounter currentCounter, List<AbstractCounter> onScreenCounters) {
        glClear(GL_COLOR_BUFFER_BIT);

        currentCounter.draw();
        for (AbstractCounter counters : onScreenCounters) {
            counters.draw();
        }

        c4Board.draw();


    }

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
}
