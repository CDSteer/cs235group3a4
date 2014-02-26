import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *
 * @since 04/02/2014
 * 		 	-update 20/02/2014
 * 		    -Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @version *.*
 */
public class OthDisplay extends AbstractDisplay{
    private OthGameInfo othGameInfo;
    public OthDisplay() {
        super(WIDTH, HEIGHT, "Othello");
        othGameInfo = new OthGameInfo();
    }

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    @Override
    public void render(AbstractGame game) {

        glClear(GL_COLOR_BUFFER_BIT);
        game.getBoard().draw();
        //OthInfoDisplay.draw(OthGAME);
        for (AbstractCounter counters : game.getOnScreenCounters()) {
            counters.draw();
        }

        othGameInfo.draw(game);

    }
}
