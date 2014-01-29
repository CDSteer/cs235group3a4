import Entity.AbstractEntity;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 29/01/2014
 * @version *.*
 */

public class Square extends AbstractEntity {

    private boolean used;

    public Square(double x, double y, double width, double height, boolean used) {
        super(x, y, width, height);
        this.used = used;
    }

    @Override
    public void draw() {
        glColor3d(0,0.5,1.0);
        glRectd(x, y, x + width, y + height);
    }

    public void setUsed(boolean used){
        this.used = used;
    }

    public boolean isUsed(){
        return used;
    }

    @Override
    public void update(int delta) {
         // do nothing.
    }
}
