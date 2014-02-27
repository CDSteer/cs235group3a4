import java.util.List;

/**
 * @author 	Chris Jenkins, Cameron Steer
 * @since February 1, 2014
 * @date Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @brief	This class extends AbstractBoard with connect 4 details
 * @details This class allows us to create an instant of the connect 4 board and draw it on screen.
 */
public class C4Board extends AbstractBoard{

    private C4Square[][] m_board;

    /**
     * set the C4 game board up with row and column sizes
     */
    public C4Board(){
        super(COLUMN, ROW);
        this.m_board = new C4Square[ROW][COLUMN];
        this.fillBoard();
    }

    /**
     * get the board
     * @return m_board
     */
    @Override
    public C4Square[][] getBoard() {
        return m_board;
    }

    /**
     * draw the game board
     */
    @Override
    public void draw(){
        for (int i=0; i< ROW; i++) {
            for (int j=0; j< COLUMN; j++) {
                m_board[i][j].draw();
            }
        }
    }

    /**
     * fill the game board
     */
    @Override
    public void fillBoard() {

        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (i != ROW_MAX){
                    m_board[i][j] = new C4Square(X_POS, Y_POS, WIDTH, HEIGHT, true);
                } else {
                    m_board[i][j] = new C4Square(X_POS, Y_POS, WIDTH, HEIGHT, false);
                }

                X_POS += FILL_BOARD_ASSIGNMENT;
                if (X_POS > X_POS_ASSIGNMENT_CHANGE) {
                    X_POS = X_POS_ASSIGNMENT;
                    Y_POS += FILL_BOARD_ASSIGNMENT;
                }
            }
        }
    }

    /**
     * places the counter from the AbstractCounter location
     * @param counter
     * @param onScreenCounters
     * @return false
     */
    public boolean placeCounter(AbstractCounter counter, List<AbstractCounter> onScreenCounters){
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                //if the colunm full reset
                if (counter.intersects(getBoard()[i][j]) && getBoard()[i][j].getPlayer() > 0){
                    counter.playNegSound();
                    counter.reset(getBoard()[i][j]);
                    counter.toSting();

                }

                if (counter.intersects(getBoard()[i][j]) && !getBoard()[i][j].isUsed()) {
                    counter.playPlaceSound();
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

    /**
     * OpenGL unbind
     */
    public void unBind(){
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                this.getBoard()[i][j].releaseTexture();
            }
        }

    }
    private static final int ROW = 7;
    private static final int COLUMN = 10;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static final int ROW_MAX = 6;
    private static final int X_POS_ASSIGNMENT = 100;
    private static final int FILL_BOARD_ASSIGNMENT = 31;
    private static final int X_POS_ASSIGNMENT_CHANGE = 409;
    private int X_POS = 100;
    private int Y_POS = 50;
}
