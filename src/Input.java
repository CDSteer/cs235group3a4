import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class Input {

    public static void moveC4Counter(Counter currentCounter){
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

    private static final double COUNTERMOVE = 31;
    private static final double LEFTBOUND = 115;
    private static final double RIGHTBOUND = 394;
}
