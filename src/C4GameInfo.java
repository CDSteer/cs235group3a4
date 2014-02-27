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

    private Font font;
    private TrueTypeFont fontX;
    
    /*
     * this method sets the font variable
     */
    public C4GameInfo(){
        font = new Font("Arial", Font.BOLD, 30);
        
    }
    
    /*
     * method to configure the font appearance
     * set the locations on the board of the strings
     * calls turn and the scores
     */
    public void draw(AbstractGame game){
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        Color.white.bind();
        fontX = new TrueTypeFont(font, false);
        fontX.drawString(90, 275, "Welcome to Connect 4");
        String turnText = "Player " + game.getTurn() + "'s turn";
        fontX.drawString(90, 330, turnText);
        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }  
}
