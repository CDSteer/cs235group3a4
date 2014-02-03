import java.util.List;

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
    public void render(AbstractBoard board, Counter currentCounter, List<Counter> onScreenCounters);
}
