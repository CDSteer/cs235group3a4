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
 * @date February 1, 2014
 * @version *1.2*
 * @since February 20, 2014
 */
public class C4Game extends AbstractGame{

    private C4Counter currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    private List<AbstractCounter> onScreenCounters;				//Abstract Counter information
    
    // TW Test Code
    private C4Rules c4rules;
    private C4Board c4Board;

	/**
	* @brief Collecting and storing every data from graphic, rules, player.
	* @see C4Board
	* @see HumPlayer
	* @see C4Counter
	* @param null
	* @return null
	*/
    public C4Game() {
        super(true);
        this.currentCounter = new C4Counter();
        this.player1 = new HumPlayer(1);
        this.player2 = new HumPlayer(2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(10);
        this.c4Board = new C4Board();
        // TW Test Code
        c4rules = new C4Rules();
        
    }
	/**
	 * @brief Recieve Board information from C4Board Class
	 * @see C4Board
	 * @param  null
	 * @return C4Board
	 */
    public C4Board getC4Board() {
        return c4Board;
    }

	/**
	 * @brief Set C4Board
	 * @see C4Board
	 * @param  C4Board
	 * @return null
	 */
    public void setC4Board(C4Board c4Board) {
        this.c4Board = c4Board;
    }

	/**
	 * @brief Recieve Current Counter information from Counter Class
	 * @see C4Counter
	 * @param  null
	 * @return AbstractCounter
	 */
    public AbstractCounter getCurrentCounter() {
        return currentCounter;
    }

	/**
	 * @brief Recieve on screen Counter information from AbstractCounter Class
	 * @see C4Counter
	 * @param  null
	 * @return List<AbstractCounter>
	 */
    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;
    }

	/**
	 * @brief Game begin, create Counter and Board
	 * @see C4Board
	 * @see C4Counter
	 * @param  null
	 * @return null
	 */
    @Override
    public void playGame() {
        currentCounter = new C4Counter();
        c4Board = new C4Board();
    }

	/**
	 * @brief Checking which player is on next turn
	 * @param  null
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (currentCounter.getPlayer() == 1){
            currentCounter = new C4Counter();
            currentCounter.setPlayer(2);
        } else {
            currentCounter = new C4Counter();
            currentCounter.setPlayer(1);
        }
        // TW Test Code
        if(c4rules.winCondition(c4Board) == 0) {
        	System.out.println("Evaluated: No Winner");
        } else if (c4rules.winCondition(c4Board) == 1) {
        	System.out.println("Evaluated: Player 1 Wins");
        } else if (c4rules.winCondition(c4Board) == 2) {
        	System.out.println("Evaluated: Player 2 Wins");
        } else {
        	System.out.println("Error: No Evaluation");
        }
        
    }
	
//	public void redTurn(){
//		//nextTurn() must return sth. or
//		//implement this togather with nextTurn()
//		//This method is not on abstract class
//	}
//
//	public void yellowTurn(){
//		//nextTurn() must return sth.
//		//or implement this togather with nextTurn()
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
	 * @param  null
	 * @return null
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

	/**
	 * @brief *****CAMERON, I have no idea what's this doing...*******
	 * @see AbstractGame
	 * @param  AbstractGame, int
	 * @return null
	 */
    @Override
    public void gameLoop(AbstractGame game, int delta) {
        currentCounter.dropCounter(delta);
        if (c4Board.placeCounter(currentCounter, this.onScreenCounters)){
            this.nextTurn();
        }

    }

}
