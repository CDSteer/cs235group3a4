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
    private Square[][] m_board;

    public AbstractBoard(int column, int row){
        this.m_Column = column;
        this.m_Row = row;
        this.m_board = new Square[row][column];
    }

    public Square[][] getBoard() {
        return m_board;
    }

    public void draw(){
        for (int i=0; i< m_Row; i++) {
            for (int j=0; j< m_Column; j++) {
                m_board[i][j].draw();
            }
        }
    }

    public boolean placeCounter(Counter counter, List<Counter> onScreenCounters){
        for (int i=0; i<m_Row; i++) {
            for (int j=0; j<m_Column; j++) {
                if (counter.intersects(m_board[i][j]) && m_board[i][j].getPlayer() > 0){
                    counter.reset(m_board[i][j]);
                }

                if (counter.intersects(m_board[i][j]) && !m_board[i][j].isUsed()) {
                    counter.setDY(0);
                    counter.center(m_board[i][j]);
                    m_board[i][j].setUsed(true);

                    if (i != 0){
                        m_board[i-1][j].setUsed(false);
                    }

                    m_board[i][j].setPlayer(counter.getPlayer());
                    onScreenCounters.add(counter);
                    return true;
                }
            }
        }
        return false;

    }

    //115 + (31 * (x-1))  were x is the number of squares across
    public abstract void fillBoard();
}
