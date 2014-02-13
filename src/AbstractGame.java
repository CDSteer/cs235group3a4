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

    public AbstractGame(boolean isRunning){
        this.m_isRunning = isRunning;
    }

    public boolean isRunning() {
        return m_isRunning;
    }

    public void setRunning(boolean running) {
        m_isRunning = running;
    }

    public abstract Counter getCurrentCounter();


    public abstract List<Counter> getOnScreenCounters();

    public abstract void gameLoop(AbstractGame game, int delta);

}