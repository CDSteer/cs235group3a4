import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glMatrixMode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public abstract class AbstractDisplay implements GameDisplay{

    private int m_Width;
    private int m_Height;
    private String m_title;

    public AbstractDisplay(int height, int width, String title){
        this.m_Height = height;
        this.m_Width = width;
        this.m_title = title;
    }

    @Override
    public void setUpDisplay(){
        try {
            org.lwjgl.opengl.Display.setDisplayMode(new DisplayMode(m_Height, m_Width));
            Display.setTitle(m_title);
            Display.create();
        } catch (LWJGLException e) {
            Display.destroy();
            e.printStackTrace();
            System.exit(1);
        }
    }

   @Override
   public void setUpOpenGL(){
        // Initialization code OpenGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }
}
