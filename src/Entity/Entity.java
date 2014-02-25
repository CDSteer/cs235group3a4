package Entity;

/**
 * @file 	Entity.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @see     http://www.youtube.com/user/TheCodingUniverse
 * @brief	Interface for any entity within the program
 * @details
 */
public interface Entity {
    /**
     * method will draw the entity
     *
     * @return void
     */
    public void draw();
    /**
     * update entity delta value
     *
     * @return void
     */
    public void update(int delta);
    /**
     * set entity x value.
     *
     * @return void
     */
    public void setX(double x);
    /**
     * set entity y value.
     *
     * @return void
     */
    public void setY(double y);
    /**
     * set entity width value.
     *
     * @return void
     */
    public void setWidth(double width);
    /**
     * set entity height value.
     *
     * @return void
     */
    public void setHeight(double height);
    /**
     * return entity x value.
     *
     * @return x
     */
    public double getX();
    /**
     * return entity y value.
     *
     * @return y
     */
    public double getY();
    /**
     * return entity height value.
     *
     * @return height
     */
    public double getHeight();
    /**
     * return entity width value.
     *
     * @return width
     */
    public double getWidth();
    /**
     * checks is entity intersects on another
     *
     * @return boolean
     */
    public boolean intersects(Entity other);
}
