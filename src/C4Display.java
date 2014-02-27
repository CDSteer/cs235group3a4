import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.util.List;

import org.newdawn.slick.Color;

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
    //private c4infodisplay
	private C4GameInfo c4GameInfo;
    public C4Display() {
        super(WIDTH, HEIGHT, "Connect 4");
        c4GameInfo = new C4GameInfo();
    }

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    @Override
    public void render(AbstractGame game) {
        glClear(GL_COLOR_BUFFER_BIT);

        game.getCurrentCounter().draw();
        for (AbstractCounter counters : game.getOnScreenCounters()) {
            counters.draw();
        }

        game.getBoard().draw();
        
        c4GameInfo.draw(game);

        //call C4InfoDisplay here
    }
}
