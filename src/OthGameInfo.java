import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;


/**
 * @author Chris Jenkins
 * @date 24/02/2014
 * @brief extends the AbstractGameInfo class to set fonts and board messages
 * @details draws the messages on the board which are rendered. including the player state and scoring
 * Created by Chris on 24/02/14.
 */
public class OthGameInfo extends AbstractGameInfo{

//    Font DisplayFont = new Font("Arial", Font.BOLD, 30);
//    TrueTypeFont scorefont = new TrueTypeFont(DisplayFont, false);
//    Font awtFont = new Font("Arial", Font.BOLD, 70);
    private TrueTypeFont fontX;
    private TrueTypeFont fontError;
    private Font font;
    private String p1Counters;
    private String p2Counters;


    public OthGameInfo(){
        font = new Font("Arial", Font.BOLD, 30);

    }

    public void draw(AbstractGame game){
    
    	p1Counters = Integer.toString(game.getCounters1());
    	p2Counters = Integer.toString(game.getCounters2());
        String turnText = "";
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        fontX = new TrueTypeFont(font, false);

        //fontX.drawString(100, 400, "Welcome to Othello");
        if(game.getTurn() == 1){
           turnText = "Black's turn";
        }else if(game.getTurn() == 2){
           turnText = "White's turn";
        }
        fontX.drawString(400, 200, turnText);

        //still need to get the players scores and stick them
        //in these strings
        fontX.drawString(400, 100, "Black: " + p1Counters);
        fontX.drawString(400, 150, "White: " + p2Counters);

        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }

    public void invalidMoveMessage(){
        fontError = new TrueTypeFont(font, false);
        fontError.drawString(130, 10, "Invalid move");
    }

    public void p1WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(200, 380, "Black Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void p2WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(200, 380, "White Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

}
