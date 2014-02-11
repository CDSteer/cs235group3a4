import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class C4Input extends AbstractInput {
    public static final double DROP = .2;
    @Override
    public void inputLoop(Counter currentCounter){
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
