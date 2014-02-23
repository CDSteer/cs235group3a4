/**
 * Created with IntelliJ IDEA.
 * @file Game.java
 *
 * @brief Interface class of AbstractGame, implementin method from AbstractGame
 * @see AbstractGame
 *
 * @author Cameron Steer
 * @author Martin Hui
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
