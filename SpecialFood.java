/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author vani
 */
public class SpecialFood extends Food
{
    int time;
    int gap=3;
    SpecialFood(int sc, int time)
    {
        super();
        this.score=sc;
        this.time=time;
        initialise(sc,0);
        if(sc<=0)
           image=Constants.negativeSpecialFoodImage;
        else
           image=Constants.positiveSpecialFoodImage;
    }
    boolean decrementTime()
    {
        time--;
        if(time<0)
            return false;
        return true;
    }
    int getTime()
    {
        return time;
    }
    void setTime(int t)
   {
       time=t;
    }
    boolean isValid()
    {
        if(time<=0)
            return false;
        return true;
    }
    @Override
    public void paint(Graphics g)
    {
        //if(!decrementTime())
          //  return ;
        //System.out.println("specil food paint");
        int x=Constants.blockSize*position.x;
        int y=Constants.blockSize*position.y;
        g.drawImage(image, x, y, null);
        //super.paint(g);
        /*int x=Constants.blockSize*position.x+gap;
        int y=Constants.blockSize*position.y+gap;
        Color ct=g.getColor();
        g.setColor(Color.cyan);
        g.fillOval(x, y, (Constants.blockSize-2*gap)/2, (Constants.blockSize-2*gap)/2);
        g.setColor(ct);*/

    }
}
