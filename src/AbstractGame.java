import java.util.List;

/**
* @author Cameron Steer
* @since February 1, 2014
* @date Verified and Updated by Design Manager Curtis on 23rd Feb 2014
* @brief Sets up the game. Implements the Game class
* @details sets the game to be running or not, also sets up the time using getters and setters
*/

public abstract class AbstractGame implements Game{

    private boolean m_isRunning;
    private Time m_Time;

    /**
     * AbstractGame class that sets the game running and creates a new timer
     * @param isRunning
     */
    public AbstractGame(boolean isRunning){
        this.m_isRunning = isRunning;
        this.m_Time = new Time();
    }

    /**
     * returns the running state of the game
     * @return m_isRunning
     */
    public boolean isRunning() {
        return m_isRunning;
    }

    /**
     * sets the running state of the game
     * @param running
     */
    public void setRunning(boolean running) {
        m_isRunning = running;
    }

    /**
     * gets the time
     * @return m_Time
     */
    public Time getTime() {
        return m_Time;
    }

    /**
     * sets the time for the game
     * @param m_Time
     */
    public void setTime(Time m_Time) {
        this.m_Time = m_Time;
    }

    /**
     * gets the current counter
     * @return
     */
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
