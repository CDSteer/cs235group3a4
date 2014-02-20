import java.util.List;

/**
 * @file 	OthBoard.java
 * @author 	Cameron Steer
 * @date	February 1, 2014
 * @see
 * @brief	This class extends AbstractBoard with othello details
 * @details This class allows us to create an instant of the othello board and draw it on screen.
 */
public class OthBoard extends AbstractBoard{

    private OthSquare[][] m_board;

    public OthBoard(){
        super(COLUMN, ROW);
        this.m_board = new OthSquare[ROW][COLUMN];
        this.fillBoard();
    }

    @Override
    public OthSquare[][] getBoard() {
        return m_board;
    }

    @Override
    public void draw(){
        for (int i=0; i< ROW; i++) {
            for (int j=0; j< COLUMN; j++) {
                m_board[i][j].draw();
            }
        }
    }

    @Override
    public void fillBoard() {
        int xPos = 100, yPos = 50;
        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {

                m_board[i][j] = new OthSquare(xPos, yPos, 30, 30, true);

                xPos += 31;
                if (xPos > 317) {
                    xPos = 100;
                    yPos += 31;
                }
            }
        }
    }

    @Override
    public boolean placeCounter(AbstractCounter currentCounter, List<AbstractCounter> onScreenCounters) {
        return false;
    }

    private static final int ROW = 8;
    private static final int COLUMN = 8;
}
