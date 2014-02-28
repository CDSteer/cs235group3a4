import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;

/**
 * @author Cameron Steer
 * @date 13/02/2014
 * @since 20/02/2014
 * @version *1.0.1*
 * @brief creates a new C4 square, extends the AbstractSquare class
 */
public class C4Square extends AbstractSquare{

    private static Texture m_square;
    private static boolean m_Test = false;

    /**
     * Constructor for a new square
     * @param x
     * @param  y
     * @param width
     * @param height
     * @param used
     */
    public C4Square(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height, used);
    }

	/**
	* Draws the squared of the using the texture loaded in the constructor
	*/
    @Override
    public void draw(){
        glEnable(GL_TEXTURE_2D);
        Color.white.bind();
        m_square.bind();
        glBegin(GL11.GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2d(m_x, m_y);
        glTexCoord2f(1, 0);
        glVertex2d(m_x + m_square.getTextureWidth(), m_y);
        glTexCoord2f(1, 1);
        glVertex2d(m_x + m_square.getTextureWidth(), m_y + m_square.getTextureHeight());
        glTexCoord2f(0, 1);
        glVertex2d(m_x, m_y + m_square.getTextureHeight());
        glEnd();
        glDisable(GL_TEXTURE_2D);
    }

	/**
	* loads in the texture file for the square
	*/
    public static void setTexture(){
        try {
            m_square = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/square.png")));
            if (m_Test){
                System.out.println("Texture loaded: " + m_square);
                System.out.println(">> Image width: " + m_square.getImageWidth());
                System.out.println(">> Image height: " + m_square.getImageHeight());
                System.out.println(">> Texture width: " + m_square.getTextureWidth());
                System.out.println(">> Texture height: " + m_square.getTextureHeight());
                System.out.println(">> Texture ID: " + m_square.getTextureID());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
            Display.destroy();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            Display.destroy();
            System.exit(1);
        }
    }

	/**
	* removes textures when games connect 4 is closed
	*/
    public void releaseTexture(){
        m_square.release();
    }
}
