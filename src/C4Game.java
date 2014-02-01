import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class C4Game implements Game{

    private Counter currentCounter;
    private HumPlayer player1;
    private HumPlayer player2;
    private C4Board c4Board;
    List<Counter> onScreenCounters;

    public C4Game() {
        this.currentCounter = new Counter(115, 20, 10, 10, 1);
        this.c4Board = new C4Board();
        this.player1 = new HumPlayer(1);
        this.player2 = new HumPlayer(2);
        this.onScreenCounters = new ArrayList<Counter>(10);
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

    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Counter getCurrentCounter() {
        return currentCounter;
    }

    public void setCurrentCounter(Counter currentCounter) {
        this.currentCounter = currentCounter;
    }

    public HumPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(HumPlayer player1) {
        this.player1 = player1;
    }

    public HumPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(HumPlayer player2) {
        this.player2 = player2;
    }

    public C4Board getC4Board() {
        return c4Board;
    }

    public void setC4Board(C4Board c4Board) {
        this.c4Board = c4Board;
    }

    public List<Counter> getOnScreenCounters() {
        return onScreenCounters;
    }

    public void setOnScreenCounters(List<Counter> onScreenCounters) {
        this.onScreenCounters = onScreenCounters;
    }
}
