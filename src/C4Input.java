import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Cameron Steer and Curtis Lewis
 * @since 04/02/2014 -update 20/2/2014
 * @date  Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @see
 * @brief	This class extends AbstractInput which contains methods to allow the user to make a move in C4.
 * @details This class creates a loop which listens for a left or right move from the user's keyboard and allows a move.
 * @version *1.0.1*
 */
public class C4Input extends AbstractInput {
    public static final double DROP = .2;

	
	/**
	* In the inputLoop Method, we employ a nested loop that checks that if the state of the counter
    * is not dropped into board then we listen for keyboard input and check that it is either a leftbound
    * or rightbound action and is within the bounds specified for movement. The X co-ordinate of the counter
    * (the top of the board) is then updated. If the user presses down on the keyboard, the counter is set to drop
    * and a new counter is generated.
	* @param currentCounter
	* @return Nothing is returned from the loop as it is void.
	*/
    public void inputLoop(AbstractCounter currentCounter){
        //if counter not dropped listen for a left and right arrows to move counter each square until end of board
        if (currentCounter.getDY() != DROP){
            if (Keyboard.next()){
                if (Keyboard.getEventKeyState()) {
                    if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && currentCounter.getX() != LEFTBOUND) {
                        double newPos = currentCounter.getX() - COUNTERMOVE;
                        currentCounter.setX(newPos);
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && currentCounter.getX() != RIGHTBOUND) {
                        double newPos = currentCounter.getX() + COUNTERMOVE;
                        currentCounter.setX(newPos);
                    }
                } else {
                    if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
                        return;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
                        return;
                    }
                }
            }
        }

        //if the down key is pressed then the counter is dropped to the board
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
                currentCounter.setDY(DROP);
            }
        }
    }

    private static final double COUNTERMOVE = 31;
    private static final double LEFTBOUND = 115;
    private static final double RIGHTBOUND = 394;
}
