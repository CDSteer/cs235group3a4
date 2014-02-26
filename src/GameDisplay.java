/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public interface GameDisplay {
    public void setUpDisplay();
    public void setUpOpenGL();
    public void render(AbstractGame game);
}
