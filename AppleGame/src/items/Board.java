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
public class Board extends Panel
{
    private JLabel border[]= new JLabel[4];
    private JLabel leg[]= new JLabel[4];
    private JPanel sheet;
    private Icon bamboo_v = new ImageIcon(Constants.imageFolder+"bamboo_v.jpg");
    private Icon bamboo_h_u = new ImageIcon(Constants.imageFolder+"bamboo_h_u.jpg");
    private Icon bamboo_h_b = new ImageIcon(Constants.imageFolder+"bamboo_h_b.jpg");
    private Color cream = new Color(239,228,176);
    private Grass g;
    public JLabel text;
    private JLabel apple;
    
    //Counstructor
    public Board(Container c,int x,int y)
    {
      
      sheet = new JPanel();
      this.add(sheet);
      sheet.setLayout(null);
      sheet.setBounds(0,0,149,147);
      sheet.setBackground(cream);
      
      for(int i=0;i<2;i++)
      {
        leg[i]= new JLabel(bamboo_v);
        sheet.add(leg[i]);
        border[i] = new JLabel(bamboo_v);
        sheet.add(border[i]);
      }
      
      border[2] = new JLabel(bamboo_h_u);  
      sheet.add(border[2]);
      border[3] = new JLabel(bamboo_h_b);
      sheet.add(border[3]);
      
      leg[0].setBounds(40,115,11,100);
      leg[1].setBounds(90,130,11,100);
      
      border[0].setBounds(0,5,11,100);
      border[1].setBounds(139,38,11,100);
      border[2].setBounds(10,0,139,49);
      border[3].setBounds(0,98,139,49);
      
      //grass 
      g = new Grass(this,0,150);
      
      //text
      text = new JLabel("0");
      sheet.add(text);
      text.setBounds(80,10,100,100);
      
      //apple
      Icon apple_small= new ImageIcon(Constants.imageFolder+"apple_small.gif");
      apple= new JLabel(apple_small);
      sheet.add(apple);
      apple.setBounds(20,10,80,100);
      //legs
      for(int i=2;i<4;i++)
      {
          leg[i] = new JLabel(bamboo_v);
          this.add(leg[i]);
      }
      leg[2].setBounds(40,147,11,80);
      leg[3].setBounds(90,147,11,110);
      
      //board properties
      setLayout(null);
      setSize(149,270);  
      c.add(this);
      this.setLocation(x,y);
    }
}
