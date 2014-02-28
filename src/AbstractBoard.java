/**
 * @author 	Chris, Cameron
 * @since	February 1, 2014
 * @see
 * @brief	Class has common data and methods for both boards
 * @details This class allows us to create an instance of a board before its instantiated as a specific game board
 */
public abstract class AbstractBoard {

    private int m_Column;
    private int m_Row;
    private AbstractSquare[][] m_board;

    /**
     * sets a new AbstractSquare in the approrpiate row and column
     * @param column
     * @param row
     */
    public AbstractBoard(int column, int row){
        this.m_Column = column;
        this.m_Row = row;
        this.m_board = new AbstractSquare[row][column];
    }

    /**
     * gets the m_Column value
     * @return m_Column
     */
    public int getM_Column() {
        return m_Column;
    }

    /**
     * sets the m_Column value
     * @param m_Column
     */
    public void setM_Column(int m_Column) {
        this.m_Column = m_Column;
    }

    /**
     * gets the m_Row value
     * @return m_Row
     */
    public int getM_Row() {
        return m_Row;
    }

    /**
     * method to set the m_Row value
     * @param m_Row
     */
    public void setM_Row(int m_Row) {
        this.m_Row = m_Row;
    }

    /**
     * calls the draw method
     */
    public abstract void draw();

    /**
     * calls the AbstractSquare coordinates and gets the board
     * @return
     */
    public abstract AbstractSquare[][] getBoard();

    /**
     * 115 + (31 * (x-1))  where x is the number of squares across
     */
    public abstract void fillBoard();


}