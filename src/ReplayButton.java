import Entity.AbstractEntity;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 27/02/2014
 * @version *.*
 */
public abstract class ReplayButton extends AbstractEntity{
    private Texture m_Button;
    private boolean m_Test = true;
    private TrueTypeFont m_FontX;
    private Font font = new Font("Arial", Font.BOLD, 30);

    public ReplayButton(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTexture();
    }

    /**
     * Draws the squared of the using the texture loaded in the constructor
     *
     * @return null
     */
    @Override
    public void draw(){
        glColor3d(0.0, 0.0, 1.0);
        glBegin(GL11.GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2d(x, y);
        glTexCoord2f(1, 0);
        glVertex2d(x + m_Button.getTextureWidth(), y);
        glTexCoord2f(1, 1);
        glVertex2d(x + m_Button.getTextureWidth(), y + m_Button.getTextureHeight());
        glTexCoord2f(0, 1);
        glVertex2d(x, y + m_Button.getTextureHeight());
        glEnd();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.black.bind();
        m_FontX = new TrueTypeFont(font, false);
        m_FontX.drawString((int)x + PADDING, (int)y + PADDING, "Replay");

        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    /**
     * loads in the texture file for the button
     *
     * @return null
     */
    private void setTexture(){
        try {
            m_Button = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/replayButton.png")));
            if (m_Test){
                System.out.println("Texture loaded: " + m_Button);
                System.out.println(">> Image width: " + m_Button.getImageWidth());
                System.out.println(">> Image height: " + m_Button.getImageHeight());
                System.out.println(">> Texture width: " + m_Button.getTextureWidth());
                System.out.println(">> Texture height: " + m_Button.getTextureHeight());
                System.out.println(">> Texture ID: " + m_Button.getTextureID());
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

    public abstract void onClick();

    @Override
    public void update(int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private static final int PADDING = 15;
}
