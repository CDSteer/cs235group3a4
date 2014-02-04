import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class OthGame extends AbstractGame {


    public OthGame() {
        super(true, othBoard);
    }

    @Override
    public Counter getCurrentCounter() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Counter> getOnScreenCounters() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void gameLoop(AbstractGame game) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playGame() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void nextTurn() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    //remove this later
    private static OthBoard othBoard = new OthBoard();
}
