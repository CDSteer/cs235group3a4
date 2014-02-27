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

    private static Texture square;
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
        square.bind();
        glBegin(GL11.GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2d(x, y);
        glTexCoord2f(1, 0);
        glVertex2d(x + square.getTextureWidth(), y);
        glTexCoord2f(1, 1);
        glVertex2d(x + square.getTextureWidth(), y + square.getTextureHeight());
        glTexCoord2f(0, 1);
        glVertex2d(x, y + square.getTextureHeight());
        glEnd();
        glDisable(GL_TEXTURE_2D);
    }

	/**
	* loads in the texture file for the square
	*/
    public static void setTexture(){
        try {
            square = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/square.png")));
            if (m_Test){
                System.out.println("Texture loaded: " + square);
                System.out.println(">> Image width: " + square.getImageWidth());
                System.out.println(">> Image height: " + square.getImageHeight());
                System.out.println(">> Texture width: " + square.getTextureWidth());
                System.out.println(">> Texture height: " + square.getTextureHeight());
                System.out.println(">> Texture ID: " + square.getTextureID());
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
        square.release();
    }
}
