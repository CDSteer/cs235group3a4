
import org.lwjgl.input.Mouse;

import java.util.List;

/**
* @file OthBoard.java
* @author Chris, Cameron
* @date February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
* @see
* @brief This class extends AbstractBoard with othello details
* @details This class allows us to create an instant of the othello board and draw it on screen.
*/
public class OthBoard extends AbstractBoard{

    private OthSquare[][] m_board;
    // TW Code
    private OthRules othrules;
    private int[][] validMoves;
    private boolean anyMovesOne;
    private boolean anyMovesTwo;
    

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
					othrules.flipCounters(game.getInPlayCounters(), i, j, game.getTurn());
					
					for(int a = 0; a < COLUMN; a++) {
			            for(int b = 0; b < ROW; b++) {               
			            	m_board[a][b].setlegal(false);
			            }
			    	}
					
					
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
    
    private void checkGameOver(OthGame game) {
    
     // Code for ending game
        System.out.println(game.getOthCounters1() + game.getOthCounters2());
        if((game.getOthCounters1() + game.getOthCounters2()) == MAX_COUNTERS) {
         if(othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
     System.out.println("Evaluated: Draw!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
     System.out.println("Evaluated: Player 1 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
     System.out.println("Evaluated: Player 2 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     }
       }
        
        validMoves = othrules.checkValidSet(game.getInPlayCounters());
        anyMovesOne = false;
        anyMovesTwo = false;
        
        for(int i = 0; i < COLUMN; i++) {
         for(int j = 0; j < ROW; j++) {
        
         if(validMoves[i][j] == PLAYER_1 || validMoves[i][j] == BOTH_PLAYERS) {
         if(!m_board[i][j].isUsed()) {
         anyMovesOne = true;
         }
         }
         if(validMoves[i][j] == PLAYER_2 || validMoves[i][j] == BOTH_PLAYERS) {
         if(!m_board[i][j].isUsed()) {
         anyMovesTwo = true;
         }
         }
         }
        }
        
        if(game.getTurn() == PLAYER_1 && anyMovesOne == false) {
         if(othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
     System.out.println("Evaluated: Draw!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
     System.out.println("Evaluated: Player 1 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
     System.out.println("Evaluated: Player 2 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     }
        }else if(game.getTurn() == PLAYER_2 && anyMovesTwo == false) {
         if(othrules.winCondition(game.getInPlayCounters()) == NO_WINNER) {
     System.out.println("Evaluated: Draw!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_1) {
     System.out.println("Evaluated: Player 1 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
     } else if (othrules.winCondition(game.getInPlayCounters()) == PLAYER_2) {
     System.out.println("Evaluated: Player 2 win!");
     System.out.println("PLACEHOLDER: EXIT GAME");
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
}
