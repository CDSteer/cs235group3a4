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


    private TrueTypeFont m_fontX;
    private TrueTypeFont m_fontError;
    private Font m_font;
    private String m_p1Counters;
    private String m_p2Counters;
    private static final int FONT_SIZE = 30;
    private static final int PLAYER_1 = 1;
    private static final int X_PIXEL_130 = 130;
    private static final int Y_PIXEL_10 = 10;
    private static final int X_PIXEL_200 = 200;
    private static final int Y_PIXEL_380 = 380;
    private static final int X_PIXEL_400 = 400;
    private static final int Y_PIXEL_200 = 200;
    private static final int Y_PIXEL_150 = 150;
    private static final int Y_PIXEL_100 = 100;
    private static final int PLAYER_2 = 2;



    public OthGameInfo(){
        m_font = new Font("Arial", Font.BOLD, FONT_SIZE);

    }

    public void setInvalidMoveMessage(){
        m_fontError = new TrueTypeFont(m_font, false);
        m_fontError.drawString(X_PIXEL_130, Y_PIXEL_10, "Invalid move");
    }

    public void setP1WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        m_fontX = new TrueTypeFont(m_font, false);
        m_fontX.drawString(X_PIXEL_200, Y_PIXEL_380, "Black Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void setP2WinsMessage(){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        m_fontX = new TrueTypeFont(m_font, false);
        m_fontX.drawString(X_PIXEL_200, Y_PIXEL_380, "White Wins!");
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void draw(AbstractGame game){
    
    	m_p1Counters = Integer.toString(game.getCounters1());
    	m_p2Counters = Integer.toString(game.getCounters2());
        String turnText = "";
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        m_fontX = new TrueTypeFont(m_font, false);


        if(game.getTurn() == PLAYER_1){
           turnText = "Black's turn";
        }else if(game.getTurn() == PLAYER_2){
           turnText = "White's turn";
        }
        m_fontX.drawString(X_PIXEL_400, Y_PIXEL_200, turnText);

        m_fontX.drawString(X_PIXEL_400, Y_PIXEL_100, "Black: " + m_p1Counters);
        m_fontX.drawString(X_PIXEL_400, Y_PIXEL_150, "White: " + m_p2Counters);

        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }



}
