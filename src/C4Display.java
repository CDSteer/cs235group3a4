import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;



/**
 * @author Cameron Steer
 * @date 01/02/2014
 * @since 20/2/2014		
 * @version *1.0.1*
 * @brief Extends AbstractDisplay which builds the display aspects of the C4 game board
 * @details draws the game board and all aspects including textures and rendering
 */
public class C4Display extends AbstractDisplay{

	private C4GameInfo m_c4GameInfo;
    public C4Display() {

        super(WIDTH, HEIGHT, "Connect 4");
    }

    public void loadTextures(){
        m_c4GameInfo = new C4GameInfo();
    }

    @Override
    public void render(AbstractGame game) {
        glClear(GL_COLOR_BUFFER_BIT);

        game.getCurrentCounter().draw();
        for (AbstractCounter counters : game.getOnScreenCounters()) {
            counters.draw();
        }

        game.getBoard().draw();
        //c4ReplayButton.draw();
        //c4GameInfo.draw(game);

        //call C4InfoDisplay here
    }
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
}
