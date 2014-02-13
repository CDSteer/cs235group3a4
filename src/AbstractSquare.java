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

public abstract class AbstractSquare extends AbstractEntity {

    private boolean used;
    private int player;


    public AbstractSquare(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height);
        this.used = used;
        this.player = 0;
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

    public abstract void releaseTexture();
}
