import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer, Martin
 *         - created 04/02/2014
 *         - updated 06/02/2014
 * @version *1.1*
 */
public class OthGame extends AbstractGame {


    public OthGame() {
        super(true, othBoard);
    }

    @Override
    public Counter getCurrentCounter() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Counter> getOnScreenCounters() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void gameLoop(AbstractGame game, int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playGame() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void nextTurn() {
        //To change body of implemented methods use File | Settings | File Templates.
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
	
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    //remove this later
    private static OthBoard othBoard = new OthBoard();
}
