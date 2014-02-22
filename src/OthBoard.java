import org.lwjgl.input.Mouse;

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

    public void startingCounters(List<AbstractCounter> onScreenCounters){

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
        othCounter = new OthCounter(2);
        othCounter.center(m_board[4][4]);
        onScreenCounters.add(othCounter);
        othCounter = new OthCounter(1);
        othCounter.center(m_board[3][4]);
        onScreenCounters.add(othCounter);
        othCounter = new OthCounter(1);
        othCounter.center(m_board[4][3]);
        onScreenCounters.add(othCounter);


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

                m_board[i][j] = new OthSquare(xPos, yPos, 30, 30, false);

                xPos += 31;
                if (xPos > 317) {
                    xPos = 100;
                    yPos += 31;
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
                    game.getOnScreenCounters().add(othCounter);
                    game.nextTurn();
                }
            }
        }
        return true;
    }

    private static final int ROW = 8;
    private static final int COLUMN = 8;
}
