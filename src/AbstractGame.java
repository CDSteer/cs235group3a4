import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public abstract class AbstractGame implements Game{

    private boolean m_isRunning;
    private AbstractBoard m_board;

    public AbstractGame(boolean isRunning, AbstractBoard board){
        this.m_isRunning = isRunning;
        this.m_board = board;
    }

    public boolean isRunning() {
        return m_isRunning;
    }

    public void setRunning(boolean running) {
        m_isRunning = running;
    }

    public AbstractBoard getBoard() {
        return m_board;
    }

    public void setBoard(AbstractBoard m_board) {
        this.m_board = m_board;
    }

    public abstract Counter getCurrentCounter();


    public abstract List<Counter> getOnScreenCounters();

    public abstract void gameLoop(AbstractGame game);
}