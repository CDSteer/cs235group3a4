/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public abstract class AbstractGame implements Game{

    private boolean isRunning;

    public AbstractGame(boolean isRunning){
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}