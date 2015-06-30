/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author vani
 */
public class Food
{
    Point position;
    int score;
    int length;
    Image image;
    int paintCount=0;
    Food()
    {
        position=new Point(-1,-1);
        image=Constants.foodImage;
        initialise(1, 1);
    }
    Food(Point pos)
    {
        position=new Point(-1,-1);
        this.position.setLocation(pos);
        score=1;
        length=1;
        image=Constants.foodImage;
    }
    void setPosition(Point p)
    {
        position.setLocation(p);
    }
    void setScore(int sc)
    {
        score=sc;
    }
    /**
     * sets the increase in score and the increase in length of snake
     * that eating this food will cause
     * */
    void initialise(int score,int length)
    {
        this.score=score;
        this.length=length;
    }
    int getScore()
    {
        return score;
    }
    int getLength()
    {
        return length;
    }
    Point getPosition()
    {
        return (Point)position.clone();
    }
    boolean isValid()
    {
        return true;
    }
    public void paint(Graphics g)
    {
        int x=Constants.blockSize*position.x;
        int y=Constants.blockSize*position.y;
        g.drawImage(image, x, y, null);
        /*System.out.println("food paint");
        Color ct=g.getColor();
        g.setColor(Color.magenta);
        g.fillOval(x, y, Constants.blockSize, Constants.blockSize);
        g.setColor(ct);*/
    }
}
