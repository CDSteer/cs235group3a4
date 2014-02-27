import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @file SplashScreen.java
 * @author Jamie I Davies
 * @date February 27, 2014, Verified and Updated by Design Manager Curtis on 27rd Feb 2014
 * @see
 * @brief This class creates all the swing objects for the Splash Screen of the game
 */
public class SplashScreen extends JFrame{

    private Main splash;

    public SplashScreen(){
        splash = new Main();
        splash.setVisible(true);
    }

    public void initGUI() {
        /** 2 cols 1 row JPanel */
        JPanel panel = new JPanel(new GridLayout(1,2));
        splash.getContentPane().add(panel);

        /** initialise buttons, set fonts and tooltips */
        JButton c4Button = new JButton("Play Connect 4!");
        JButton othButton = new JButton("Play Othello!");
        c4Button.setFont(new Font("Arial", Font.BOLD, ARIAL_FONT_SIZE));
        othButton.setFont(new Font("Arial", Font.BOLD, ARIAL_FONT_SIZE));
        c4Button.setToolTipText("Click Me to Play Connect 4!");
        othButton.setToolTipText("Click Me to Play Othello!");

        /** c4 button action listener */
        c4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                splash.setVisible(false);
                C4Game game = new C4Game();
                game.init();
                splash.setVisible(true);
            }
        });

        /** othello button action listener */
        othButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                splash.setVisible(false);
                OthGame game = new OthGame();
                game.init();
                splash.setVisible(true);
            }
        });

        /** add buttons to the JPanel */
        panel.add(c4Button);
        panel.add(othButton);

        /** initialise JFrame */
        splash.setTitle("A4 Partial Implementation : Group 3 ");
        splash.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        splash.setLocationRelativeTo(null);
        splash.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static final int ARIAL_FONT_SIZE = 34;
    private static final int JFRAME_WIDTH = 1024;
    private static final int JFRAME_HEIGHT = 300;

}
