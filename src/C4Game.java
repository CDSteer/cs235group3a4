import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer, Martin
 *         - created 01/02/2014
 *		   - updated 06/02/2014
 * @version *1.1*
 */
public class C4Game extends AbstractGame{

    private C4Counter currentCounter;
    private HumPlayer player1;
    private HumPlayer player2;

    private List<AbstractCounter> onScreenCounters;
    
    // TW Test Code
    private C4Rules c4rules;

    private C4Board c4Board;

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

    public C4Board getC4Board() {
        return c4Board;
    }

    public void setC4Board(C4Board c4Board) {
        this.c4Board = c4Board;
    }

    public AbstractCounter getCurrentCounter() {
        return currentCounter;
    }


    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;
    }

    @Override
    public void playGame() {
        currentCounter = new C4Counter();
        c4Board = new C4Board();
    }

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
	
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void gameLoop(AbstractGame game, int delta) {
        currentCounter.dropCounter(delta);
        if (c4Board.placeCounter(currentCounter, this.onScreenCounters)){
            this.nextTurn();
        }

    }

}
