package Entity;

/**
 * @file 	MoveableEntity.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @see     http://www.youtube.com/user/TheCodingUniverse
 * @brief	Interface for a movable entity
 * @details This extends the methods in entity adding methods for delta values used for moving the values
 *
 */
public interface MoveableEntity extends Entity{
    /**
     * return entity delta x value.
     *
     * @return dx
     */
    public double getDX();
    /**
     * return entity delta y value.
     *
     * @return dY
     */
    public double getDY();
    /**
     * set entity delta x value.
     *
     * @return void
     */
    public void setDX(double dx);
    /**
     * set entity delta x value.
     *
     * @return void
     */
    public void setDY(double dy);

}
