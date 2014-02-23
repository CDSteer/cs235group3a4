import java.util.List;

/**
 * @file 	C4Board.java
 * @author 	Chris, Cameron
 * @date	February 1, 2014
 * @see
 * @brief	This class extends AbstractBoard with connect 4 details
 * @details This class allows us to create an instant of the connect 4 board and draw it on screen.
 */
public class C4Board extends AbstractBoard{

    private C4Square[][] m_board;

    public C4Board(){
        super(COLUMN, ROW);
        this.m_board = new C4Square[ROW][COLUMN];
        this.fillBoard();
    }

    @Override
    public C4Square[][] getBoard() {
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
                if (i != 6){
                    m_board[i][j] = new C4Square(xPos, yPos, 30, 30, true);
                } else {
                    m_board[i][j] = new C4Square(xPos, yPos, 30, 30, false);
                }

                xPos += 31;
                if (xPos > 409) {
                    xPos = 100;
                    yPos += 31;
                }
            }
        }
    }

    public boolean placeCounter(AbstractCounter counter, List<AbstractCounter> onScreenCounters){
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                //if the colunm full reset
                if (counter.intersects(getBoard()[i][j]) && getBoard()[i][j].getPlayer() > 0){
                    counter.toSting();
                    counter.reset(getBoard()[i][j]);
                    counter.toSting();

                }

                if (counter.intersects(getBoard()[i][j]) && !getBoard()[i][j].isUsed()) {
                    counter.setDY(0);
                    counter.center(getBoard()[i][j]);
                    getBoard()[i][j].setUsed(true);

                    if (i != 0){
                        getBoard()[i-1][j].setUsed(false);
                    }

                    getBoard()[i][j].setPlayer(counter.getPlayer());
                    onScreenCounters.add(counter);
                    return true;
                }
            }
        }
        return false;

    }

    public void unBind(){
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                this.getBoard()[i][j].releaseTexture();
            }
        }

    }
    private static final int ROW = 7;
    private static final int COLUMN = 10;
}
