import org.lwjgl.Sys;

/**
 * @file 	Time.java
 * @author 	Cameron Steer
 * @date	February 1, 2014
 * @see     http://thecodinguniverse.com/tag/delta/
 * @brief	The class to get time information
 * @details This class calculates frame information used for rendering and moving objects on the screen
 */

public class Time {

    private long m_LastFrame;
    private final int TIMECAL = 1000;
    private final int FRAMESPERSEC = 60;


    /**
     * return games frame rate.
     *
     * @return programs frames per second
     */
    public int getFrameRate(){
        return FRAMESPERSEC;
    }

    /**
     * Get the delta based off the amount of time that has passed since the last frame is retrieved
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
