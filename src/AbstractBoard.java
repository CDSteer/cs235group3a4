import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
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

    public abstract void draw();

    public abstract AbstractSquare[][] getBoard();

    //115 + (31 * (x-1))  were x is the number of squares across
    public abstract void fillBoard();

    public abstract boolean placeCounter(AbstractCounter currentCounter, List<AbstractCounter> onScreenCounters);
}
