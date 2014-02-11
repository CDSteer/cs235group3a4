import org.lwjgl.Sys;

/**
 * @file Time.java
 *
 * @brief
 *
 * @author Cameron Steer
 *
 * @date 01.02.2014
 **/


/**
 * @class Time
 *
 * @brief
 *
 * <description>
 */
public class Time {

    private long m_LastFrame;
    private final int TIMECAL = 1000;
    private final int FRAMESPERSEC = 60;


    /**
     * Gettter method for the games frame rate.
     *
     * @return programs frames per second
     */
    public int getFrameRate(){
        return FRAMESPERSEC;
    }

    /**
     * Get the
     *
     * @return delta
     */
    public int getDelta() {
        long currentTime = getTime();
        int delta = (int)(currentTime - m_LastFrame);
        m_LastFrame = getTime();
        return delta;
    }

    /**
     * Get the time of last frame.
     *
     * @return the last frame based on time and resolution
     */
    public long getTime() {
        return (Sys.getTime() * TIMECAL) / Sys.getTimerResolution();
    }

    /**
     * Set the last frame
     *
     * @return void
     */
    public void setUpTimer(){
        m_LastFrame = getTime();
    }
}
