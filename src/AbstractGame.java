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
    private Time m_Time;

    public AbstractGame(boolean isRunning){
        this.m_isRunning = isRunning;
        this.m_Time = new Time();
    }

    public boolean isRunning() {
        return m_isRunning;
    }

    public void setRunning(boolean running) {
        m_isRunning = running;
    }

    public Time getTime() {
        return m_Time;
    }

    public void setTime(Time m_Time) {
        this.m_Time = m_Time;
    }

    public abstract AbstractCounter getCurrentCounter();


    public abstract List<AbstractCounter> getOnScreenCounters();
    public abstract void gameLoop();
    public abstract AbstractBoard getBoard();
    public abstract int getTurn();
    public abstract int getCounters1();
    public abstract int getCounters2();
    public abstract void calcCounters();

    public abstract void init();
}
