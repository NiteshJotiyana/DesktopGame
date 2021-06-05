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
 * @author Nitesh
 */
public class Grass extends JLabel
{
    //private member
    private Icon grass_icon = new ImageIcon(Constants.imageFolder+"grass1.png");
    private JLabel l;
   
    //Counstructor
    public Grass(Container c,int x,int y)
    {
        //Label properties
        this.setName("grass");
        c.add(this);
        this.setLocation(x,y);
        setLayout(null);
        setSize(198,100);
        
        //setting image
        l= new JLabel(grass_icon);
        this.add(l);
        l.setBounds(0,0,198,100);
    }
}
