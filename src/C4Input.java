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

        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
                currentCounter.setDY(.2);
            }
        } else {
            return;
        }

    }

    private static final double COUNTERMOVE = 31;
    private static final double LEFTBOUND = 115;
    private static final double RIGHTBOUND = 394;
}
