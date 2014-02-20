/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 * @since 01/02/2014
 * @version *1.0*
 */
public interface Game {

    public void playGame();
    public void nextTurn();
    public void gameOver();
    public boolean isRunning();
    public void setRunning(boolean running);
}
