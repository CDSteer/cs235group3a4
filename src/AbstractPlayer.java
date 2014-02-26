/**
 *@date    Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 *@see
 *@author  Curtis Lewis
 *@brief   This class is AbstractPlayer which contain private member variables for name and score
 *         as well as getters and setters for these variables.
 *@version *1.0.1*
 */
public abstract class AbstractPlayer {

    private int m_name;
    private int m_score;

    public AbstractPlayer(int name){
        this.m_name = name;
    }

    public int getName() {
        return m_name;
    }

    public void setName(int name) {
        this.m_name = m_name;
    }

    public int getScore() {
        return m_score;
    }

    public void setScore(int score) {
        this.m_score = m_score;
    }

    public int isRunning() {
        return m_score;
    }
}