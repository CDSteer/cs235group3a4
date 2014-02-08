import org.lwjgl.Sys;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class Time {

    private long m_LastFrame;

    public int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - m_LastFrame);
        m_LastFrame = getTime();
        return delta;
    }
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
    public void setUpTimer(){
        m_LastFrame = getTime();
    }
}
