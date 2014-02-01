import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public interface Display {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public void setUpDisplay();
    public void setUpOpenGL();
    public void render(C4Board c4Board, Counter currentCounter, List<Counter> onScreenCounters);
}
