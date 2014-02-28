import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;

/**
 * @author Jamie I Davies
 * @brief used to render the text on the game board 
 * @since February 24, 2014
 */
public class C4GameInfo extends AbstractGameInfo{

    private Font m_font;
    private TrueTypeFont m_fontX;
    private final static int FONT_SIZE = 30;
    private final static int X_PIXEL = 90;
    private final static int Y_PIXEL_C4 = 275;
    private final static int Y_PIXEL_TURN = 330;
    
    /*
     * this method sets the font variable
     */
    public C4GameInfo(){
        m_font = new Font("Arial", Font.BOLD, FONT_SIZE);
        
    }
    
    /*
     * method to configure the font appearance
     * set the locations on the board of the strings
     * calls turn and the scores
     */
    public void draw(AbstractGame game){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        m_fontX = new TrueTypeFont(m_font, false);
        m_fontX.drawString(X_PIXEL, Y_PIXEL_C4, "Welcome to Connect 4");
        String turnText = "Player " + game.getTurn() + "'s turn";
        m_fontX.drawString(X_PIXEL, Y_PIXEL_TURN, turnText);
        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }  
}
