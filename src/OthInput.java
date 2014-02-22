
import org.lwjgl.input.Mouse;

/**
 * 
 *
 * @author Curtis
 * @date 04/02/2014
 * @version 
 */
public class OthInput extends AbstractInput{

    public void inputLoop(OthGame game) {
        while(Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                if (Mouse.getEventButton() == 0) {
                    for (int i=0; i< game.getOthBoard().getM_Row(); i++) {
                        for (int j=0; j<game.getOthBoard().getM_Column(); j++) {
                            if (game.getOthBoard().getBoard()[i][j].inBounds(Mouse.getX(), OthDisplay.HEIGHT - Mouse.getY())){
                                OthCounter.placeCounter(game.getOthBoard().getBoard()[i][j]);
                            }
                        }
                    }
                }
            }
        }
    }
}
