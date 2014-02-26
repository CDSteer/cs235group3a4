import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;


/**
 * Created by Chris on 24/02/14.
 */
public class OthGameInfo {


    //private Font scoreFont;
    private boolean player1Wins;
    private boolean player2Wins;

//    Font DisplayFont = new Font("Arial", Font.BOLD, 30);
//    TrueTypeFont scorefont = new TrueTypeFont(DisplayFont, false);
//    Font awtFont = new Font("Arial", Font.BOLD, 70);
    private Font font;
    private TrueTypeFont fontX;

    public OthGameInfo(){
        font = new Font("Arial", Font.BOLD, 30);
    }

    public void draw(AbstractGame game){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(100, 400, "Welcome to Othello");
        String turnText = "Turn: " + game.getTurn();
        fontX.drawString(400, 200, turnText);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }



    /**
     *Sets the Font
     */
    /**
    public static void GameInfo(){

        if (player1Wins == true){

        } else if (player2Wins == true){

        }
    }
    **/
    /**
     *Draws the Font
     */
    /**
    public static void draw(private fontArial){

    }
    **/

}