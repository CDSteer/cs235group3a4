/**
 * Created with IntelliJ IDEA.
 *
 *@date    Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 *@see
 *@author  Cameron Steer and Curtis Lewis
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

    public void set_score(int score) {
        this.m_score = score;
    }

    public int isRunning() {
        return m_score;
    }



}