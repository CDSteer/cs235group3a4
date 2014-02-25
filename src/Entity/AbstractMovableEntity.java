package Entity;

/**
 * @file 	AbstractMovableEntity.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @see     http://www.youtube.com/user/TheCodingUniverse
 * @brief	Abstract class any entity within the program what moves.
 * @details This class added method for delta in order to move objects
 */
public abstract class AbstractMovableEntity extends AbstractEntity implements MoveableEntity{

    private double dx;
    private double dy;

    /**
     * Constructor for a new entity
     *
     * @param x
     * @param  y
     * @param width
     * @param height
     */
    public AbstractMovableEntity(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.dx = 0;
        this.dy = 0;
    }

    /**
     * calculates the new position of entity
     *
     * @return void
     */
    @Override
    public void update(int delta){
        this.x += delta * dx;
        this.y += delta * dy;
    }
    /**
     * return entity delta x value.
     *
     * @return dX
     */
    public double getDX(){
        return dx;
    }
    /**
     * return entity delta y value.
     *
     * @return dY
     */
    public double getDY(){
        return dy;
    }
    /**
     * set entity delta x value.
     *
     * @return void
     */
    public void setDX(double dx){
        this.dx = dx;
    }
    /**
     * set entity delta y value.
     *
     * @return void
     */
    public void setDY(double dy){
        this.dy = dy;
    }

}