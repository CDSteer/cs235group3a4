import org.lwjgl.input.Mouse;

/**
 * 
 *
 * @author Curtis
 * @date 04/02/2014
 * @version 
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
