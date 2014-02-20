import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glRectd;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 13/02/2014
 * @version *.*
 */
public class OthSquare extends AbstractSquare{

    public OthSquare(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height, used);
    }

    @Override
    public void releaseTexture() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void draw() {
        glColor3d(0.0, 1.0, 0.0);
        glRectd(x, y, x + width, y + height);
    }
}
