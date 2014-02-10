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

    private Counter currentCounter;
    private HumPlayer player1;
    private HumPlayer player2;

    private List<Counter> onScreenCounters;



    public C4Game() {
        super(true, c4Board);
        this.currentCounter = new Counter(115, 20, 10, 10, 1);
        this.player1 = new HumPlayer(1);
        this.player2 = new HumPlayer(2);
        this.onScreenCounters = new ArrayList<Counter>(10);
    }

    public Counter getCurrentCounter() {
        return currentCounter;
    }


    public List<Counter> getOnScreenCounters() {
        return onScreenCounters;
    }

    @Override
    public void playGame() {
        currentCounter = new Counter(115, 20, 10, 10, 1);
        c4Board = new C4Board();
    }

    @Override
    public void nextTurn() {
        if (currentCounter.getPlayer() == 1){
            currentCounter = new Counter(115, 20, 10, 10, 2);
        } else {
            currentCounter = new Counter(115, 20, 10, 10, 1);;
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
        if (this.getBoard().placeCounter(currentCounter, this.onScreenCounters)){
            this.nextTurn();
        }

    }
	
    private static C4Board c4Board = new C4Board();

}
