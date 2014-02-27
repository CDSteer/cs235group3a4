import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glMatrixMode;

/**
 * @author Cameron Steer
 * @since February 1, 2014
 * @date Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @brief This class implements the GameDisplay class
 * @details sets the left, right, bottom, top coordinates for the game display, as well as setting up the OpenGL and display
 */
public abstract class AbstractDisplay implements GameDisplay{

    private int m_Width;
    private int m_Height;
    private String m_title;
    private final int LEFT_COORDINATES = 0;
    private final int RIGHT_COORDINATES = 640;
    private final int BOTTOM_COORDINATES = 480;
    private final int TOP_COORDINATES = 0;
    private final int ZNEAR_COORDINATES = 1;
    private final int ZFAR_COORDINATES = -1;


    /**
     * sets the height, width and title of the display
     * @param height
     * @param width
     * @param title
     */
    public AbstractDisplay(int height, int width, String title){
        this.m_Height = height;
        this.m_Width = width;
        this.m_title = title;
    }

    /**
     * sets up the display for opengl. catches exceptions and kills game if necessary
     */
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

   /**
    * initialises the OpenGL code and enables alpha blending
    */
    @Override
   public void setUpOpenGL(){
       glEnable(GL_BLEND);
       glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
       glMatrixMode(GL_PROJECTION);
       glLoadIdentity();
       glOrtho(LEFT_COORDINATES, RIGHT_COORDINATES, BOTTOM_COORDINATES, TOP_COORDINATES, ZNEAR_COORDINATES, ZFAR_COORDINATES);
       glMatrixMode(GL_MODELVIEW);
    }

    /**
     * renders the abstract
     */
    public abstract void render(AbstractGame game);
}
