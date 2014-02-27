import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @file C4Game.java
 *
 * @brief This file is the main panel, allocating information and data into
 *        every inherit classes, maintaining game process.
 *
 * @author Cameron Steer, Martin Hui, Jamie I Davies
 * @date February 1, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @version *1.2*
 * @since February 20, 2014
 */
public class C4Game extends AbstractGame{

    private C4Counter currentCounter;							//Store counter information
    private HumPlayer player1;									//Player1 information
    private HumPlayer player2;									//Player2 information
    private List<AbstractCounter> onScreenCounters;				//Abstract Counter information
    private int m_Turn = 1;
    C4Input m_GameInput;
    C4Display m_Display;

    // TW Test Code
    private C4Rules c4rules;
    private C4Board m_Board;
    
    private int currentCounters1 = 0;
    private int currentCounters2 = 0;

	/**
	* @brief Collecting and storing every data from graphic, rules, player.
	* @see C4Board
	* @see HumPlayer
	* @see C4Counter
	* @return void
	*/
    public C4Game() {
        super(true);
        this.m_Display = new C4Display();
        this.m_GameInput = new C4Input();
        this.currentCounter = new C4Counter();
        this.player1 = new HumPlayer(PLAYER1);
        this.player2 = new HumPlayer(PLAYER2);
        this.onScreenCounters = new ArrayList<AbstractCounter>(ON_SCREEN_COUNTERS_ELEMENTS);
        this.m_Board = new C4Board();
        // TW Test Code
        c4rules = new C4Rules();
        
    }
	/**
	 * @brief Receive Board information from C4Board Class
	 * @see C4Board
	 * @return C4Board
	 */
    public C4Board getBoard() {
        return m_Board;
    }

    @Override
    public int getTurn() {
        return m_Turn;  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    public void calcCounters() {
    	// no implementation
    }
    
    public int getCounters1() {
    	return currentCounters1;
    }
    
    public int getCounters2() {
    	return currentCounters2;
    }

    /**
	 * @brief Set C4Board
	 * @see C4Board
	 * @param  c4Board
	 * @return null
	 */
    public void setBoard(C4Board c4Board) {
        this.m_Board = c4Board;
    }

	/**
	 * @brief Receive Current Counter information from Counter Class
	 * @see C4Counter
	 * @return AbstractCounter
	 */
    public AbstractCounter getCurrentCounter() {
        return currentCounter;
    }

	/**
	 * @brief Receive on screen Counter information from AbstractCounter Class
	 * @see C4Counter
	 * @return List<AbstractCounter>
	 */
    public List<AbstractCounter> getOnScreenCounters() {
        return onScreenCounters;
    }

	/**
	 * @brief Game begin, create Counter and Board
	 * @see C4Board
	 * @see C4Counter
	 * @return null
	 */
    @Override
    public void playGame() {
        m_Display = new C4Display();
        m_GameInput = new C4Input();
        currentCounter = new C4Counter();
        player1 = new HumPlayer(PLAYER1);
        player2 = new HumPlayer(PLAYER2);
        onScreenCounters = new ArrayList<AbstractCounter>(ON_SCREEN_COUNTERS_ELEMENTS);
        m_Board = new C4Board();
        // TW Test Code
        c4rules = new C4Rules();
    }

	/**
	 * @brief Checking which player is on next turn
	 * @return null
	 */
    @Override
    public void nextTurn() {
        if (currentCounter.getPlayer() == PLAYER1){
            currentCounter = new C4Counter();
            currentCounter.setPlayer(PLAYER2);
            m_Turn = 2;
        } else {
            currentCounter = new C4Counter();
            currentCounter.setPlayer(PLAYER1);
            m_Turn = 1;
        }

    }
    /**
     * if statement to check the win state of the game
     * this will then display a dialog
     * @retun void
     */
    public void winCheck() {
        if(c4rules.winCondition(m_Board) == 0) {
            System.out.println("Evaluated: No Winner");
        } else if (c4rules.winCondition(m_Board) == PLAYER1) {
            //display player wins alert
            option = JOptionPane.showConfirmDialog(null, "Player 1 Wins! Game will now end!", "Play Again",  JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION){
                setRunning(false);
            } else if (option == JOptionPane.YES_OPTION){
                playGame();
            }
        } else if (c4rules.winCondition(m_Board) == PLAYER2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            //display player wins alert
            option = JOptionPane.showConfirmDialog(null, "Player 2 Wins! Game will now end!", "Play Again",  JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION){
                setRunning(false);
            } else if (option == JOptionPane.YES_OPTION){
                playGame();
            }
        } else {
            System.out.println("Error: No Evaluation");
        }
    }

    /** initC4 method for calling C4 game board */
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
	 * @brief Game End
	 * @return null
	 */
    @Override
    public void gameOver() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

	/**
	 * @brief *****CAMERON, I have no idea what's this doing...*******
	 * @see AbstractGame
	 * @return void
	 */
    public void gameLoop() {

        while (this.isRunning()) {
            m_GameInput.inputLoop(currentCounter);
            if (m_Board.placeCounter(currentCounter, this.onScreenCounters)){
                this.nextTurn();
            }
            winCheck();
            m_Display.render(this);
            currentCounter.dropCounter(getTime().getDelta());
            Display.update();
            Display.sync(this.getTime().getFrameRate());
            if (Display.isCloseRequested()) {
                this.setRunning(false);
            }
        }
    }

    private int option;
    private static final int PLAYER2 = 2;
    private static final int PLAYER1 = 1;
    private static final int ON_SCREEN_COUNTERS_ELEMENTS = 10;
}
