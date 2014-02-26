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
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;
    private static final int LIST_ELEMENTS = 10;
    private static final int ROW_EIGHT = 8;
    private static final int COLUMN_EIGHT = 8;
    
    //TW Test Code
    private OthRules othRules;
    private int currentCounters1 = 0;
    private int currentCounters2 = 0;
	
    private OthBoard othBoard;


    public OthGame() {
        super(true);
		this.currentCounter = new OthCounter(PLAYER_1);
        this.player1 = new HumPlayer(PLAYER_1);
        this.player2 = new HumPlayer(PLAYER_2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(LIST_ELEMENTS);
        this.othBoard = new OthBoard();
        this.m_InPlayCounters = new OthCounter[ROW_EIGHT][COLUMN_EIGHT];
        othBoard.startingCounters(onScreenCounters, m_InPlayCounters);
        this.m_Turn = PLAYER_1;
        // TW Test Code
        othRules = new OthRules();
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
    public OthBoard getOthBoard() {
        return othBoard;
    }

    /**
     * Set OthBoard
     * @param  c4Board
     * @return null
     */
    public void setOthBoard(C4Board c4Board) {
        this.othBoard = othBoard;
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
    public void incrementOthCounters() {
    	currentCounters1++;
    }
    
    // TW Test Method
    public int getOthCounters1() {
    	return currentCounters1;
    }
    
    public int getOthCounters2() {
    	return currentCounters2;
    }
        

	/**
	 * *****CAMERON, I have no idea what's this doing...*******
	 * @param  game
     * @param  delta
	 * @return null
	 */
    @Override
    public void gameLoop(AbstractGame game, int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AbstractBoard getBoard() {
        return othBoard;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
	 * Game begin, Create Counter and Board
	 *
	 * @return Nothing is returned from the method.
	 */
    @Override
    public void playGame() {
        currentCounter = new OthCounter(PLAYER_1);
        othBoard = new OthBoard();
    }

	/**
	 * Checking which player is on next turn
	 * @return Nothing is returned from the method
	 */
    @Override
    public void nextTurn() {
        if (this.m_Turn == PLAYER_1){
            this.m_Turn = PLAYER_2;
        } else {
            this.m_Turn = PLAYER_1;
        }
		
    }
	
//	public void blackTurn(){
//		//nextTurn() must return sth.
//		//or just implement it together.
//	}
//
//	public void whiteTurn(){
//		//nextTurn() must return sth.
//		//or just implement it together.
//	}
//
//	public void setBlack(player blackPlayer){
//		//Waiting for display class
//	}
//
//	public void setWhite(player whitePlayer){
//		//waiting for display class
//	}
	
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
	
	
}
