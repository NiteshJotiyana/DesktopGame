
/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import game.*;


/**
 *
 * @author Nitesh
 */
public class Basket extends JLabel implements KeyListener
{
    private Icon grass_icon = new ImageIcon(Constants.imageFolder+"basket1.png");
    private JLabel l;
    private int count=0;
    Component c= new JLabel();
    Main m;
    public Basket(Main m,int x,int y)
    {
        this.m=m;
        //thread
       
        //setting image
        l= new JLabel(grass_icon);
        this.add(l);
        l.setBounds(0,0,198,100);
        
        //Label properties
        m.tree.add(this);
        this.setLocation(x,y);
        m.addKeyListener(this);
        setLayout(null);
        setSize(198,100);
      
    }
    public void setCount()
    {
        count++;
        m.e.b.text.setText(""+count);
    }
    public int getCount()
    {
        return count;
    }
    public void keyPressed(KeyEvent ke)
    {
            Point p = this.getLocation();
            int k = (int)p.getX();
            int l = (int)p.getY();

            int code =ke.getKeyCode();
            
            if (code==37)		//key left
            {
                this.setLocation(k-20,l);
            }
            if (code==39)		//key right
            {
                 this.setLocation(k+20,l);
            }

    }
    public void keyReleased(KeyEvent ke)
    {
    }
    public void keyTyped(KeyEvent ke)
    {
    }
	

    
}
