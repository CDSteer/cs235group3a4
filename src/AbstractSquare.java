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
 *
 * @author Cameron Steer
 * @since 29/01/2014
 * @date  Verified and Updated by Design Manager Curtis on 27th Feb 2014
 * @see
 * @brief	This class extends AbstractEntity which contains the various coordinates relating to graphics.
 * @details It sets all various locations and dimensions for the game window. It also stores the player info.
 * @version *1.0.0*
 */

public abstract class AbstractSquare extends AbstractEntity {

    private boolean m_used;
    private int m_player;


    /**
     * sets the height, width and the x,y coordinates
     * @param x
     * @param y
     * @param width
     * @param height
     * @param used
     */
    public AbstractSquare(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height);
        this.m_used = used;
        this.m_player = 0;
    }

    /**
     * method to set the used boolean
     * @param used
     */
    public void setUsed(boolean used){
        this.m_used = used;
    }

    /**
     * method to get player info
     * @return player
     */
    public int getPlayer(){
        return m_player;
    }

    /**
     * method sets the player to _player
     * @param _player
     */
    public void setPlayer(int _player){
        this.m_player = _player;
    }

    /**
     * sets the boolean isUsed
     * @return used
     */
    public boolean isUsed(){
        return m_used;
    }

    /**
     * 
     * @param delta
     */
    @Override
    public void update(int delta) {
         // do nothing.
    }

    public abstract void releaseTexture();
}
