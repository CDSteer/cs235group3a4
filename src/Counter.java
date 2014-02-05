import Entity.AbstractMovableEntity;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author cdsteer
 * - created 28/01/2014
 * @version 1.0
 */
public class Counter extends AbstractMovableEntity {

    private int player;

    public Counter(double x, double y, double width, double height, int player) {
        super(x, y, width, height);
        this.player = player;
    }

    @Override
    public void draw() {
        float x1 = (float)x;
        float y1 = (float)y;

        //filled circle
        float x2,y2;
        float angle;
        float radius = 10;

        if (player == 1) {
            glColor3d(1, 0, 0);
        } else if (player == 2) {
            glColor3d(0, 1.5, 0);
        }

        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(x1,y1);

        for (angle=1.0f; angle < 10.61E02f; angle+= 2.0E-01f) {

            double foo = x1+sin(angle)*radius;
            double bar = y1+cos(angle)*radius;

            x2 = (float)foo;
            y2 = (float)bar;
            glVertex2f(x2,y2);
        }
        glEnd();
    }

    public int getPlayer(){
        return player;
    }

    public void center(Square square){
        x = square.getX() + square.getWidth() / 2 - 2.5 / 2;
        y = square.getY() + square.getHeight() / 2 - 2.5 / 2;
    }

    public void dropCounter(int delta){
        update(delta);
    }

    public void reset(Square square) {
        x = square.getX() + square.getWidth() / 2 - 2.5 / 2;
        y = 20;
        this.setDY(0);
    }
}