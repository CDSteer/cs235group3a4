import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jamie I Davies
 * @date February 27, 2014, Verified and Updated by Design Manager Curtis on 27rd Feb 2014
 * @brief This class creates all the swing objects for the Splash Screen of the game
 */
public class SplashScreen extends JFrame{

    private Main m_splash;
    private static final int JFRAME_WIDTH = 750;
    private static final int JFRAME_HEIGHT = 350;
    private static final int GRID_COLS = 2;

    /**
     * Set splash screen to visible
     */
    public SplashScreen(){
        m_splash = new Main();
        m_splash.setVisible(true);
    }

    /**
     * method to initialise all the GUI Swing elements for the SplashScreen
     */
    public void initGUI() {
        /** 2 cols 1 row JPanel */
        JPanel panel = new JPanel(new GridLayout(1,GRID_COLS));
        m_splash.getContentPane().add(panel);
        ImageIcon c4ButtonIMG = new ImageIcon("res/Connect4Button.png");
        ImageIcon othButtonIMG = new ImageIcon("res/OthelloButton.png");
        JButton c4Button = new JButton("", c4ButtonIMG);
        JButton othButton = new JButton("", othButtonIMG);
         // action listener for the C4 button
        c4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                m_splash.setVisible(false);
                C4Game game = new C4Game();
                game.init();
                m_splash.setVisible(true);             }
        });
         // othello button action listener
            othButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                m_splash.setVisible(false);
                OthGame game = new OthGame();
                game.init();
                m_splash.setVisible(true);   }
        });
        //add buttons to panel
        panel.add(c4Button);
        panel.add(othButton);
        //initialise JFrame
        m_splash.setTitle("A4 Partial Implementation : Group 3 ");
        m_splash.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        m_splash.setLocationRelativeTo(null);
        m_splash.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
