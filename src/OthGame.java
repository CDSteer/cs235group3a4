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
    private List<AbstractCounter> onScreenCounters;				//Abstract Counter information
    
    // TW Test Code
    //private OthRules othRules;                                //Waiting for othrules to implement
    private Othoard othBoard;


    public OthGame() {
        super(true);
		this.currentCounter = new OthCounter();
        this.player1 = new HumPlayer(1);
        this.player2 = new HumPlayer(2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(10);
        this.othBoard = new OthBoard();
        // TW Test Code
       // othrules = new OthRules();							//Waiting for othrules to implement
    }

	/**
	 * Recieve Counter information from Counter Class
	 * @param  null
	 * @return AbstractCounter
	 */
    @Override
    public AbstractCounter getCurrentCounter() {
        return currentCounter;  //Is this ready yet?
    }

	/**
	 * Recieve on screen Counter information from AbstractCounter Class
	 * @param  null
	 * @return List<AbstractCounter>
	 */
    @Override
    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;  //Is this ready yet?
    }

	/**
	 * *****CAMERON, I have no idea what's this doing...*******
	 * @param  AbstractGame, int
	 * @return null
	 */
    @Override
    public void gameLoop(AbstractGame game, int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
	
	/**
	 * Game begin, Create Counter and Board
	 * @param  null
	 * @return null
	 */
    @Override
    public void playGame() {
        currentCounter = new OthCounter();
        othBoard = new OthBoard();
    }

	/**
	 * Checking which player is on next turn
	 * @param  null
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (currentCounter.getPlayer() == 1){
            currentCounter = new OthCounter();
            currentCounter.setPlayer(2);
        } else {
            currentCounter = new OthCounter();
            currentCounter.setPlayer(1);
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
	 * @param  AbstractGame, int
	 * @return null
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    //remove this later
    private static OthBoard othBoard = new OthBoard();
}
