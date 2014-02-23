import java.util.List;

/**
 * @file 	AbstractBoard.java
 * @author 	Chris, Cameron
 * @date	February 1, 2014
 * @see
 * @brief	Class had common data and methods for both boards
 * @details This class allows us to create an instant of board before its instantiated as a specific game board
 */
public abstract class AbstractBoard {

    private int m_Column;
    private int m_Row;
    private AbstractSquare[][] m_board;

    public AbstractBoard(int column, int row){
        this.m_Column = column;
        this.m_Row = row;
        this.m_board = new AbstractSquare[row][column];
    }

    public int getM_Column() {
        return m_Column;
    }

    public void setM_Column(int m_Column) {
        this.m_Column = m_Column;
    }

    public int getM_Row() {
        return m_Row;
    }

    public void setM_Row(int m_Row) {
        this.m_Row = m_Row;
    }

    public abstract void draw();

    public abstract AbstractSquare[][] getBoard();

    //115 + (31 * (x-1))  where x is the number of squares across
    public abstract void fillBoard();

    //public abstract boolean placeCounter(AbstractCounter currentCounter, List<AbstractCounter> onScreenCounters);
}
