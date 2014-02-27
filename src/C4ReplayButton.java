/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 27/02/2014
 * @version *.*
 */
public class C4ReplayButton extends ReplayButton{
    public C4ReplayButton() {
        super(X, Y, WIDTH, HEIGHT);
    }

    @Override
    public void onClick() {
        System.out.println("hello");
        //reload connect 4
    }

    private static final double X = 470;
    private static final double Y  =  100;
    private static final double WIDTH  =  128;
    private static final double HEIGHT  =  64;
}
