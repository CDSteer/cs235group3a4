import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;


/**
 * Created by Chris on 24/02/14.
 */
public class OthGameInfo extends AbstractGameInfo{

//    Font DisplayFont = new Font("Arial", Font.BOLD, 30);
//    TrueTypeFont scorefont = new TrueTypeFont(DisplayFont, false);
//    Font awtFont = new Font("Arial", Font.BOLD, 70);
    private TrueTypeFont fontX;
    private TrueTypeFont fontError;
    private Font font;


    public OthGameInfo(){
        font = new Font("Arial", Font.BOLD, 30);

    }

    public void draw(AbstractGame game){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        fontX = new TrueTypeFont(font, false);

        //fontX.drawString(100, 400, "Welcome to Othello");
        String turnText = "Player " + game.getTurn() + "'s turn";
        fontX.drawString(400, 200, turnText);

        //still need to get the players scores and stick them
        //in these strings
        fontX.drawString(400, 100, "Player 1: ");
        fontX.drawString(400, 150, "Player 2: ");

        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }

    public void invalidMoveMessage(){
        fontError = new TrueTypeFont(font, false);
        fontError.drawString(130, 10, "Invalid move");
    }

    public void p1WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(200, 380, "Player 1 Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void p2WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(200, 380, "Player 2 Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

}
