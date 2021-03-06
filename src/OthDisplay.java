import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * @author Cameron Steer
 * @date 04/02/2014
 * @since 20/02/2014 Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @brief Extends AbstractDisplay class and displays the Othello game
 */
public class OthDisplay extends AbstractDisplay{

    private OthGameInfo m_othGameInfo;
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public OthDisplay() {

        super(WIDTH, HEIGHT, "Othello");
        m_othGameInfo = new OthGameInfo();

    }



    /**
     * renders the game board
     */
    @Override
    public void render(AbstractGame game) {

        glClear(GL_COLOR_BUFFER_BIT);
        game.getBoard().draw();
        //OthInfoDisplay.draw(OthGAME);
        for (AbstractCounter counters : game.getOnScreenCounters()) {
            counters.draw();
        }

        m_othGameInfo.draw(game);

    }
}
