import Entity.AbstractEntity;
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

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 29/01/2014
 * @version *.*
 */

public class Square extends AbstractEntity {

    private boolean used;
    private int player;
    private static Texture square;

    public Square(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height);
        this.used = used;
        this.player = 0;
    }
    public static void setTexture(){
        try {
            square = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/square.png")));
            System.out.println("Texture loaded: " + square);
            System.out.println(">> Image width: " + square.getImageWidth());
            System.out.println(">> Image height: " + square.getImageHeight());
            System.out.println(">> Texture width: " + square.getTextureWidth());
            System.out.println(">> Texture height: " + square.getTextureHeight());
            System.out.println(">> Texture ID: " + square.getTextureID());
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

    public void releseTex(){
        square.release();
    }

    public void setUsed(boolean used){
        this.used = used;
    }

    public int getPlayer(){
        return player;
    }

    public void setPlayer(int _player){
        this.player = _player;
    }

    public boolean isUsed(){
        return used;
    }

    @Override
    public void update(int delta) {
         // do nothing.
    }

}
