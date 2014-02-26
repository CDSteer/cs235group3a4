import org.lwjgl.input.Mouse;

import java.util.List;

/**
 * @file 	OthBoard.java
 * @author 	Chris, Cameron
 * @date	February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @see
 * @brief	This class extends AbstractBoard with othello details
 * @details This class allows us to create an instant of the othello board and draw it on screen.
 */
public class OthBoard extends AbstractBoard{

    private OthSquare[][] m_board;
	// TW Code
    private OthRules othrules;
    private int[][] validMoves;
	
    public OthBoard(){
        super(COLUMN, ROW);
        this.m_board = new OthSquare[ROW][COLUMN];
        this.fillBoard();
		// TW Code
        othrules = new OthRules();

    }

    @Override
    public OthSquare[][] getBoard() {
        return m_board;
    }

    public void startingCounters(List<AbstractCounter> onScreenCounters, OthCounter inPlayCounters[][]){
        for (int i=0; i< ROW; i++) {
            for (int j=0; j< COLUMN; j++) {
                OthCounter othCounter = new OthCounter(0);
                inPlayCounters[i][j] = othCounter;
            }
        }

        m_board[ROW_THREE][COLUMN_THREE].setPlayer(PLAYER_2);
        m_board[ROW_FOUR][COLUMN_FOUR].setPlayer(PLAYER_2);
        m_board[ROW_THREE][COLUMN_FOUR].setPlayer(PLAYER_1);
        m_board[ROW_FOUR][COLUMN_THREE].setPlayer(PLAYER_1);

        m_board[ROW_THREE][COLUMN_THREE].setUsed(true);
        m_board[ROW_FOUR][COLUMN_FOUR].setUsed(true);
        m_board[ROW_THREE][COLUMN_FOUR].setUsed(true);
        m_board[ROW_FOUR][COLUMN_THREE].setUsed(true);

        OthCounter othCounter = new OthCounter(PLAYER_2);
        othCounter.center(m_board[ROW_THREE][COLUMN_THREE]);
        onScreenCounters.add(othCounter);
        inPlayCounters[ROW_THREE][COLUMN_THREE] = othCounter;

        othCounter = new OthCounter(PLAYER_2);
        othCounter.center(m_board[ROW_FOUR][COLUMN_FOUR]);
        onScreenCounters.add(othCounter);
        inPlayCounters[ROW_FOUR][COLUMN_FOUR] = othCounter;

        othCounter = new OthCounter(PLAYER_1);
        othCounter.center(m_board[ROW_THREE][COLUMN_FOUR]);
        onScreenCounters.add(othCounter);
        inPlayCounters[ROW_THREE][COLUMN_FOUR] = othCounter;

        othCounter = new OthCounter(PLAYER_1);
        othCounter.center(m_board[ROW_FOUR][COLUMN_THREE]);
        onScreenCounters.add(othCounter);
        inPlayCounters[ROW_FOUR][COLUMN_THREE] = othCounter;
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
    	// TW Test Code
    	validMoves = othrules.checkValidSet(game.getInPlayCounters());
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (m_board[i][j].inBounds(Mouse.getX(), OthDisplay.HEIGHT - Mouse.getY())&& !m_board[i][j].isUsed()){
                	
                	// TW Test Code
                	if(validMoves[i][j] == game.getTurn() || validMoves[i][j] == BOTH_PLAYERS) {
                		
	                    OthCounter othCounter = new OthCounter(game.getTurn());
	                    othCounter.center(m_board[i][j]);
	                    m_board[i][j].setUsed(true);
	                    game.getInPlayCounters()[i][j] = othCounter;
	                    game.getOnScreenCounters().add(othCounter);
	                    othCounter.playPlaceSound();
						
						// TW Test Code
	                    game.incrementOthCounters();
	                    othrules.flipCounters(game.getInPlayCounters(), i,  j,  game.getTurn());
						
	                    game.nextTurn();
                	} else {
                        game.getCurrentCounter().playNegSound();
                		System.out.println("Error: Invalid move");
                	}
                }else if (m_board[i][j].inBounds(Mouse.getX(), OthDisplay.HEIGHT - Mouse.getY()) && m_board[i][j].isUsed()) {
                    game.getCurrentCounter().playNegSound();
                }
            }
        }
        return true;
    }

    private static final int ROW = 8;
    private static final int COLUMN = 8;
    private static final int ROW_THREE = 3;
    private static final int ROW_FOUR = 4;
    private static final int COLUMN_THREE = 3;
    private static final int COLUMN_FOUR = 4;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static final int X_POS_ASSIGNMENT = 100;
    private static final int FILL_BOARD_ASSIGNMENT = 31;
    private static final int X_POS_ASSIGNMENT_CHANGE= 317;
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2= 2;
    // TW Test Code
    private static final int BOTH_PLAYERS = 3;
    
    private int X_POS = 100;
    private int Y_POS = 50;
}
