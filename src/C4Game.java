import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/** *
 * @author Cameron Steer, Martin Hui, Jamie I Davies
 * @date February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @version *1.2*
 * @since February 20, 2014
 * @brief C4Game method which creates the game
 * @details allocates information and data into every inherit classes, maintaining game process
 */
public class C4Game extends AbstractGame{

    private C4Counter m_currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    private List<AbstractCounter> m_onScreenCounters;				//Abstract Counter information
    private int m_Turn = 1;
    C4Input m_GameInput;
    C4Display m_Display;

    private C4Rules m_c4rules;
    private C4Board m_Board;
    
    private int m_currentCounters1 = 0;
    private int m_currentCounters2 = 0;

    private int m_option;
    private static final int PLAYER2 = 2;
    private static final int PLAYER1 = 1;
    private static final int ON_SCREEN_COUNTERS_ELEMENTS = 10;
    private static final int SLEEP_TIME = 500;

	/**
	* Collecting and storing every data from graphic, rules, player.
	* @see C4Board
	* @see HumPlayer
	* @see C4Counter
	* @return void
	*/
    public C4Game() {

        super(true);
        this.m_Display = new C4Display();
        this.m_GameInput = new C4Input();
        this.m_currentCounter = new C4Counter();
        this.player1 = new HumPlayer(PLAYER1);
        this.player2 = new HumPlayer(PLAYER2);
        this.m_onScreenCounters = new ArrayList<AbstractCounter>(ON_SCREEN_COUNTERS_ELEMENTS);
        this.m_Board = new C4Board();
        // TW Test Code
        m_c4rules = new C4Rules();
        
    }
	/**
	 * @Receive Board information from C4Board Class
	 * @see C4Board
	 * @return C4Board
	 */
    public C4Board getBoard() {
        return m_Board;
    }

    /**
     * gets the turn
     * @return m_Turn
     */
    @Override
    public int getTurn() {
        return m_Turn;
    }
    
    public void calcCounters() {
    	// no implementation
    }
    
    /**
     * 
     * @return currentCounters1
     */
    public int getCounters1() {
    	return m_currentCounters1;
    }
    
    /**
     * 
     * @return currentCounters2
     */
    public int getCounters2() {
    	return m_currentCounters2;
    }

    /**
	 * Set C4Board
	 * @see C4Board
	 * @param  c4Board
	 * @return null
	 */
    public void setBoard(C4Board c4Board) {
        this.m_Board = c4Board;
    }

	/**
	 * Receive Current Counter information from Counter Class
	 * @see C4Counter
	 * @return AbstractCounter
	 */
    public AbstractCounter getCurrentCounter() {
        return m_currentCounter;
    }

	/**
	 * Receive on screen Counter information from AbstractCounter Class
	 * @see C4Counter
	 * @return List<AbstractCounter>
	 */
    public List<AbstractCounter> getOnScreenCounters() {
        return m_onScreenCounters;
    }

	/**
	 * Game begin, create Counter and Board
	 * @see C4Board
	 * @see C4Counter
	 * @return null
	 */
    @Override
    public void playGame() {
        m_Display = new C4Display();
        m_GameInput = new C4Input();
        m_currentCounter = new C4Counter();
        player1 = new HumPlayer(PLAYER1);
        player2 = new HumPlayer(PLAYER2);
        m_onScreenCounters = new ArrayList<AbstractCounter>(ON_SCREEN_COUNTERS_ELEMENTS);
        m_Board = new C4Board();
        // TW Test Code
        m_c4rules = new C4Rules();
    }

	/**
	 * Checking which player is on next turn
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (m_currentCounter.getPlayer() == PLAYER1){
            m_currentCounter = new C4Counter();
            m_currentCounter.setPlayer(PLAYER2);
            m_Turn = PLAYER2;
        } else {
            m_currentCounter = new C4Counter();
            m_currentCounter.setPlayer(PLAYER1);
            m_Turn = PLAYER1;
        }
        winCheck();

    }
    /**
     * if statement to check the win state of the game this will then display a dialog
     * @return void
     */
    public void winCheck() {
        if(m_c4rules.winCondition(m_Board) == 0) {

        } else if (m_c4rules.winCondition(m_Board) == PLAYER1) {
            //display player wins alert
            m_option = JOptionPane.showConfirmDialog(null, "Player 1 Wins! Please click 'Yes' to play again or 'No' to close.", "Would you like to play again?",  JOptionPane.YES_NO_OPTION);
            if (m_option == JOptionPane.NO_OPTION){
                setRunning(false);
            } else if (m_option == JOptionPane.YES_OPTION){
                playGame();
            }
        } else if (m_c4rules.winCondition(m_Board) == PLAYER2) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //display player wins alert
            m_option = JOptionPane.showConfirmDialog(null, "Player 2 Wins! Please click 'Yes' to play again 'No' to close.", "Would you like to play again?",  JOptionPane.YES_NO_OPTION);
            if (m_option == JOptionPane.NO_OPTION){
                setRunning(false);
            } else if (m_option == JOptionPane.YES_OPTION){
                playGame();
            }
        } else {
            System.out.println("Error: No Evaluation");
        }
    }
    
    /**
     * calls the C4 game board
     */
    public void init() {
        new C4Game();
        this.getTime().setUpTimer();
        m_Display.setUpDisplay();
        m_Display.setUpOpenGL();
        m_Display.loadTextures();
        C4Square.setTexture();
        gameLoop();
        Display.destroy();
    }
	
	/**
	 * Game End
	 */
    @Override
    public void gameOver() {

    }

	/**
	 * checks status of the turns and render the display. also closes the game safely if window closed
	 * @see AbstractGame
	 * @return void
	 */
    public void gameLoop() {

        while (this.isRunning()) {
            m_GameInput.inputLoop(m_currentCounter);
            if (m_Board.placeCounter(m_currentCounter, this.m_onScreenCounters)){
                this.nextTurn();
            }
            m_Display.render(this);
            m_currentCounter.dropCounter(getTime().getDelta());
            Display.update();
            Display.sync(this.getTime().getFrameRate());
            if (Display.isCloseRequested()) {
                this.setRunning(false);
            }
        }
    }


}
