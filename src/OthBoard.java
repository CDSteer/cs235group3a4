/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 04/02/2014
 * @version *.*
 */
public class OthBoard extends AbstractBoard{

    public OthBoard(){
        super(COLUMN, ROW);
        this.fillBoard();
    }

    @Override
    public void fillBoard() {
        int xPos = 100, yPos = 50;
        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {

                this.getBoard()[i][j] = new Square(xPos, yPos, 30, 30, true);

                xPos += 31;
                if (xPos > 317) {
                    xPos = 100;
                    yPos += 31;
                }
            }
        }
    }

    private static final int ROW = 8;
    private static final int COLUMN = 8;
}
