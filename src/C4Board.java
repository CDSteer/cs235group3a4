/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public class C4Board extends AbstractBoard{

    public C4Board(){
        super(COLUMN, ROW);
        this.fillBoard();
    }

    public void fillBoard() {
        int xPos = 100, yPos = 50;
        for (int i=0; i< ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (i != 6){
                    this.getBoard()[i][j] = new Square(xPos, yPos, 30, 30, true);
                } else {
                    this.getBoard()[i][j] = new Square(xPos, yPos, 30, 30, false);
                }

                xPos += 31;
                if (xPos > 409) {
                    xPos = 100;
                    yPos += 31;
                }
            }
        }
    }
    private static final int ROW = 7;
    private static final int COLUMN = 10;
}
