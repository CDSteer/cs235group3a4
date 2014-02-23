import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer, Martin
 * @since 04/02/2014
 *         - updated 20/02/2014
 * @version *1.2*
 */
public class OthGame extends AbstractGame {

    private OthCounter currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    //Arraylist used here for fast rendering
    private List<AbstractCounter> m_OnScreenCounters;				//Abstract Counter information
    //Array used here for accuracy when othello rule rule checking
    private OthCounter m_InPlayCounters[][];
    private int m_Turn;
    
    // TW Test Code
    //private OthRules othRules;                                //Waiting for othrules to implement
    private OthBoard othBoard;


    public OthGame() {
        super(true);
		this.currentCounter = new OthCounter(1);
        this.player1 = new HumPlayer(1);
        this.player2 = new HumPlayer(2);
        this.m_OnScreenCounters = new ArrayList<AbstractCounter>(10);
        this.othBoard = new OthBoard();
        this.m_Turn = 1;
        this.m_InPlayCounters = new OthCounter[8][8];
        othBoard.startingCounters(m_OnScreenCounters, m_InPlayCounters);
        // TW Test Code
        //othrules = new OthRules();							//Waiting for othrules to implement
    }

    public OthCounter[][] getInPlayCounters() {
        return m_InPlayCounters;
    }

    public void setInPlayCounters(OthCounter[][] inPlayCounters) {
        this.m_InPlayCounters = inPlayCounters;
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
        return m_OnScreenCounters;  //Is this ready yet?
    }

	/**
	 * *****CAMERON, I have no idea what's this doing...*******
	 * @param  game, deta
	 * @return null
	 */
    @Override
    public void gameLoop(AbstractGame game, int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

	/**
	 * Game begin, Create Counter and Board
	 * @param
	 * @return null
	 */
    @Override
    public void playGame() {
        currentCounter = new OthCounter(1);
        othBoard = new OthBoard();
    }

	/**
	 * Checking which player is on next turn
	 * @param
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (this.m_Turn == 1){
            this.m_Turn = 2;
        } else {
            this.m_Turn = 1;
        }
		/*
        // TW Test Code
        if(Othrules.winCondition(OthBoard) == 0) {
        	System.out.println("Evaluated: No Winner");
        } else if (Othrules.winCondition(OthBoard) == 1) {
        	System.out.println("Evaluated: Player 1 Wins");
        } else if (Othrules.winCondition(OthBoard) == 2) {
        	System.out.println("Evaluated: Player 2 Wins");
        } else {
        	System.out.println("Error: No Evaluation");
        }
        */
    
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
	 * Game end
	 * @param
	 * @return null
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
