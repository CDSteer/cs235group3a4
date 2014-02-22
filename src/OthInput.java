
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
                    game.getOthBoard().placeCounter(game.getCurrentCounter(), game.getOnScreenCounters());
                }
            }
        }
    }
}
