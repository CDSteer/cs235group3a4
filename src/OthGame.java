import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer, Martin
 * @date   Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @since 04/02/2014
 *         - updated 20/02/2014
 * @version *1.2*
 */
public class OthGame extends AbstractGame {

    private OthCounter currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    private List<AbstractCounter> onScreenCounters;				//Abstract Counter information
    private int m_Turn;
    private OthCounter m_InPlayCounters[][];
    private int[][] validMoves;
    //TW Test Code
    private OthRules othRules;
    private int currentCounters1 = 0;
    private int currentCounters2 = 0;
    private OthBoard m_Board;
    private OthDisplay m_Display;
    private OthInput m_GameInput;


    public OthGame() {
        super(true);
        m_Display = new OthDisplay();
        m_GameInput = new OthInput();
		this.currentCounter = new OthCounter(PLAYER_1);
        this.player1 = new HumPlayer(PLAYER_1);
        this.player2 = new HumPlayer(PLAYER_2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(LIST_ELEMENTS);
        this.m_Board = new OthBoard();
        this.m_InPlayCounters = new OthCounter[ROW_EIGHT][COLUMN_EIGHT];
        m_Board.startingCounters(onScreenCounters, m_InPlayCounters);
        this.m_Turn = PLAYER_1;
        // TW Test Code
        othRules = new OthRules();
        highLightValid();
        calcCounters();
    }

    public OthCounter[][] getInPlayCounters() {
        return m_InPlayCounters;
    }

    public void setInPlayCounters(OthCounter[][] m_InPlayCounters) {
        this.m_InPlayCounters = m_InPlayCounters;
    }

    public int getTurn() {
        return m_Turn;
    }

    public void setTurn(int turn) {
        this.m_Turn = turn;
    }

    /**
     * Recieve Board information from OthBoard Class
     * @param  /null
     * @return OthBoard
     */
    @Override
    public OthBoard getBoard(){
        return m_Board;
    }
    

    /**
     * Set OthBoard
     * @param  c4Board
     * @return null
     */
    public void setOthBoard(C4Board c4Board) {
        this.m_Board = m_Board;
    }

	/**
	 * Recieve Counter information from Counter Class
	 * @param
	 * @return AbstractCounter
	 */
    @Override
    public AbstractCounter getCurrentCounter() {
        return currentCounter;  //Is this ready yet?
    }

	/**
	 * Recieve on screen Counter information from AbstractCounter Class
	 * @param
	 * @return List<AbstractCounter>
	 */
    @Override
    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;  //Is this ready yet?
    }
    
    // TW Test Method
    public void calcCounters() {
    	
    	int temp_1 = 0;
    	int temp_2 = 0;
    	for(int i = 0; i < COLUMN_EIGHT; i++) {
    		for (int j = 0; j < ROW_EIGHT; j++) {
    			if(getInPlayCounters()[i][j].getPlayer() == PLAYER_1) {
    				temp_1++;
    			} else if (getInPlayCounters()[i][j].getPlayer() == PLAYER_2) {
    				temp_2++;
    			}
    		}
    	}
    	
    	setCounters1(temp_1);
    	setCounters2(temp_2);
    }
    
    // TW Test Method
    public int getCounters1() {
    	return currentCounters1;
    }
    
    public int getCounters2() {
    	return currentCounters2;
    }
    
    public void setCounters1(int value) {
    	currentCounters1 = value;
    }
    
    public void setCounters2(int value) {
    	currentCounters2 = value;
    }

    /** initOthello method for calling Othello game board */
    public void init() {

        new OthGame();
        /** set up timer for othello game */
        this.getTime().setUpTimer();

        /** display the othello game board */
        m_Display.setUpDisplay();
        m_Display.setUpOpenGL();
        gameLoop();

        Display.destroy();
    }

	/**
	 * *****CAMERON, I have no idea what's this doing...*******
	 * @return null
	 */
    @Override
    public void gameLoop() {
        while (isRunning()) {
            m_GameInput.inputLoop(this);
            m_Display.render(this);
            Display.update();
            Display.sync(this.getTime().getFrameRate());
            if (Display.isCloseRequested()) {
                setRunning(false);
            }
        }
    }

    /**
	 * Game begin, Create Counter and Board
	 *
	 * @return Nothing is returned from the method.
	 */
    @Override
    public void playGame() {
        currentCounter = new OthCounter(PLAYER_1);
        m_Board = new OthBoard();
    }

	/**
	 * Checking which player is on next turn
	 * @return Nothing is returned from the method
	 */
    @Override
    public void nextTurn() {
    	
    	calcCounters();
        if (this.m_Turn == PLAYER_1){
            this.m_Turn = PLAYER_2;
        } else {
            this.m_Turn = PLAYER_1;
        }
        highLightValid();
        
    }
    
    private void highLightValid(){
        validMoves = othRules.checkValidSet(this.getInPlayCounters());
        for(int i = 0; i < COLUMN_EIGHT; i++) {
            for(int j = 0; j < ROW_EIGHT; j++) {
                if(validMoves[i][j] == this.getTurn() || validMoves[i][j] == BOTH_PLAYERS) {
                    if(!m_Board.getBoard()[i][j].isUsed()) {
                        m_Board.getBoard()[i][j].setlegal(true);
                    }
                }
            }
        }
    }
	
	/**
	 * This game determines the end of the game for Othello. The game will terminate and a message
     * is display if there is a winner, Player 1 or Player 2. There is also an option to reset the board
     * and play again.
	 * @return Nothing is returned from the method.
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;
    private static final int LIST_ELEMENTS = 10;
    private static final int ROW_EIGHT = 8;
    private static final int COLUMN_EIGHT = 8;
    private static final int BOTH_PLAYERS = 3;
}
