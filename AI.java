import java.awt.Point;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * You have to code all your logic for controlling the snake within this class..
 */

public class AI implements Runnable
{
    Game game;
    int i,j,k,l,x,y,x1,y1,sfp;
    int flag;
    Point p;
    AI()
    {
     
    }
    int count=0;
    AI(Game game)
    {
    	i=0;
    	j=0;
    	k=0;
    	l=0;
    	x=0;
    	y=0;
    	x1=-1;
    	y1=-1;
    	flag=0;
    	sfp=0;
        this.game=game;
        p=new Point(i,j);
    }
    public void play()
    {
        
    }
    public void run()
    {
    	      
    	     //Saving the Head Location
    	      
    	      i=(int)game.getSnakeHeadLocation().getX();
    	      j=(int)game.getSnakeHeadLocation().getY();
    	      x=(int)game.getFoodLocation().getX();
    	      y=(int)game.getFoodLocation().getY();
    	         for(int i=0;i<20;i++)
    	            for(int j=0;j<20;j++)
    	            {
    	            	if(game.getField()[i][j]=='s')
    	            	{
    	            		flag=1;
    	            		x1=j;
    	            		y1=i;
    	            		sfp=game.getSpecialFoodPoints();
    	            		
    	            	}
    	            }
    	      
    	             
    	      if(flag==0)
    	      {
    	    	  x1=-1;
    	    	  y1=-1;
    	    	  sfp=0;
    	      }
    	      flag=0;
    	      
    	    //Directions
   
    	
    	      if(sfp>0)
        	  {
        		  if(game.getsnakeDirection().equals(Snake.Velocity.Left))
         	     {
         	    	 k=j+1;
         	    	 l=j-1;
         	    	 if(game.getSnakeHeadLocation().getY()>game.getSpecialFoodLocation().getY())
         	    	 {
         	    		  
         	    		 
         	    		 if(l>=0) 
         	    		 {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	    	     else if((k<=19))
         	    	     {
         	    	    	 p.setLocation(i,k);
         	    	    	 if((game.isFieldPositionEmpty(p)) ||((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     }
             	    		 
         	    		
         	    	     
         	    	 }	 
         	    		 
         	         if(game.getSnakeHeadLocation().getY()<game.getSpecialFoodLocation().getY())
         	         {
         	        	 
         	        	
         	    		 if( (k<=19))
         	    		 {
         	    			 p.setLocation(i,k);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
           	        	  	        
         	             else if( (l>=0))
         	             {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
        	        	    
        	    		 
         	    	     
         	    	 }	 
         	         
         	         if((game.getSnakeHeadLocation().getY()==game.getSpecialFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()<game.getSpecialFoodLocation().getX()) )
         	         {
         	        	 
         	    		
         	    		 if( (l>=0) )
         	    		 {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	        	
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(i,k);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
        	        	     
         	        	 
         	    	 }	 
         	         
         	         
         	         if((game.getSnakeHeadLocation().getY()==game.getSpecialFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()>game.getSpecialFoodLocation().getX()) )
         	         {
         	        	 
         	        	l=i-1;
         	        	
         	        		p.setLocation(l, j);
         	        		if( (l>=0) && (((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)))) )
        	    			    {
        	    				 game.moveStraight(); 
        	    			    }
         	        		
         	        		else if(!game.isFieldPositionEmpty(p))
        	    			    {
         	        			l=j-1;
         	    	    		k=j+1;
         	    	           
         	    	    			 p.setLocation(i,l);
         	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l))) )
         	    	    			 {
         	    	    				 game.moveRight(); 
         	    	    			 }
         	    	    			 
         	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
         	    	    			 {
         	    	    				 game.moveLeft();
         	    	    			 }
         	    	    		 
        	    			    }
         	        	
         	    	
         	    	 }	 
         	         
         	    		 
         	     }
         	     
         	     
         	     if(game.getsnakeDirection().equals(Snake.Velocity.Right))
         	     {
         	    	 k=j+1;
         	    	 l=j-1;
         	    	 if(game.getSnakeHeadLocation().getY()>game.getSpecialFoodLocation().getY())
         	    	 {
         	    		
         	    		 if( (l>=0))
         	    		 {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	    		 
         	    		
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(i,k);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((i>=0)&&(!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	    		 
         	    		 
         	    		 
         	    	     
         	    	 }	 
         	    		 
         	         if(game.getSnakeHeadLocation().getY()<game.getSpecialFoodLocation().getY())
         	         {
         	        	 
         	             
         	    		 if( (k<=19))
         	    		 {
         	    			 p.setLocation(i,k);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((i>=0) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	        	 
         	    		 else if( (l>=0))
         	    		 {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	        	 
         	    	     
         	    	 }	 
         	         
         	         if((game.getSnakeHeadLocation().getY()==game.getSpecialFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()>game.getSpecialFoodLocation().getX()))
         	         {
         	        	 
         	             
         	    		 if( (l>=0))
         	    		 {
         	    			 p.setLocation(i,l);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	        	 
         	        	 
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(i,k);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((l>=0) && (!game.isFieldPositionEmpty(p)))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
        	    		 
         	    	     
         	    	 }	
         	         
         	         
         	         if((game.getSnakeHeadLocation().getY()==game.getSpecialFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()<game.getSpecialFoodLocation().getX()) )
         	         {
         	        	 
         	        	k=i+1;
         	        	
         	        		p.setLocation(k, j);
         	        		if( (k<=19) && (((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)))) )
        	    			    {
        	    				 game.moveStraight(); 
        	    			    }
         	        		
         	        		else if(!game.isFieldPositionEmpty(p))
        	    			    {
         	        			l=j-1;
         	    	    		k=j+1;
         	    	           
         	    	    			 p.setLocation(i,l);
         	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l))) )
         	    	    			 {
         	    	    				 game.moveLeft(); 
         	    	    			 }
         	    	    			 
         	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
         	    	    			 {
         	    	    				 game.moveLeft();
         	    	    			 }
         	    	    		 
        	    			    }
         	        	
         	    	
         	    	 }	 
         	         
         	    		 
         	     }
         	     
         	     
         	     if(game.getsnakeDirection().equals(Snake.Velocity.Up))
         	     {
         	    	 k=i+1;
         	    	 l=i-1;
         	    	 if(game.getSnakeHeadLocation().getX()<game.getSpecialFoodLocation().getX())
         	    	 {
         	    		
         	    		 if( (k<=19))
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((i>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	    		 
         	    		 else if( (l>=0))
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	    		 
         	    		
         	    	 }	 
         	    		 
         	         if(game.getSnakeHeadLocation().getX()>game.getSpecialFoodLocation().getX())
         	         {
         	             
         	        	
         	    		 if( (l>=0) )
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	        	 
         	        	 
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((i>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	    	     
         	    	 }	 
         	         
         	         if((game.getSnakeHeadLocation().getX()==game.getSpecialFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()<game.getSpecialFoodLocation().getY()) )
         	         {
         	        	 
         	            
         	        	 
         	    		 if((k<=19) )
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((i>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	        	
         	    		 else if( (l>=0))
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     }
         	    		 
         	        	 
         	    	 }	
         	         
         	         
         	         if((game.getSnakeHeadLocation().getX()==game.getSpecialFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()>game.getSpecialFoodLocation().getY()) )
         	         {
         	        	 
         	        	l=j-1;
         	        	
         	        		p.setLocation(i,l);
         	        		if( (l>=0) && (((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)))) )
        	    			    {
        	    				 game.moveStraight(); 
        	    			    }
         	        		
         	        		else if(!game.isFieldPositionEmpty(p))
        	    			    {
         	        			l=i-1;
         	    	    		k=i+1;
         	    	           
         	    	    			 p.setLocation(k,j);
         	    	    			 if( (k<=19) && ((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j))) )
         	    	    			 {
         	    	    				 game.moveRight(); 
         	    	    			 }
         	    	    			 
         	    	    			 else if((l>=0) && (!game.isFieldPositionEmpty(p)))
         	    	    			 {
         	    	    				 game.moveLeft();
         	    	    			 }
         	    	    		 
        	    			    }
         	        	
         	    	
         	    	 }	 
         	         
         	    		 
         	     }
         	     
         	     
         	     if(game.getsnakeDirection().equals(Snake.Velocity.Down))
         	     {
         	    	 k=i+1;
         	    	 l=i-1;
         	    	 
         	    	 if(game.getSnakeHeadLocation().getX()>game.getSpecialFoodLocation().getX())
         	    	 {
         	    	
         	    		
         	    		 if( (l>=0))
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	    		 
         	    		 
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	    		
         	    	     
         	    	 }	 
         	    		 
         	         if(game.getSnakeHeadLocation().getX()<game.getSpecialFoodLocation().getX())
         	         {
         	    	
         	        	 
         	    		 if( (k<=19))
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     }
         	    		    	        	 
         	        	 
         	             
         	    		 else if( (l>=0))
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	        	
         	    	     
         	    	 }	 
         	         
         	         if((game.getSnakeHeadLocation().getX()==game.getSpecialFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()>game.getSpecialFoodLocation().getY()) )
         	         {
         	        	 
         	        	
         	    		 if((l>=0))
         	    		 {
         	    			 p.setLocation(l,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
         	    			 {
         	    				 game.moveRight(); 
         	    			 }
         	    			 
         	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveLeft();
         	    			 }
         	    		 }
         	        	 
         	        	 
         	          
         	    		 else if( (k<=19))
         	    		 {
         	    			 p.setLocation(k,j);
         	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
         	    			 {
         	    				 game.moveLeft(); 
         	    			 }
         	    			 
         	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
         	    			 {
         	    				 game.moveRight();
         	    			 }
         	    	     
         	    		 }
         	        
         	        	 
         	    	 }	 
         	         
         	         
         	         if((game.getSnakeHeadLocation().getX()==game.getSpecialFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()<game.getSpecialFoodLocation().getY()) )
         	         {
         	        	 
         	        	k=j+1;
         	        	
         	        		p.setLocation(i,k);
         	        		if((k<=19) &&(((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)))) )
        	    			    {
        	    				 game.moveStraight(); 
        	    			    }
         	        		
         	        		else if(!game.isFieldPositionEmpty(p))
        	    			    {
         	        			l=i-1;
         	    	    		k=i+1;
         	    	           
         	    	    			 p.setLocation(l,j);
         	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j))) )
         	    	    			 {
         	    	    				 game.moveRight(); 
         	    	    			 }
         	    	    			 
         	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
         	    	    			 {
         	    	    				 game.moveLeft();
         	    	    			 }
         	    	    		 
        	    			    }
         	        	
         	    	
         	    	 }	 
         	         
         	    		 
         	     }
         	     
         	     
         		 //Boundaries at side walls
         	     
         	     if(((game.getSnakeHeadLocation().getY()==0) ||(game.getSnakeHeadLocation().getY()==19)) && ((game.getSnakeHeadLocation().getX()!=0) && (game.getSnakeHeadLocation().getX()!=19)) )
         		 {
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
         			 {
         		      if((game.getSpecialFoodLocation().getX())<(game.getSnakeHeadLocation().getX()))
         		    	  game.moveLeft();
         		      if((game.getSpecialFoodLocation().getX())>(game.getSnakeHeadLocation().getX()))
         		    	  game.moveRight();
         			 }
         				 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
         			 {
            		      if((game.getSpecialFoodLocation().getX())<(game.getSnakeHeadLocation().getX()))
         		    	  game.moveRight();
         		      if((game.getSpecialFoodLocation().getX())>(game.getSnakeHeadLocation().getX()))
         		    	  game.moveLeft();

         			 }
         			
         		 }
         		 
         		 
         		 
         		 if(((game.getSnakeHeadLocation().getX()==0) ||(game.getSnakeHeadLocation().getX()==19)) && ((game.getSnakeHeadLocation().getY()!=0) && (game.getSnakeHeadLocation().getY()!=19)) )
         		 {
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
         			 {
         		      if((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))
         		    	  game.moveLeft();
         		      if((game.getSpecialFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))
         		    	  game.moveRight();
         			 }
         				 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
         			 {
            		      if((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))
         		    	  game.moveRight();
         		      if((game.getSpecialFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))
         		    	  game.moveLeft();

         			 }
         			
         		 }

         		 
         		 //Boundary walls Special case
         		 
         		 if(((game.getSnakeHeadLocation().getX()>0) && (game.getSnakeHeadLocation().getX()<19)) && (game.getSnakeHeadLocation().getY()==0))
         		 {
         			 l=j-1;
     				 k=j+1;
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
         			 {
         				
         				 p.setLocation(i,k);
         				 if(((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveLeft();
         				 else
            				  game.moveStraight(); 
         			 }
         			 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
         			 {
         				 p.setLocation(i,k);
         				 if(((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveRight();
         				 else
               		      game.moveStraight(); 

         			 }
         		 }
         		 
         		 
         		 if(((game.getSnakeHeadLocation().getX()>0) && (game.getSnakeHeadLocation().getX()<19)) && (game.getSnakeHeadLocation().getY()==19))
         		 {
         			 l=j-1;
     				 k=j+1;
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
         			 {
         				 p.setLocation(i,l);
         				 if(((game.getSpecialFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveRight();
         				 else
                  		      game.moveStraight();  
         			 }
         			 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
         			 {
         				 p.setLocation(i,l);
         				 if(((game.getSpecialFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveLeft();
         				 else
                  		      game.moveStraight(); 
         			 }
         		 }
         		 
         		 
         		 if(((game.getSnakeHeadLocation().getY()>0) && (game.getSnakeHeadLocation().getY()<19)) && (game.getSnakeHeadLocation().getX()==0))
         		 {
         			 l=i-1;
     				 k=i+1;
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
         			 {
         				 p.setLocation(k,j);
         				 if(((game.getSpecialFoodLocation().getX())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveRight();
         				 else
                  		      game.moveStraight(); 
         			 }
         			 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
         			 {
         				 p.setLocation(k,j);
         				 if(((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveLeft();
         				 else
                  		      game.moveStraight(); 
         			 }
         		 }
         		 
         		 
         		 if(((game.getSnakeHeadLocation().getY()>0) && (game.getSnakeHeadLocation().getY()<19)) && (game.getSnakeHeadLocation().getX()==19))
         		 {
         			 l=i-1;
     				 k=i+1;
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
         			 {
         				 p.setLocation(l,j);
         				 if(((game.getSpecialFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveLeft();
         				 else
                  		      game.moveStraight(); 
         			 }
         			 
         			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
         			 {
         				 p.setLocation(l,j);
         				 if(((game.getSpecialFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
            		    	  game.moveRight();
         				 else
                  		      game.moveStraight(); 
         			 }
         		 }
         	    	 
         	    
         		 

        	  }
    	      
    	  else
    	  {
    	     if(game.getsnakeDirection().equals(Snake.Velocity.Left))
    	     {
    	    	 k=j+1;
    	    	 l=j-1;
    	    	 if(game.getSnakeHeadLocation().getY()>game.getFoodLocation().getY())
    	    	 {
    	    		  
    	    		 
    	    		 if(l>=0) 
    	    		 {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	    	     else if((k<=19))
    	    	     {
    	    	    	 p.setLocation(i,k);
    	    	    	 if((game.isFieldPositionEmpty(p)) ||((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     }
        	    		 
    	    		
    	    	     
    	    	 }	 
    	    		 
    	         if(game.getSnakeHeadLocation().getY()<game.getFoodLocation().getY())
    	         {
    	        	 
    	        	
    	    		 if( (k<=19))
    	    		 {
    	    			 p.setLocation(i,k);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
      	        	  	        
    	             else if( (l>=0))
    	             {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
   	        	    
   	    		 
    	    	     
    	    	 }	 
    	         
    	         if((game.getSnakeHeadLocation().getY()==game.getFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()<game.getFoodLocation().getX()) )
    	         {
    	        	 
    	    		
    	    		 if( (l>=0) )
    	    		 {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	        	
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(i,k);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
   	        	     
    	        	 
    	    	 }	 
    	         
    	         
    	         if((game.getSnakeHeadLocation().getY()==game.getFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()>game.getFoodLocation().getX()) )
    	         {
    	        	 
    	        	l=i-1;
    	        	
    	        		p.setLocation(l, j);
    	        		if( (l>=0) && (((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)))) )
   	    			    {
   	    				 game.moveStraight(); 
   	    			    }
    	        		
    	        		else if(!game.isFieldPositionEmpty(p))
   	    			    {
    	        			l=j-1;
    	    	    		k=j+1;
    	    	           
    	    	    			 p.setLocation(i,l);
    	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l))) )
    	    	    			 {
    	    	    				 game.moveRight(); 
    	    	    			 }
    	    	    			 
    	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
    	    	    			 {
    	    	    				 game.moveLeft();
    	    	    			 }
    	    	    		 
   	    			    }
    	        	
    	    	
    	    	 }	 
    	         
    	    		 
    	     }
    	     
    	     
    	     if(game.getsnakeDirection().equals(Snake.Velocity.Right))
    	     {
    	    	 k=j+1;
    	    	 l=j-1;
    	    	 if(game.getSnakeHeadLocation().getY()>game.getFoodLocation().getY())
    	    	 {
    	    		
    	    		 if( (l>=0))
    	    		 {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	    		 
    	    		
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(i,k);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	    		 
    	    		 
    	    		 
    	    	     
    	    	 }	 
    	    		 
    	         if(game.getSnakeHeadLocation().getY()<game.getFoodLocation().getY())
    	         {
    	        	 
    	             
    	    		 if( (k<=19))
    	    		 {
    	    			 p.setLocation(i,k);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	        	 
    	    		 else if( (l>=0))
    	    		 {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	        	 
    	    	     
    	    	 }	 
    	         
    	         if((game.getSnakeHeadLocation().getY()==game.getFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()>game.getFoodLocation().getX()))
    	         {
    	        	 
    	             
    	    		 if( (l>=0))
    	    		 {
    	    			 p.setLocation(i,l);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	        	 
    	        	 
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(i,k);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
   	    		 
    	    	     
    	    	 }	
    	         
    	         
    	         if((game.getSnakeHeadLocation().getY()==game.getFoodLocation().getY()) && (game.getSnakeHeadLocation().getX()<game.getFoodLocation().getX()) )
    	         {
    	        	 
    	        	k=i+1;
    	        	
    	        		p.setLocation(k, j);
    	        		if( (k<=19) && (((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)))) )
   	    			    {
   	    				 game.moveStraight(); 
   	    			    }
    	        		
    	        		else if(!game.isFieldPositionEmpty(p))
   	    			    {
    	        			l=j-1;
    	    	    		k=j+1;
    	    	           
    	    	    			 p.setLocation(i,l);
    	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l))) )
    	    	    			 {
    	    	    				 game.moveLeft(); 
    	    	    			 }
    	    	    			 
    	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
    	    	    			 {
    	    	    				 game.moveLeft();
    	    	    			 }
    	    	    		 
   	    			    }
    	        	
    	    	
    	    	 }	 
    	         
    	    		 
    	     }
    	     
    	     
    	     if(game.getsnakeDirection().equals(Snake.Velocity.Up))
    	     {
    	    	 k=i+1;
    	    	 l=i-1;
    	    	 if(game.getSnakeHeadLocation().getX()<game.getFoodLocation().getX())
    	    	 {
    	    		
    	    		 if( (k<=19))
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	    		 
    	    		 else if( (l>=0))
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	    		 
    	    		
    	    	 }	 
    	    		 
    	         if(game.getSnakeHeadLocation().getX()>game.getFoodLocation().getX())
    	         {
    	             
    	        	
    	    		 if( (l>=0) )
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	        	 
    	        	 
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	    	     
    	    	 }	 
    	         
    	         if((game.getSnakeHeadLocation().getX()==game.getFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()<game.getFoodLocation().getY()) )
    	         {
    	        	 
    	            
    	        	 
    	    		 if((k<=19) )
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	        	
    	    		 else if( (l>=0))
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     }
    	    		 
    	        	 
    	    	 }	
    	         
    	         
    	         if((game.getSnakeHeadLocation().getX()==game.getFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()>game.getFoodLocation().getY()) )
    	         {
    	        	 
    	        	l=j-1;
    	        	
    	        		p.setLocation(i,l);
    	        		if( (l<=0) && (((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==l)) || ((x==i) && (y==l)))) )
   	    			    {
   	    				 game.moveStraight(); 
   	    			    }
    	        		
    	        		else if(!game.isFieldPositionEmpty(p))
   	    			    {
    	        			l=i-1;
    	    	    		k=i+1;
    	    	           
    	    	    			 p.setLocation(k,j);
    	    	    			 if( (k<=19) && ((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j))) )
    	    	    			 {
    	    	    				 game.moveRight(); 
    	    	    			 }
    	    	    			 
    	    	    			 else if((l<=0) && (!game.isFieldPositionEmpty(p)))
    	    	    			 {
    	    	    				 game.moveLeft();
    	    	    			 }
    	    	    		 
   	    			    }
    	        	
    	    	
    	    	 }	 
    	         
    	    		 
    	     }
    	     
    	     
    	     if(game.getsnakeDirection().equals(Snake.Velocity.Down))
    	     {
    	    	 k=i+1;
    	    	 l=i-1;
    	    	 
    	    	 if(game.getSnakeHeadLocation().getX()>game.getFoodLocation().getX())
    	    	 {
    	    	
    	    		
    	    		 if( (l>=0))
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	    		 
    	    		 
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	    		
    	    	     
    	    	 }	 
    	    		 
    	         if(game.getSnakeHeadLocation().getX()<game.getFoodLocation().getX())
    	         {
    	    	
    	        	 
    	    		 if( (k<=19))
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     }
    	    		    	        	 
    	        	 
    	             
    	    		 else if( (l>=0))
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	        	
    	    	     
    	    	 }	 
    	         
    	         if((game.getSnakeHeadLocation().getX()==game.getFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()>game.getFoodLocation().getY()) )
    	         {
    	        	 
    	        	
    	    		 if((l>=0))
    	    		 {
    	    			 p.setLocation(l,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j)) )
    	    			 {
    	    				 game.moveRight(); 
    	    			 }
    	    			 
    	    			 else if((k<=19)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveLeft();
    	    			 }
    	    		 }
    	        	 
    	        	 
    	          
    	    		 else if( (k<=19))
    	    		 {
    	    			 p.setLocation(k,j);
    	    			 if((game.isFieldPositionEmpty(p)) || ((x1==k) && (y1==j)) || ((x==k) && (y==j)) )
    	    			 {
    	    				 game.moveLeft(); 
    	    			 }
    	    			 
    	    			 else if((l>=0)&&!game.isFieldPositionEmpty(p))
    	    			 {
    	    				 game.moveRight();
    	    			 }
    	    	     
    	    		 }
    	        
    	        	 
    	    	 }	 
    	         
    	         
    	         if((game.getSnakeHeadLocation().getX()==game.getFoodLocation().getX()) && (game.getSnakeHeadLocation().getY()<game.getFoodLocation().getY()) )
    	         {
    	        	 
    	        	k=j+1;
    	        	
    	        		p.setLocation(i,k);
    	        		if((k<=19) &&(((game.isFieldPositionEmpty(p)) || ((x1==i) && (y1==k)) || ((x==i) && (y==k)))) )
   	    			    {
   	    				 game.moveStraight(); 
   	    			    }
    	        		
    	        		else if(!game.isFieldPositionEmpty(p))
   	    			    {
    	        			l=i-1;
    	    	    		k=i+1;
    	    	           
    	    	    			 p.setLocation(l,j);
    	    	    			 if( (l>=0) && ((game.isFieldPositionEmpty(p)) || ((x1==l) && (y1==j)) || ((x==l) && (y==j))) )
    	    	    			 {
    	    	    				 game.moveRight(); 
    	    	    			 }
    	    	    			 
    	    	    			 else if((k<=19) && (!game.isFieldPositionEmpty(p)))
    	    	    			 {
    	    	    				 game.moveLeft();
    	    	    			 }
    	    	    		 
   	    			    }
    	        	
    	    	
    	    	 }	 
    	         
    	    		 
    	     }
    	     
    	     
    		 //Boundaries at side walls
    	     
    	     if(((game.getSnakeHeadLocation().getY()==0) ||(game.getSnakeHeadLocation().getY()==19)) && ((game.getSnakeHeadLocation().getX()!=0) && (game.getSnakeHeadLocation().getX()!=19)) )
    		 {
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
    			 {
    		      if((game.getFoodLocation().getX())<(game.getSnakeHeadLocation().getX()))
    		    	  game.moveLeft();
    		      if((game.getFoodLocation().getX())>(game.getSnakeHeadLocation().getX()))
    		    	  game.moveRight();
    			 }
    				 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
    			 {
       		      if((game.getFoodLocation().getX())<(game.getSnakeHeadLocation().getX()))
    		    	  game.moveRight();
    		      if((game.getFoodLocation().getX())>(game.getSnakeHeadLocation().getX()))
    		    	  game.moveLeft();

    			 }
    			
    		 }
    		 
    		 
    		 
    		 if(((game.getSnakeHeadLocation().getX()==0) ||(game.getSnakeHeadLocation().getX()==19)) && ((game.getSnakeHeadLocation().getY()!=0) && (game.getSnakeHeadLocation().getY()!=19)) )
    		 {
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
    			 {
    		      if((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))
    		    	  game.moveLeft();
    		      if((game.getFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))
    		    	  game.moveRight();
    			 }
    				 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
    			 {
       		      if((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))
    		    	  game.moveRight();
    		      if((game.getFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))
    		    	  game.moveLeft();

    			 }
    			
    		 }

    		 
    		 //Boundary walls Special case
    		 
    		 if(((game.getSnakeHeadLocation().getX()>0) && (game.getSnakeHeadLocation().getX()<19)) && (game.getSnakeHeadLocation().getY()==0))
    		 {
    			 l=j-1;
				 k=j+1;
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
    			 {
    				
    				 p.setLocation(i,k);
    				 if(((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveLeft();
    				 else
       				  game.moveStraight(); 
    			 }
    			 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
    			 {
    				 p.setLocation(i,k);
    				 if(((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveRight();
    				 else
          		      game.moveStraight(); 

    			 }
    		 }
    		 
    		 
    		 if(((game.getSnakeHeadLocation().getX()>0) && (game.getSnakeHeadLocation().getX()<19)) && (game.getSnakeHeadLocation().getY()==19))
    		 {
    			 l=j-1;
				 k=j+1;
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Left))
    			 {
    				 p.setLocation(i,l);
    				 if(((game.getFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveRight();
    				 else
             		      game.moveStraight();  
    			 }
    			 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Right))
    			 {
    				 p.setLocation(i,l);
    				 if(((game.getFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveLeft();
    				 else
             		      game.moveStraight(); 
    			 }
    		 }
    		 
    		 
    		 if(((game.getSnakeHeadLocation().getY()>0) && (game.getSnakeHeadLocation().getY()<19)) && (game.getSnakeHeadLocation().getX()==0))
    		 {
    			 l=i-1;
				 k=i+1;
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
    			 {
    				 p.setLocation(k,j);
    				 if(((game.getFoodLocation().getX())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveRight();
    				 else
             		      game.moveStraight(); 
    			 }
    			 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
    			 {
    				 p.setLocation(k,j);
    				 if(((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveLeft();
    				 else
             		      game.moveStraight(); 
    			 }
    		 }
    		 
    		 
    		 if(((game.getSnakeHeadLocation().getY()>0) && (game.getSnakeHeadLocation().getY()<19)) && (game.getSnakeHeadLocation().getX()==19))
    		 {
    			 l=i-1;
				 k=i+1;
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
    			 {
    				 p.setLocation(l,j);
    				 if(((game.getFoodLocation().getY())>(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveLeft();
    				 else
             		      game.moveStraight(); 
    			 }
    			 
    			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
    			 {
    				 p.setLocation(l,j);
    				 if(((game.getFoodLocation().getY())<(game.getSnakeHeadLocation().getY()))  &&  ((game.isFieldPositionEmpty(p)) || ((x==i) && (y==k)) || ((x1==i) && (y1==k))))
       		    	  game.moveRight();
    				 else
             		      game.moveStraight(); 
    			 }
    		 }
    	    	 
    	   
    	
    		 
    	 }	 
    	  
    	  
    	  
    	  
    	
    	  
    	  //Boundaries at corners	 
  	    
 		 if(((game.getSnakeHeadLocation().getX()==0) && (game.getSnakeHeadLocation().getY()==0)) || ((game.getSnakeHeadLocation().getX()==0) && (game.getSnakeHeadLocation().getY()==19)))
 		 {
 			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
 				 game.moveRight();
 			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
 				 game.moveLeft();
 			 if((game.getsnakeDirection().equals(Snake.Velocity.Left)) && (game.getSnakeHeadLocation().getY()==0))
 				 game.moveLeft();
 			 if((game.getsnakeDirection().equals(Snake.Velocity.Left)) && (game.getSnakeHeadLocation().getY()==19))
 				 game.moveRight();
 		 }
 		 
 		 if(((game.getSnakeHeadLocation().getX()==19) && (game.getSnakeHeadLocation().getY()==0)) || ((game.getSnakeHeadLocation().getX()==19) && (game.getSnakeHeadLocation().getY()==19)))
 		 {
 			 if(game.getsnakeDirection().equals(Snake.Velocity.Up))
 				 game.moveLeft();
 			 if(game.getsnakeDirection().equals(Snake.Velocity.Down))
 				 game.moveRight();
 			 if((game.getsnakeDirection().equals(Snake.Velocity.Right)) && (game.getSnakeHeadLocation().getY()==0))
 				 game.moveRight();
 			 if((game.getsnakeDirection().equals(Snake.Velocity.Right)) && (game.getSnakeHeadLocation().getY()==19))
 				 game.moveLeft();
 		 }
 		 
    	  
    	 
    	 
    		
    
    
   
    
    			    	   
    }
}
