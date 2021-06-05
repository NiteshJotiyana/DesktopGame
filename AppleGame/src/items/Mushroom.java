/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import game.Constants;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Minakshi
 */
public class Mushroom extends JLabel
{
    //Private Member
    private Icon mushroom_big = new ImageIcon(Constants.imageFolder+"mushroom1.png");
    private Icon mushroom_small = new ImageIcon(Constants.imageFolder+"small_mushroom1.png");
    private JLabel l;
   
    //Static Field 
    public static final int SMALL=0;
    public static final int BIG=1;
    
    //Counstrustor
    public Mushroom(Container c,int x,int y,int type)
    {
        //Label properties
        this.setName("mushroom");
        c.add(this);
        this.setLocation(x,y);
        setLayout(null);
        
        //setting image
        if(type==SMALL) //For small stone
        {
            l= new JLabel(mushroom_small);
            l.setBounds(0,0,50,54);
            setSize(50,54);
        }
        else            //For big stone
        {
            l= new JLabel(mushroom_big);
            l.setBounds(0,0,70,80);
            setSize(70,80);
        }
        this.add(l);
   }
}
