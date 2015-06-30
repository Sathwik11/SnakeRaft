/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// all positions of the body are the the block positions with screen coordinate system...
 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Snake
{
    Game game;
    Body head;
    Body tail;
    Velocity velocity;
    public enum PATH{STRAIGHT,LEFT,RIGHT};
    public enum Velocity{Up,Down,Left,Right};
    PATH path=null;
    int increaseL=0;
    int paintCount=1;
    Color bodyColor=new Color(162,0,170);
    Snake(Game game)
    {
        this.game=game;
        head=new Head();
        tail=new Tail();
        //System.out.println("head tail initilsied");
        path=PATH.STRAIGHT;
        velocity=Velocity.Right;
        head.setPosition(new Point(Constants.number_of_blocks/2,Constants.number_of_blocks/2));
        head.next=tail;
        tail.setPosition(new Point((Constants.number_of_blocks/2)-1,Constants.number_of_blocks/2));
    }
    Point getHeadPostion()
    {
        return (Point)head.position.clone();
    }
    Point getTailPosition()
    {
        return (Point)tail.position.clone();
    }
    void move()
    {
        //Vector<Vector<Object>> fieldArray=game.getFieldArray();
        Point headPos=moveHead();
        boolean flag=game.checkCollisions((Point)headPos.clone());

        if(flag)//flag means game over
        {
            return;
        }
        if(increaseL>0)
        {
            Body temp=new Body();
            temp.setPosition(head.getPosition());
            temp.next=head.next;
            head.next=temp;
            head.setPosition(headPos);
            increaseL--;
        }
        else
            advanceBodyParts(head,headPos);
        /*Point tailPos=tail.getPosition();
        System.out.println("tail pos="+tailPos);
        advanceBodyParts(head,headPos);

        if(increaseL>0)
        {
            tail.next=new Tail();
            tail.next.setPosition(tailPos);
            tail=tail.next;
            increaseL--;
        }
        */
        path=PATH.STRAIGHT;
    }
    void advanceBodyParts(Body body,Point pos)
    {
        //System.out.println("--------"+pos);
        if(body==null)
            return;
        advanceBodyParts(body.next,body.getPosition());
        body.setPosition(pos);
        //System.out.println("==========="+body.position);
    }
    void notifyIncreaseLength(int n)
    {
        if(n<=0)
            return;
        increaseL+=n;
    }
    Point moveHead()
    {
        /*if(head==null)
            System.out.println("ull head");
        if(head.position==null)
            System.out.println("ull head.pos");*/
        Point pos=(Point) head.position.clone();

        switch(path)
        {
            case STRAIGHT:
                advanceStraight(pos);
                break;
            case LEFT:
                advanceLeft(pos);
                break;
            case RIGHT:
                advanceRight(pos);
        }
        return pos;
    }
    public Velocity getCurrentVelocity()
    {
        return velocity;
    }
    void setPathLeft()
    {
        path=PATH.LEFT;
    }
    void setPathRight()
    {
        path=PATH.RIGHT;
    }
    void setPathStraight()
    {
        path=PATH.STRAIGHT;
    }
    void paint(Graphics g)
    {
        //System.out.println("snake paint()");
        Body temp=head;
        //System.out.println("---------------------");
        while(temp!=null)
        {
            temp.paint(g);
            //System.out.println(temp.getPosition());
            temp=temp.next;
        }
        //System.out.println("---------------------");
    }
    public class Body
    {
        Point position;
        Body next;
        int paintCount=1;
        Body()
        {
            position=new Point(-1,-1);
            next=null;
        }
        void setPosition(Point p)
        {
            position.setLocation(p);
        }
        Point getPosition()
        {
            return (Point)position.clone();
        }
        void paint(Graphics g)
        {
            int x=position.x*Constants.blockSize;
            int y=position.y*Constants.blockSize;
            Color ct=g.getColor();
            g.setColor(Color.gray);
            g.fillOval(x, y, Constants.blockSize+1, Constants.blockSize+1);
            g.setColor(ct);
        }
    }
    public class Tail extends Body
    {
        Tail()
        {
            super();
        }
        public void paint(Graphics g)
        {
            super.paint(g);
            int x=position.x*Constants.blockSize;
            int y=position.y*Constants.blockSize;
            Color ct=g.getColor();
            g.setColor(Color.black);
            g.drawLine(x, y,x+ Constants.blockSize, y+Constants.blockSize);
            g.setColor(ct);
        }
    }
    public class Head extends Body
    {
        Head()
        {
            super();
        }
        public void paint(Graphics g)
        {
            super.paint(g);
            int x=position.x*Constants.blockSize;
            int y=position.y*Constants.blockSize;
            Color ct=g.getColor();
            g.setColor(Color.black);
            g.drawLine(x, y,x+ Constants.blockSize, y+Constants.blockSize);
            g.drawLine(x+Constants.blockSize, y, x, y+Constants.blockSize);
            g.setColor(ct);
        }
    }
    private void advanceStraight(Point pos)
    {
        switch(velocity)
        {
            case Up:pos.setLocation(pos.x, pos.y-1);
                break;
            case Down:pos.setLocation(pos.x,pos.y+1);
                break;
            case Left:pos.setLocation(pos.x-1, pos.y);
                break;
            case Right:pos.setLocation(pos.x+1, pos.y);
                break;
        }
    }

    private void advanceLeft(Point pos)
    {
        switch(velocity)
        {
            case Up:
                pos.setLocation(pos.x-1, pos.y);
                velocity=Velocity.Left;
                break;
            case Down:
                pos.setLocation(pos.x+1, pos.y);
                velocity=Velocity.Right;
                break;
            case Left:
                pos.setLocation(pos.x, pos.y+1);
                velocity=Velocity.Down;
                break;
            case Right:
                pos.setLocation(pos.x,pos.y-1);
                velocity=Velocity.Up;
                break;
        }
    }

    private void advanceRight(Point pos)
    {
        switch(velocity)
        {
            case Up:
                pos.setLocation(pos.x+1, pos.y);
                velocity=Velocity.Right;
                break;
            case Down:
                pos.setLocation(pos.x-1, pos.y);
                velocity=Velocity.Left;
                break;
            case Left:
                pos.setLocation(pos.x,pos.y-1);
                velocity=Velocity.Up;
                break;
            case Right:
                pos.setLocation(pos.x, pos.y+1);
                velocity=Velocity.Down;
                break;
        }
    }
}
