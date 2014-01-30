/**
 * Created with IntelliJ IDEA.
 *
 * @author cdsteer
 *         - created 28/01/2014
 * @version *.*
 */

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;


public class Main {

    private static Mouse mouse;

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static boolean isRunning = true;
    private static long lastFrame;

    private static Counter currentCounter;
    private static final List<Counter> onScreenCounters = new ArrayList<Counter>(10);

    private static Square board[][] = new Square[7][10];
    private static final int ROW = 7;
    private static final int COLUMN = 10;



    public static void main(String args[]) throws InterruptedException{

        Thread input = new Thread(new Runnable() {
            public void run() {
                 while (isRunning){
                    track();
                    drop();
                 }
            }
        });

        setUpDisplay();
        setUpOpenGL();
        setUpEntities();
        setUpTimer();
        input.start();



        while (isRunning) {
            boundCounter();
            render();
            dropCounter(getDelta());
            Display.update();
            Display.sync(60);
            if (Display.isCloseRequested()) {
                isRunning = false;
            }
        }
        Display.destroy();
        System.exit(0);

    }

    public static void setUpDisplay(){
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Connect Four");
            Display.create();
        } catch (LWJGLException e) {
            Display.destroy();
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void setUpOpenGL(){
        // Initialization code OpenGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    synchronized public static void render(){
        glClear(GL_COLOR_BUFFER_BIT);
        currentCounter.draw();


        for (int i=0; i< ROW; i++) {
            for (int j=0; j< COLUMN; j++) {
                board[i][j].draw();
            }
        }

        for (Counter counters : onScreenCounters) {
            counters.draw();
        }
    }

   public static void setUpEntities(){
       currentCounter = new Counter(300, 20, 20, 20, 1);
       int xPos = 100, yPos = 50;
       for (int i=0; i< ROW; i++) {
           for (int j=0; j<COLUMN; j++) {
               System.out.println(i);
               if (i != 6){
                  board[i][j] = new Square(xPos, yPos, 30, 30, true);
               } else {
                  board[i][j] = new Square(xPos, yPos, 30, 30, false);
               }

               xPos += 31;
               if (xPos > 409) {
                   xPos = 100;
                   yPos += 31;
               }
           }
       }
       for (int i=0; i<ROW; i++) {
           for (int j=0; j< COLUMN; j++) {
               System.out.println(i + ", " + j + ": " + board[i][j].getX() + ", " + board[i][j].getY()+ ", " + board[i][j].isUsed());
           }
       }

    }

    synchronized public static void dropCounter(int delta){
        currentCounter.update(delta);
    }

    synchronized public static void boundCounter(){

        //bottom
        if (currentCounter.getY()+20 > HEIGHT) {
            currentCounter.setDY(0);
            onScreenCounters.add(currentCounter);
        }
        /*
        for (int j = 0; j < COLUMN; j++) {
            if (currentCounter.intersects(board[0][j])){
                currentCounter.center(board[0][j].getX(), board[0][j].getY(), board[0][j].getHeight(), board[0][j].getWidth());
            }
        */


        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                if (currentCounter.intersects(board[i][j]) && !board[i][j].isUsed()) {

                   currentCounter.setDY(0);
                   currentCounter.center(board[i][j].getX(), board[i][j].getY(), board[i][j].getHeight(), board[i][j].getWidth());
                   board[i][j].setUsed(true);
                   if (i == 0){
                       board[0][j].setUsed(false);
                   } else {
                       board[i-1][j].setUsed(false);
                   }
                   onScreenCounters.add(currentCounter);
                   if (currentCounter.getPlayer() == 1){
                        currentCounter = new Counter(300, 20, 20, 20, 2);;
                   } else {
                        currentCounter = new Counter(300, 20, 20, 20, 1);;
                   }

                }
            }
        }

    }

    synchronized public static void drop(){
        if(mouse.isButtonDown(0) && currentCounter.getX() > 100){
            currentCounter.setDY(.1);
        }
    }

    synchronized private static void track() {
        if (currentCounter.getDY() < .1) {
            int x = mouse.getX();
            currentCounter.setX(x);
        }
    }

    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
    public static void setUpTimer(){
        lastFrame = getTime();
    }
}
