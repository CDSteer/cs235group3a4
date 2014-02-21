import org.lwjgl.input.Mouse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class OthInput extends AbstractInput{
    @Override
    public void inputLoop(AbstractCounter currentCounter) {
        while(Mouse.next()) {
            if(Mouse.isButtonDown(0)) {
                System.out.println("Click!!");
            }
        }
    }
}
