import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class C4Board extends AbstractBoard{
    private static Square[][] m_board;

    public C4Board(){
        super(COLUMN, ROW);
        this.m_board = new Square[ROW][COLUMN];
        fillBoard();
    }

    private void fillBoard() {
        int xPos = 100, yPos = 50;
        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
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
        for (int i=0; i< ROW; i++) {
            for (int j=0; j< COLUMN; j++) {
                m_board[i][j].draw();
            }
        }
    }

    public void placeCounter(C4Game c4Game){

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (c4Game.getCurrentCounter().intersects(m_board[i][j]) && !m_board[i][j].isUsed()) {
                    c4Game.getCurrentCounter().setDY(0);
                    c4Game.getCurrentCounter().center(m_board[i][j]);
                    m_board[i][j].setUsed(true);

                    if (i != 0){
                        m_board[i-1][j].setUsed(false);
                    }

                    m_board[i][j].setPlayer(c4Game.getCurrentCounter().getPlayer());
                    c4Game.getOnScreenCounters().add(c4Game.getCurrentCounter());
                    c4Game.nextTurn();
                }
            }
        }

    }

    public Square[][] getM_board() {
        return m_board;
    }

    public void setM_board(Square[][] m_board) {
        this.m_board = m_board;
    }


    private static final int ROW = 7;
    private static final int COLUMN = 10;
}
