/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author vani
 */
public class ItemGenerator
{
    Game game;
    Point pos,tempP;
    Food food;
    SpecialFood spFood;
    int count;
    int probability=60;//prob with which a positive score special food is generated..
    int maxSc=5;
    int maxTime=40;
    int minTime=10;
    ItemGenerator(Game g)
    {
        game=g;
        pos=new Point(-1,-1);
        tempP=new Point(-1,-1);
        food=new Food();
        spFood=new SpecialFood(0, 0);
        count=0;
    }
    public Food generateFood()
    {
        count++;
        //Vector<Vector<Object>> fieldArray = game.getFieldArray();
        Random r=new Random(System.currentTimeMillis());
        do
        {
            tempP.setLocation(r.nextInt(Constants.number_of_blocks), r.nextInt(Constants.number_of_blocks));
        }while(!game.isFieldPositionEmpty(tempP));
        //while(fieldArray.get(tempP.y).get(tempP.x)!=null);
        pos.setLocation(tempP);
        //food= new Food(tempP);
        food.setPosition(tempP);
        return food;
    }
    public SpecialFood generateSpecialFood()
    {
        if(count==4)
        {
            count=0;
        }
        else return null;
       //System.out.println("count="+count);
        //Vector<Vector<Object>> fieldArray = game.getFieldArray();
        Random r=new Random(System.currentTimeMillis());
        do
        {
            tempP.setLocation(r.nextInt(Constants.number_of_blocks), r.nextInt(Constants.number_of_blocks));
        }while(!game.isFieldPositionEmpty(tempP));
        //while(fieldArray.get(tempP.y).get(tempP.x)!=null);
        pos.setLocation(tempP);
        int sc;
        if(r.nextInt(100)<=probability)
            sc=r.nextInt(maxSc-1)+1;
        else
            sc=-(r.nextInt(maxSc-1)+1);
        int time=minTime+r.nextInt(maxTime-minTime);
        SpecialFood sf=new SpecialFood(sc,time);
        sf.initialise(sc, 0);
        sf.setPosition(pos);
        return sf;
    }

    void notifySpecialFoodEaten()
    {
        count=0;
    }
}
