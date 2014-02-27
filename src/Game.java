/**
 * @author Cameron Steer, Martin Hui
 * @brief Interface class of AbstractGame, implementing method from AbstractGame
 * @see AbstractGame
 * @date February 1, 2014
 * @version *1.0*
 */
public interface Game {

    public void playGame();
    public void nextTurn();
    public void gameOver();
    public boolean isRunning();
    public void setRunning(boolean running);
}
