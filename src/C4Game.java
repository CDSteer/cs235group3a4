import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @file C4Game.java
 *
 * @brief This file is the main panel, allocating information and data into
 *        every inherit classes, maintaining game process.
 *
 * @author Cameron Steer
 * @author Martin Hui
 * @date February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @version *1.2*
 * @since February 20, 2014
 */
public class C4Game extends AbstractGame{

    private C4Counter currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    private List<AbstractCounter> onScreenCounters;				//Abstract Counter information
    private int m_Turn = 1;

    // TW Test Code
    private C4Rules c4rules;
    private C4Board m_Board;

	/**
	* @brief Collecting and storing every data from graphic, rules, player.
	* @see C4Board
	* @see HumPlayer
	* @see C4Counter
	* @return void
	*/
    public C4Game() {
        super(true);
        this.currentCounter = new C4Counter();
        this.player1 = new HumPlayer(PLAYER1);
        this.player2 = new HumPlayer(PLAYER2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(ON_SCREEN_COUNTERS_ELEMENTS);
        this.m_Board = new C4Board();
        // TW Test Code
        c4rules = new C4Rules();
        
    }
	/**
	 * @brief Receive Board information from C4Board Class
	 * @see C4Board
	 * @return C4Board
	 */
    public C4Board getBoard() {
        return m_Board;
    }

    @Override
    public int getTurn() {
        return m_Turn;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
	 * @brief Set C4Board
	 * @see C4Board
	 * @param  c4Board
	 * @return null
	 */
    public void setBoard(C4Board c4Board) {
        this.m_Board = c4Board;
    }

	/**
	 * @brief Receive Current Counter information from Counter Class
	 * @see C4Counter
	 * @return AbstractCounter
	 */
    public AbstractCounter getCurrentCounter() {
        return currentCounter;
    }

	/**
	 * @brief Receive on screen Counter information from AbstractCounter Class
	 * @see C4Counter
	 * @return List<AbstractCounter>
	 */
    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;
    }

	/**
	 * @brief Game begin, create Counter and Board
	 * @see C4Board
	 * @see C4Counter
	 * @return null
	 */
    @Override
    public void playGame() {
        currentCounter = new C4Counter();
        m_Board = new C4Board();
    }

	/**
	 * @brief Checking which player is on next turn
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (currentCounter.getPlayer() == PLAYER1){
            currentCounter = new C4Counter();
            currentCounter.setPlayer(PLAYER2);
            m_Turn = 2;
        } else {
            currentCounter = new C4Counter();
            currentCounter.setPlayer(PLAYER1);
            m_Turn = 1;
        }
        // TW Test Code
        if(c4rules.winCondition(m_Board) == 0) {
        	System.out.println("Evaluated: No Winner");
        } else if (c4rules.winCondition(m_Board) == PLAYER1) {
        	System.out.println("Evaluated: Player 1 Wins");
        } else if (c4rules.winCondition(m_Board) == PLAYER2) {
        	System.out.println("Evaluated: Player 2 Wins");
        } else {
        	System.out.println("Error: No Evaluation");
        }
        
    }
	
//	public void redTurn(){
//		//nextTurn() must return sth. or
//		//implement this together with nextTurn()
//		//This method is not on abstract class
//	}
//
//	public void yellowTurn(){
//		//nextTurn() must return sth.
//		//or implement this together with nextTurn()
//		//This method is not on abstract class
//	}
//
//	public void setRed(player redPlayer){
//		//Need display class
//		//This method is not on abstract class
//	}
//
//	public void setYellow(player yellowPlayer){
//		//Need display class
//		//This method is not on abstract class
//	}
	
	/**
	 * @brief Game End
	 * @return null
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

	/**
	 * @brief *****CAMERON, I have no idea what's this doing...*******
	 * @see AbstractGame
	 * @param  game
     * @param delta
	 * @return void
	 */
    @Override
    public void gameLoop(AbstractGame game, int delta) {
        currentCounter.dropCounter(delta);
        if (m_Board.placeCounter(currentCounter, this.onScreenCounters)){
            this.nextTurn();
        }

    }

    private static final int PLAYER2 = 2;
    private static final int PLAYER1 = 1;
    private static final int ON_SCREEN_COUNTERS_ELEMENTS = 10;
}
