/**
 * @file 	Counter.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @brief	Counter holds data and methods for the connect 4 counters
 * @details
 */
public class C4Counter extends AbstractCounter {

    public C4Counter() {
        super(X, Y, WIDTH, HIGHT, RADIUS, PLAYER);
    }

    private static final int PLAYER = 1;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HIGHT = 10;
}