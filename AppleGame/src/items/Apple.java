/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import javax.swing.*;
import java.awt.*;

import game.*;
/**
 *
 * @author Nitesh
 */
public class Apple extends JLabel implements Runnable
{
    private JLabel l;
    private Thread thread;
    private JLabel j;
    private Main m;
    private Component c = new Label();
    private int speed;
    private int temp=0;
    private int stay=0;
    private int stayTime=2000;
   
    //constructor
    public Apple(Main m,int x,int y,int speed)
    {
        //Label properties
        this.setName("apple");
        m.tree.add(this);
        this.setLayout(null);
        this.setLocation(x,y);
        this.setSize(30,34);
        
        //setting image
        Icon i= new ImageIcon(Constants.imageFolder+"apple.gif");
        l= new JLabel(i);
        l.setBounds(0,0,30,34);
        this.add(l);
        
        //parameter variable
        this.speed=speed;
        this.m=m;
               
        //Thread properties
        thread = new Thread(this,"low");
        thread.start();
    }
    
    public void setSpeed(int s)
    {
        speed =s;
    }
    public void setStayTime(int t)
    {
        stayTime=t;
    }
    
    public void run()
    {
        for (int count=1;count>0;count++)
        {
            //getting current position
            c=null;
            Point p = this.getLocation();
            int k = (int)p.getX();
            int l= (int)p.getY();
            
            //catching condition
            c = m.tree.getComponentAt(k+15,l+10);
            if(c!=null&&c==m.b&&temp==0)
            {   
                int r= c.getLocation().x;
                if(k>r+50&&k<r+130)
                {  this.setVisible(false);
                   m.b.setCount();
                }
                temp++;
                
            }
            //moving condition 
            try
            {
                if(stay==0) //Stay Time
                {
                    thread.sleep(stayTime);
                    this.setLocation(k,l+2);
                    stay++;
                }
                else        //Moving Time
                {
                    thread.sleep(speed);
                    if(l!=650)
                        this.setLocation(k,l+2); 
                }
                    
            }
			
            catch (InterruptedException e1)
            {
		System.out.println("child thread interrupted");	
            }
        }   
    }
}
