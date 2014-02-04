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

    public Square[][] getBoard() {
        return m_board;
    }

    public void setBoard(Square[][] m_board) {
        this.m_board = m_board;
    }

    public void fillBoard() {
        int xPos = 100, yPos = 50;
        for (int i=0; i< m_Row; i++) {
            for (int j=0; j<m_Column; j++) {
                if (i != 6){
                    m_board[i][j] = new Square(xPos, yPos, 30, 30, true);
                } else {
                    m_board[i][j] = new Square(xPos, yPos, 30, 30, false);
                }

                xPos += 31;
                if (xPos > 409) {
                    xPos = 100;
                    yPos += 31;
                }
            }
        }
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
}
