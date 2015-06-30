/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Testing extends JFrame
{
    private JPanel gameField=new JPanel();
    Testing()
    {
        super();
        this.setSize(Constants.frameWidth, Constants.frameHeight);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        gameField.setSize(Constants.fieldWidth, Constants.fieldHeight);
        gameField.setBackground(Color.cyan);
        this.add(gameField);
        
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        gameField.setBackground(Color.red);
        //ScheduledThreadPoolExecutor
    }
    public static void main(String ad[])
    {
        Integer i=null;
        int v=i;
        System.out.println(i);
        /*Vector<Integer> v=new Vector<Integer>();
        v.add(12);
        v.add(23);
        v=(Vector<Integer>) Collections.unmodifiableCollection(v);
        v.add(213);
        new Testing();*/
    }
}
