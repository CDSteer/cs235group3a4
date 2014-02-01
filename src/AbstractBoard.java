/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 01/02/2014
 * @version *.*
 */
public abstract class AbstractBoard {

    private int m_Column;
    private int m_Row;

    public AbstractBoard(int m_Column, int m_Row){
        this.m_Column = m_Column;
        this.m_Row = m_Row;
    }

    public int getM_Column() {
        return m_Column;
    }

    public void setM_Column(int m_Column) {
        this.m_Column = m_Column;
    }

    public int getM_Row() {
        return m_Row;
    }

    public void setM_Row(int m_Row) {
        this.m_Row = m_Row;
    }
}
