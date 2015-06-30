/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.awt.VariableGridLayout;
/**
 *
 * @author user
 */
public class Game extends JFrame implements Runnable,KeyListener
{
    private JPanel gameField=new JPanel(){
            @Override
            public void paint(Graphics g)
            {
               paintGameField(g);
            }
         };
    private SidePanel sidePanel;
    private Timer timer;
    private AI ai;
    private TimerHandle th=new TimerHandle();
    private Thread AIThread=new Thread(ai);
    private ScheduledThreadPoolExecutor stp;
    private Snake snake;
    private boolean isGameOn=true;
    private boolean foodPresent;
    private Vector<Vector<Object>> fieldArray;
    private double score=0;
    private String message="";
    private Food food=null;
    private SpecialFood specialFood=null;
    private Snake.Body body;
    private Snake.Tail tail;
    private ItemGenerator itemGenerator;
    private boolean foodEaten=false;
    private boolean specialFoodEaten=false;
    private boolean gameOver=false;
    private boolean running=false;
    private char fieldRepresentation[][];
    Game()
    {
        super();
        initialiseImages();
        initialiseFrame();
        initialiseObjects();
        repaint();
       // System.out.println("field="+gameField.getBounds());
        //System.out.println("sidepanel="+sidePanel.getBounds());
        new Thread(this).start();
    }
    private void initialiseFrame()
    {
        this.setSize(Constants.frameWidth, Constants.frameHeight);
        this.setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
        this.setTitle("KOKRAFT TZ13-Round 1");
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        this.setLocation((int)((screenSize.getWidth()-Constants.frameWidth)/2),(int)((screenSize.getHeight()-Constants.frameHeight)/2));
        this.setResizable(false);
        //this.setUndecorated(true);
        this.setVisible(true);
        gameField.setSize(Constants.fieldWidth, Constants.fieldHeight);
        gameField.setBackground(Color.cyan);
        sidePanel=new SidePanel();
        sidePanel.setSize(Constants.sidePanelWidth, Constants.sidePanelHeight);
        sidePanel.setBackground(Color.GRAY);
        this.setLayout(null);
        this.add(gameField);
        this.add(sidePanel);
        gameField.setLocation(gameField.getX(),gameField.getY());
        sidePanel.setLocation(gameField.getX()+Constants.fieldWidth, gameField.getY());
        //this.addKeyListener(this);
    }
    private void initialiseObjects()
    {
        fieldArray=new Vector<Vector<Object>>(Constants.number_of_blocks);
        for(int i=0;i<fieldArray.capacity();i++)
        {
            fieldArray.add(new Vector<Object>(Constants.number_of_blocks));
            for(int j=0;j<fieldArray.get(i).capacity();j++)
                fieldArray.get(i).add(null);
        }
        fieldRepresentation=new char[Constants.number_of_blocks][Constants.number_of_blocks];
        for(int i=0;i<fieldRepresentation.length;i++)
            for(int j=0;j<fieldRepresentation.length;j++)
                fieldRepresentation[i][j]='\0';
        ai=new AI(this);
        timer=new Timer();
        stp=new ScheduledThreadPoolExecutor(1);
        snake=new Snake(this);
        this.setBodyPart(snake.head);
        this.setBodyPart(snake.tail);
        body=snake.head;
        tail=(Snake.Tail)snake.tail;
        itemGenerator=new ItemGenerator(this);
        food=itemGenerator.generateFood();
        sidePanel.setFoodInfo(food);
        fieldArray.get(food.position.y).setElementAt(food, food.position.x);
        fieldRepresentation[food.position.y][food.position.x]='f';
    }

    private void initialiseImages()
   {
       try
       {
         Constants.foodImage = ImageIO.read(new File(Constants.foodImagePath));
         Constants.positiveSpecialFoodImage=ImageIO.read(new File(Constants.positiveSpecialFoodImagePath));
         Constants.negativeSpecialFoodImage=ImageIO.read(new File(Constants.negativeSpecialFoodImagePath));
         Constants.fieldBackgroundImage=ImageIO.read(new File(Constants.fieldBackgroundImagePath));
       }
       catch(IOException e)
       {
          System.out.println(e);
          System.out.println("error in loading images");
       }
    }
    void setBodyPart(Snake.Body body)
    {
        if(body==null)
            return;
        Point pos=body.getPosition();
        if(fieldArray.get(pos.y).get(pos.x)!=null)
        {
            System.out.println("Trying to override the normal game environment..");
            return;
        }
        fieldArray.get(pos.y).setElementAt(body, pos.x);
        if(body instanceof Snake.Tail)
            fieldRepresentation[pos.y][pos.x]='t';
        else if (body instanceof Snake.Head)
            fieldRepresentation[pos.y][pos.x]='h';
        else
            fieldRepresentation[pos.y][pos.x]='b';
    }
    public void run()
    {
       if(!running)
          running=true;
       else
       {
          System.out.println("Game already running");
          return;
       }
        while(isGameOn)
        {
            if(!isFoodPresent())
                generateFood();
            AIPlay();//##########################################################3
            snake.move();
            updateField();
            repaint();
            tail.setPosition(snake.getTailPosition());
            fieldArray.get(tail.position.y).setElementAt(tail, tail.position.x);
            fieldRepresentation[tail.position.y][tail.position.x]='t';
            try {
                Thread.sleep(Constants.gameFrameRate);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       handleGameOver();
    }
    private void updateField()
    {
       if(foodEaten)
       {
          foodEaten=false;
          score+=food.getScore();
          fieldArray.get(food.position.y).setElementAt(null, food.position.x);
          fieldRepresentation[food.position.y][food.position.x]='\0';
          food=itemGenerator.generateFood();
          fieldArray.get(food.position.y).setElementAt(food, food.position.x);
          fieldRepresentation[food.position.y][food.position.x]='f';
          sidePanel.setFoodInfo(food);
       }
       else if(specialFoodEaten)
       {
          specialFoodEaten=false;
          score+=specialFood.getScore();
          fieldArray.get(specialFood.position.y).setElementAt(null, specialFood.position.x);
          fieldRepresentation[specialFood.position.y][specialFood.position.x]='\0';
          sidePanel.setSpecialFoodInfo(null);
          specialFood=null;
       }
       if(specialFood==null)
       {
          specialFood = itemGenerator.generateSpecialFood();
          if(specialFood!=null)
          {
             fieldArray.get(specialFood.position.y).setElementAt(specialFood, specialFood.position.x);
             fieldRepresentation[specialFood.position.y][specialFood.position.x]='s';
             sidePanel.setSpecialFoodInfo(specialFood);
          }
       }
       else
       {
          if(!specialFood.decrementTime())
          {
             fieldArray.get(specialFood.position.y).setElementAt(null, specialFood.position.x);
             fieldRepresentation[specialFood.position.y][specialFood.position.x]='\0';
             specialFood=null;
             sidePanel.setSpecialFoodInfo(null);
          }
          else
            sidePanel.updateSpFoodTime(specialFood.time);
       }
        if(gameOver)
           isGameOn=false;
        sidePanel.setScore(score);
        if(message!=null)
            sidePanel.setMessage(message);
    }

    private void handleGameOver()
    {
        message="OOPS!! Snake Dead!!";
        sidePanel.setMessage(message);

    }

    @Override
    public void repaint()
    {
        //super.paint(g);
        sidePanel.repaint();
        gameField.repaint();

    }
    void paintGameField(Graphics g)
   {
       Image image=gameField.createImage(gameField.getWidth(), gameField.getHeight());
        Graphics offscreen=image.getGraphics();
        offscreen.setColor(gameField.getBackground());
        offscreen.fillRect(0, 0, gameField.getWidth(), gameField.getHeight());
        offscreen.drawImage(Constants.fieldBackgroundImage, 0, 0, gameField.getWidth(),gameField.getHeight(),null);
        //paintGrid(offscreen);
        if(snake!=null)
            snake.paint(offscreen);
        if(food!=null)
            food.paint(offscreen);
        if(specialFood!=null)
            specialFood.paint(offscreen);
        g.drawImage(image, 0, 0, null);
    }
    private void paintGrid(Graphics g)
    {
        Color c=g.getColor();
        g.setColor(Color.black);
        for(int i=Constants.blockSize;i<=Constants.fieldWidth;i+=Constants.blockSize)
            g.drawLine(i, 0, i, Constants.fieldHeight);
        for(int i=Constants.blockSize;i<=Constants.fieldHeight;i+=Constants.blockSize)
            g.drawLine(0, i, Constants.fieldWidth, i);
    }
    //calls the AI for making a move
    // and registers a thread for stopping the AI thread if it does not complete its execution within specified time..
    private void AIPlay()
    {
            timer=new Timer();

        AIThread=new Thread(ai);
        timer.schedule(new TimerHandle(), 10);
        ThreadMXBean tm=ManagementFactory.getThreadMXBean();
            //ScheduledFuture<?> schedule = stp.schedule(this, 4, TimeUnit.MILLISECONDS);
        long start=System.nanoTime();

        AIThread.start();
        try
        {
            AIThread.join();
        }
        catch (InterruptedException ex) {}
        long end=System.nanoTime();
        //System.out.println("duration="+(end-start)/1000000);
        timer.cancel();
        //schedule.cancel(true);
    }
    public static void main(String sd[])
    {
        new Game();
    }

    private boolean isFoodPresent() {
        return false;
    }

    private void generateFood() {

    }

     private Vector<Vector<Object>> getFieldArray()
    {
        return fieldArray;
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        //System.out.println("key pressed");
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_LEFT:this.moveLeft();
                                    break;
            case KeyEvent.VK_RIGHT:this.moveRight();
                                    break;
            case KeyEvent.VK_UP:this.moveStraight();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
    private class TimerHandle extends TimerTask
    {

        @Override
        public void run()
        {
            AIThread.stop();
        }
    }

    boolean checkCollisions(Point pos)
    {
        String s;
        boolean flag=checkWallCollision(pos);
        if(flag)
        {
            gameOver = true;
            message="Collision With Wall";
            return true;
        }
        flag=checkBodyCollision(pos);
        if(flag)
        {
            gameOver=true;
            message="Collision with itself";
            return true;
        }
        flag=checkFoodCollision(pos);
        if(flag)
        {
            // modify later..............................................
            if(food.score>0)
            {
                fieldArray.get(pos.y).setElementAt(body, pos.x);
                fieldRepresentation[pos.y][pos.x]='b';
                //return true;
            }
            return false;
        }
        fieldArray.get(pos.y).setElementAt(body, pos.x);
        fieldRepresentation[pos.y][pos.x]='b';
        fieldArray.get(tail.position.y).setElementAt(null, tail.position.x);
        fieldRepresentation[tail.position.y][tail.position.x]='\0';
        //if(message!=null)
          //  System.out.println(message);
        message=null;
        return false;
    }
    boolean checkWallCollision(Point pos)
    {
        if(pos.x<0 || pos.y<0)
            return true;
        if(pos.x==Constants.number_of_blocks || pos.y==Constants.number_of_blocks)
            return true;
        return false;
    }
    boolean checkBodyCollision(Point pos)
    {
        if(fieldArray.get(pos.y).get(pos.x) instanceof Snake.Body &&
                !(fieldArray.get(pos.y).get(pos.x) instanceof Snake.Tail))
            return true;
        return false;
    }
    boolean checkFoodCollision(Point pos)
    {
        if(fieldArray.get(pos.y).get(pos.x) instanceof SpecialFood)
        {
            if(food.score<0)
                message="OOps!! You ate a poisonous food";
            else
                message="Yippee!! Found favourite food";
            specialFoodEaten=true;
            //System.out.println("special food collision");
            //score+=food.score;
            //fieldArray.get(pos.y).setElementAt(null, pos.x);
            //itemGenerator.notifySpecialFoodEaten();
            return true;
        }
        else if(fieldArray.get(pos.y).get(pos.x) instanceof Food)
        {
            message="Food eaten";
            //score+=food.score;
            snake.notifyIncreaseLength(food.getLength());
            //System.out.println("notifting snake : "+food.getLength());
            foodEaten=true;
            //fieldArray.get(pos.y).setElementAt(null, pos.x);
            //food=itemGenerator.generateFood();
            //fieldArray.get(food.position.y).setElementAt(food, food.position.x);

            return true;
        }
        return false;
    }
//-----------------------------------------------------------------------------------------------
    // Interface methods for the AI class.
    // Only these methods can be used inside the Ai class

    /**
     * Get the entire playing field of the snake represented
     * as a 2-D character matrix where the various
     * objects are represented as follow:
     * <ul>
     * <li>blank position->'\0'</li>
     * <li>snake body -> 'b' </li>
     * <li>food       -> 'f' </li>
     * <li>special food-> 's' </li>
     * </ul>
     */
    public char[][] getField()
    {
        return fieldRepresentation;
    }

    /**
     * tell the snake to turn to its left
     */
    public void moveLeft()
    {
        //System.out.println("move left()");
        snake.setPathLeft();
    }
    /**
     * tell the snake to turn to its right
     */
    public void moveRight()
    {
        //System.out.println("move right()");
        snake.setPathRight();
    }

    /**
     * tell the snake to move straight
     * </br>(kept just for completeness)
     */
    public void moveStraight()
    {
        //System.out.println("move straight()");
        snake.setPathStraight();
    }
    /**
     * returns the current direction in which the snake is moving
     * as a <code>Snake.Velocity </code><code>enum</code> object
     * @return
     */
    public Snake.Velocity getsnakeDirection()
    {
        return snake.velocity;
    }
    /**
     * Return whether the field position as specified
     * by  pos is empty or occupied by some object
     * <p>Essentially it returns true if the field
     * representation as returned by <code>getField()</code>
     * has '\0' at Position pos.
     */
    public boolean isFieldPositionEmpty(Point pos)
    {
        if(fieldArray.get(pos.y).get(pos.x)==null)
            return true;
        return false;
    }
    /**
     * returns the location of the food on the field
     * @return
     */
    public Point getFoodLocation()
    {
        if(food==null)
            return null;
        return (Point)food.getPosition().clone();
    }
    /**
     * returns the location of the special food on the field
     * <p>If there is no special food present,
     * then it returns null
     * @return
     */
    public Point getSpecialFoodLocation()
    {
        if(specialFood==null)
            return null;
        return (Point)specialFood.getPosition().clone();
    }
    /**
     * returns the number of points that your snake
     * will gain or lose on eating the special food
     *<p>
     * The return points are negative if they increase the game score
     * else if they increase the game score then they are positive
     * @return
     */
    public Integer getSpecialFoodPoints()
    {
        if(specialFood==null)
            return null;
        return specialFood.getScore();
    }
    /**
     * returns the remaining time for which the special food will remain on the
     * field( after this amount of time has elapsed, the food disappears)
     * If there is no special food present the method returns -1.
     * @return
     */
    public int getSpecialFoodRemainingTime()
    {
        if(specialFood==null)
            return -1;
        return specialFood.getTime();
    }
    public Point getSnakeHeadLocation()
    {
        return snake.getHeadPostion();
    }
    public Point getSnakeTailLocation()
    {
        return snake.getTailPosition();
    }
}
