/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
/**
 *
 * @author vani
 */
public class SidePanel extends JPanel
{
    private JLabel logo;

    private JPanel scoreInfo=new JPanel();
    private JLabel gameScore=new JLabel();

    private JPanel foodInfo=new JPanel();
    private JLabel foodIcon=new JLabel();
    private JLabel foodScore=new JLabel("Points:1");
    private JLabel foodPosition=new JLabel("Location:null");

    private JPanel specialFoodInfo=new JPanel();
    private JLabel specialFoodIcon=new JLabel();
    private JLabel specialFoodScore=new JLabel();
    private JLabel specialFoodTiming=new JLabel();
    private JLabel specialFoodPosition=new JLabel();

    private JPanel messageInfo=new JPanel();
    private JLabel heading=new JLabel();
    private JLabel message=new JLabel();

    ImageIcon normalFoodIcon;
    ImageIcon positiveSpFoodIcon;
    ImageIcon negativeSpFoodIcon;
    ImageIcon nullIcon;
    
    SidePanel()
    {
        super();
        //this.setLayout(new GridBagLayout());
        positiveSpFoodIcon=new ImageIcon(Constants.positiveSpecialFoodImage);
        negativeSpFoodIcon=new ImageIcon(Constants.negativeSpecialFoodImage);
        normalFoodIcon=new ImageIcon(Constants.foodImage);
        nullIcon=new ImageIcon();

        ImageIcon icon = new ImageIcon(Constants.logoImagePath);
        JLabel label = new JLabel();
        label.setSize(Constants.sidePanelWidth, 200);
        label.setLocation(0, 0);
        label.setIcon(icon);
        this.add(label);

        foodInfo.setLayout(new GridLayout(1,2));
        foodInfo.setBackground(Color.black);
        foodIcon.setIcon(normalFoodIcon);
        foodInfo.add(foodIcon);
            JPanel jp1=new JPanel();
            jp1.setBackground(Color.black);
            jp1.setLayout(new GridLayout(2,1));
            jp1.add(foodScore);foodScore.setForeground(Color.white);
            jp1.add(foodPosition);foodPosition.setForeground(Color.white);
        foodInfo.add(jp1);
        this.add(foodInfo);

        specialFoodInfo.setLayout(new GridLayout(1, 2));
        specialFoodInfo.setBackground(Color.black);
        specialFoodInfo.add(specialFoodIcon);
            JPanel jp=new JPanel();
            jp.setBackground(Color.black);
            jp.setLayout(new GridLayout(3, 1));
            jp.add(specialFoodScore);specialFoodScore.setForeground(Color.white);
            jp.add(specialFoodPosition);specialFoodPosition.setForeground(Color.white);
            jp.add(specialFoodTiming);specialFoodTiming.setForeground(Color.white);
        specialFoodInfo.add(jp);
        this.add(specialFoodInfo);

        scoreInfo.setBackground(Color.black);
        scoreInfo.add(gameScore);gameScore.setForeground(Color.white);
        this.add(scoreInfo);

        messageInfo.setLayout(new GridLayout(2, 1));
        messageInfo.setBackground(Color.black);
        messageInfo.add(heading);heading.setForeground(Color.white);
            heading.setText("*****Last Snake action*****");
        messageInfo.add(message);message.setForeground(Color.white);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(messageInfo);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
    }
    public void setScore(double sc)
    {
        gameScore.setText("Score  :  "+sc);
    }
    void setFoodInfo(Food food)
    {
       if(food==null)
          return;
       this.foodPosition.setText("Location="+'('+food.position.x+','+food.position.y+')');
    }
    void setSpecialFoodInfo(SpecialFood spFood)
    {
       if(spFood==null)
       {
           this.specialFoodInfo.setVisible(false);
          this.specialFoodIcon.setIcon(nullIcon);
          this.specialFoodPosition.setText("Location=null");
          this.specialFoodScore.setText("Points:null");
          this.specialFoodTiming.setText("Time:null");
          return;
       }
       this.specialFoodInfo.setVisible(true);
       if(spFood.getScore()<=0)
         this.specialFoodIcon.setIcon(this.negativeSpFoodIcon);
       else
          this.specialFoodIcon.setIcon(positiveSpFoodIcon);
       this.specialFoodPosition.setText("Location="+'('+spFood.position.x+','+spFood.position.y+')');
       this.specialFoodScore.setText("Points:"+spFood.getScore());
       this.specialFoodTiming.setText("Time:"+spFood.time);
    }
    public void refresh()
    {
        
    }

   void updateSpFoodTime(int time)
   {
      this.specialFoodTiming.setText("Time:"+time);
   }

    void setMessage(String message)
    {
        if(message==null)
            this.message.setText("");
        else
            this.message.setText(message);
    }
}
