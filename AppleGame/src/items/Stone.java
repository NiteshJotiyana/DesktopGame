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
public class Stone extends JLabel
{
    //Private Member
    private Icon stone_big = new ImageIcon(Constants.imageFolder+"big_stone.png");
    private Icon stone_small = new ImageIcon(Constants.imageFolder+"small_stone.png");
    private JLabel l;
    
    //Static Fields
    public static final int SMALL=0;
    public static final int BIG=1;
    
    //Counstructor
    public Stone(Container c,int x,int y,int type)
    {
        //Label properties
        this.setName("stone");
        c.add(this);
        this.setLocation(x,y);
        setLayout(null);
        
        //setting image
        if(type==SMALL)     //For small stone
        {
            l= new JLabel(stone_small);
            l.setBounds(0,0,60,78);
            setSize(60,78);
        }
        else                 //For big stone
        {
            l= new JLabel(stone_big);
            l.setBounds(0,0,86,80);
            setSize(86,80);
        }
        this.add(l);
     }
}
