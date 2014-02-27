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


    private static final double GREEN = 0.5;
    private boolean m_legal;

    public OthSquare(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height, used);
        this.m_legal = false;
    }

    public boolean islegal() {
        return m_legal;
    }

    public void setlegal(boolean m_legal) {
        this.m_legal = m_legal;
    }

    @Override
    public void releaseTexture() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void draw() {
        if (!m_legal){
            glColor3d(0.0, GREEN, 0.0);
        }else {
            glColor3d(0.5, GREEN, 0.0);
        }
        glRectd(x, y, x + width, y + height);
    }
}
