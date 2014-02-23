import org.lwjgl.input.Mouse;

import java.util.List;

/**
 * @file 	OthBoard.java
 * @author 	Chris, Cameron
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

    public void startingCounters(List<AbstractCounter> onScreenCounters, OthCounter inPlayCounters[][]){

        m_board[3][3].setPlayer(2);
        m_board[4][4].setPlayer(2);
        m_board[3][4].setPlayer(1);
        m_board[4][3].setPlayer(1);

        m_board[3][3].isUsed();
        m_board[4][4].isUsed();
        m_board[3][4].isUsed();
        m_board[4][3].isUsed();

        OthCounter othCounter = new OthCounter(2);
        othCounter.center(m_board[3][3]);
        onScreenCounters.add(othCounter);
        inPlayCounters[3][3] = othCounter;

        othCounter = new OthCounter(2);
        othCounter.center(m_board[4][4]);
        onScreenCounters.add(othCounter);
        inPlayCounters[4][4] = othCounter;

        othCounter = new OthCounter(1);
        othCounter.center(m_board[3][4]);
        onScreenCounters.add(othCounter);
        inPlayCounters[3][4] = othCounter;

        othCounter = new OthCounter(1);
        othCounter.center(m_board[4][3]);
        onScreenCounters.add(othCounter);
        inPlayCounters[4][3] = othCounter;


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

        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {

                m_board[i][j] = new OthSquare(X_POS, Y_POS, WIDTH, HEIGHT, false);

                 X_POS += FILL_BOARD_ASSIGNMENT;
                if (X_POS > X_POS_ASSIGNMENT_CHANGE) {
                    X_POS = X_POS_ASSIGNMENT;
                    Y_POS += FILL_BOARD_ASSIGNMENT;
                }
            }
        }
    }


    public boolean placeCounter(OthGame game) {

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (m_board[i][j].inBounds(Mouse.getX(), OthDisplay.HEIGHT - Mouse.getY())&& !m_board[i][j].isUsed()){
                    OthCounter othCounter = new OthCounter(game.getTurn());
                    othCounter.center(m_board[i][j]);
                    m_board[i][j].setUsed(true);
                    game.getInPlayCounters()[i][j] = othCounter;
                    game.getOnScreenCounters().add(othCounter);
                    game.nextTurn();
                }
            }
        }
        return true;
    }

    private static final int ROW = 8;
    private static final int COLUMN = 8;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static final int X_POS_ASSIGNMENT = 100;
    private static final int FILL_BOARD_ASSIGNMENT = 31;
    private static final int X_POS_ASSIGNMENT_CHANGE= 317;
    private int X_POS = 100;
    private int Y_POS = 50;
}
