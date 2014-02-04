import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class OthDisplay extends AbstractDisplay{
    public OthDisplay() {
        super(HEIGHT, WIDTH, "Othello");
    }

    @Override
    public void render(AbstractBoard board, Counter currentCounter, List<Counter> onScreenCounters) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private static final int WIDTH = 320;
    private static final int HEIGHT = 240;
}
