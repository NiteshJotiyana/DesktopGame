/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import game.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nitesh
 */
public class Nest extends JLabel implements MouseListener
{
    //Private Member
    private JLabel info;
    private JLabel l;
    private Icon nest_icon = new ImageIcon(Constants.imageFolder+"bird_nest_y.jpg");
    private Icon nest_big_icon = new ImageIcon(Constants.imageFolder+"bird_nest_b.jpg");
    private int x,y;
    
    //Constructor
    public Nest(Container c,int x,int y)
    {
        this.x=x;
        this.y=y;
       
        //text label
        info = new JLabel();
        this.add(info);
        info.setBounds(0,50,96,20);
           
        //icon label
        l= new JLabel(nest_icon);
        this.add(l);
        l.setBounds(0,0,96,50);
        
        //nest properties
        c.add(this);
        this.setLocation(x,y);
        this.addMouseListener(this);
        setLayout(null);
        setSize(96,70);
    }
    public void setInfo(String s)
    {
        info.setText(s);
    }
    public void mouseClicked(MouseEvent me)
    {	
       
    }
    public void mouseEntered(MouseEvent me)
    {
       this.setLocation(x+5,y+5);
       info.setVisible(true);
       l.setIcon(nest_big_icon);
            
    }
    public void mouseExited(MouseEvent me)
    {
       this.setLocation(x,y);
       l.setIcon(nest_icon);
       info.setVisible(false);
       
    }
    public void mousePressed(MouseEvent me)
    {
    }
    public void mouseReleased(MouseEvent me)
    {
    }
    
}
