import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class Input {

    private static final double COUNTERMOVE = 31;

    public static void moveC4Counter(Counter currentCounter){
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && currentCounter.getX() != 115) {
                double newPos = currentCounter.getX() - COUNTERMOVE;
                currentCounter.setX(newPos);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && currentCounter.getX() != 394) {
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
