
import org.lwjgl.input.Mouse;

/**
 * 
 *
 * @author Cameron Steer and Curtis Lewis
 * @since 04/02/2014 -update 20/2/2014
 * @date  Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @see
 * @brief	This class extends AbstractInput which contains methods to allow the user to make a move in Oth.
 * @details This class creates a loop which listens for the next action of the mouse and adds a counter to a space.
 * @version *1.0.1*
 */
public class OthInput extends AbstractInput{


 /**
  * In the inputLoop Method, we employ a while loop which constantly checks for the next action
  * of the mouse, if a left-click from the mouse is detected then we return the state of the board
  * and calls another method, placeCounter which takes the OthGame object and places a counter.
  * @param OthGame game
  * @return Nothing is returned from the method as it is void.
  */

    public void inputLoop(OthGame game) {
        while(Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                if (Mouse.getEventButton() == 0) {
                    game.getOthBoard().placeCounter(game);
                }
            }
        }
    }
}
