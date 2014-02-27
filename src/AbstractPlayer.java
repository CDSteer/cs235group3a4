/**
 *@author Curtis Lewis
 *@date Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 *@brief contains private member variables for name and scores
 *@details as well as getters and setters for these variables.
 *@version *1.0.1*
 */

public abstract class AbstractPlayer {

    private int m_name;
    private int m_score;

    /**
     * 
     * @param name
     */
    public AbstractPlayer(int name){
        this.m_name = name;
    }

    /**
     * get the name of current player
     * @return m_name
     */
    public int getName() {
        return m_name;
    }

    /**
     * sets the player name
     * @param name
     */
    public void setName(int name) {
        this.m_name = m_name;
    }

    /**
     * gets the current score
     * @return m_score
     */
    public int getScore() {
        return m_score;
    }

    /**
     * sets the score
     * @param score
     */
    public void setScore(int score) {
        this.m_score = m_score;
    }

    /**
     * 
     * @return m_score
     */
    public int isRunning() {
        return m_score;
    }
}