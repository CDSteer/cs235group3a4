/**
 * @author Cameron Steer
 * @date 01/02/2014
 * @brief sets up the display and opengl for the game
 * @details also renders calling AbstractGame class
 */
public interface GameDisplay {
    public void setUpDisplay();
    public void setUpOpenGL();
    public void render(AbstractGame game);
}
