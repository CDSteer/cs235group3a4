
import org.lwjgl.input.Mouse;

import javax.swing.*;
import java.util.List;

/**
* @author Chris Jenkins, Cameron Steer
* @date February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
* @brief This class extends AbstractBoard with othello details
* @details This class allows us to create an instant of the othello board and draw it on screen.
*/
public class OthBoard extends AbstractBoard{

    private OthSquare[][] m_board;
    // TW Code
    private OthRules m_othrules;
    private int[][] m_validMoves;
    private boolean m_anyMovesOne;
    private boolean m_anyMovesTwo;
    private static final String DRAW = "No More Moves, Draw! Click No to close or Yes to play again!";
    private static final String BLACK = "No More Moves, Black wins! Click No to close or Yes to play again!";
    private static final String WHITE = "No More Moves, White wins! Please click No to close or Yes to play again!";
    

    public OthBoard(){
        super(COLUMN, ROW);
        this.m_board = new OthSquare[ROW][COLUMN];
        this.fillBoard();
        
        // TW Code
        m_othrules = new OthRules();

    }

    @Override
    public OthSquare[][] getBoard() {
        return m_board;
    }

    /**
     * starting counter positions
     * @param onScreenCounters
     * @param inPlayCounters
     */
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

    /**
     * draw board
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

                m_board[i][j] = new OthSquare(X_POS, Y_POS, WIDTH, HEIGHT, false);

                 X_POS += FILL_BOARD_ASSIGNMENT;
                if (X_POS > X_POS_ASSIGNMENT_CHANGE) {
                    X_POS = X_POS_ASSIGNMENT;
                    Y_POS += FILL_BOARD_ASSIGNMENT;
                }
            }
        }
    }

    /**
     * method to place a counter on the Othello board
     * @param game
     * @return true
     */
    public boolean placeCounter(OthGame game) {
    	// TW Test Code
    	m_validMoves = m_othrules.checkValidSet(game.getInPlayCounters());

    
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (m_board[i][j].inBounds(Mouse.getX(), OthDisplay.HEIGHT - Mouse.getY())&& !m_board[i][j].isUsed()){
                
                 // TW Test Code
                 if(m_validMoves[i][j] == game.getTurn() || m_validMoves[i][j] == BOTH_PLAYERS) {

					OthCounter othCounter = new OthCounter(game.getTurn());
					othCounter.center(m_board[i][j]);
					m_board[i][j].setUsed(true);
					game.getInPlayCounters()[i][j] = othCounter;
					game.getOnScreenCounters().add(othCounter);
					othCounter.playPlaceSound();
					m_othrules.flipCounters(game.getInPlayCounters(), i, j, game.getTurn());
                    unHightlight();
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
        checkGameOver(game);
        return true;
    }

    /**
     * unhighlight method
     */
    private void unHightlight(){
        for(int i = 0; i < COLUMN; i++) {
            for(int j = 0; j < ROW; j++) {
                m_board[i][j].setlegal(false);
            }
        }
    }
    
    /**
     * method to check if the game is over 
     * @param game
     */
    private void checkGameOver(OthGame game) {
         // Code for ending game
     anyMovesOneCheck = true;
         System.out.println(game.getCounters1() + game.getCounters2());

         if((game.getCounters1() + game.getCounters2()) == MAX_COUNTERS) {
            if(m_othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
                System.out.println("Evaluated: Draw!");
                System.out.println("PLACEHOLDER: EXIT GAME");
                 option = JOptionPane.showConfirmDialog(null, DRAW , "", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION){
                    game.setRunning(false);
                } else if (option == JOptionPane.YES_OPTION){
                    game.playGame();
                }
                anyMovesOneCheck = false;
            } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
                System.out.println("Evaluated: Player 1 win!");
                System.out.println("PLACEHOLDER: EXIT GAME");
                option = JOptionPane.showConfirmDialog(null, BLACK , "", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION){
                    game.setRunning(false);
                } else if (option == JOptionPane.YES_OPTION){
                    game.playGame();
                }
                anyMovesOneCheck = false;
            } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
                 System.out.println("Evaluated: Player 2 win!" );
                 System.out.println("PLACEHOLDER: EXIT GAME");
                 option = JOptionPane.showConfirmDialog(null, WHITE, "", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION){
                    game.setRunning(false);
                } else if (option == JOptionPane.YES_OPTION){
                    game.playGame();
                }
                anyMovesOneCheck = false;
            }
         }
        
        m_validMoves = m_othrules.checkValidSet(game.getInPlayCounters());
        m_anyMovesOne = false;
        m_anyMovesTwo = false;
        if (anyMovesOneCheck = true){
            for(int i = 0; i < COLUMN; i++) {
                for(int j = 0; j < ROW; j++) {
                     if(m_validMoves[i][j] == PLAYER_1 || m_validMoves[i][j] == BOTH_PLAYERS) {
                        if(!m_board[i][j].isUsed()) {
                            m_anyMovesOne = true;
                        }
                     }
                     if(m_validMoves[i][j] == PLAYER_2 || m_validMoves[i][j] == BOTH_PLAYERS) {
                         if(!m_board[i][j].isUsed()) {
                            m_anyMovesTwo = true;
                         }
                     }
                }
            }

            if(game.getTurn() == PLAYER_1 && m_anyMovesOne == false) {
                if(m_othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
                    System.out.println("Evaluated: Draw!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, DRAW, "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
                    System.out.println("Evaluated: Player 1 win!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, BLACK , "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
                    System.out.println("Evaluated: Player 2 win!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, WHITE, "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                }
            } else if(game.getTurn() == PLAYER_2 && m_anyMovesTwo == false) {

                if(m_othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
                    System.out.println("Evaluated: Draw!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, DRAW, "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
                    System.out.println("Evaluated: Player 1 win!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, BLACK, "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                } else if (m_othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
                    System.out.println("Evaluated: Player 2 win!");
                    System.out.println("PLACEHOLDER: EXIT GAME");
                    option = JOptionPane.showConfirmDialog(null, WHITE , "", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.NO_OPTION){
                        game.setRunning(false);
                    } else if (option == JOptionPane.YES_OPTION){
                        game.playGame();
                    }
                }
            }
        }
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
    private static final int NO_WINNER = 0;
    private static final int BOTH_PLAYERS = 3;
    private static final int MAX_COUNTERS = 60;
    
    private int X_POS = 100;
    private int Y_POS = 50;
    private int option;
    private boolean anyMovesOneCheck;
}
