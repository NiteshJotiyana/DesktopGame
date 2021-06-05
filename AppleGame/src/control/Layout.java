/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import game.*;
import items.*;
/**
 *
 * @author Nitesh
 */
public class Layout extends JPanel implements MouseListener
{
    public  Board b;
    
    private Main m;
    private JLabel leaves;
    private JLabel rope[]= new JLabel[3];
    private JLabel bamboo[]= new JLabel[4];
    private Nest nest[]= new Nest[3];
    private JLabel nest_rope[]= new JLabel[3];
    private JLabel  basket[]= new JLabel[2];
    private Grass g;
    
    //Constructor
    public Layout(Main m)
    {
        //properties
        this.m=m;
        m.p.add(this);
        this.setLocation(600,0);
        this.setBackground(Color.white);
       
        //tree leaves
        Icon leaves_icon = new ImageIcon(Constants.imageFolder+"leaves.jpg");
        leaves = new JLabel(leaves_icon);
        this.add(leaves);
        leaves.setBounds(50,0,459,161);
        
        //board
        b = new Board(this,250,400);
       
         //rope
        Icon rope_icon = new ImageIcon(Constants.imageFolder+"rope.gif");
        for(int i=0;i<3;i++)
        {
            rope[i]=new JLabel(rope_icon); 
            this.add(rope[i]);
            leaves.add(rope[i]);
        }
        rope[0].setBounds(100,140,13,200);
        rope[1].setBounds(200,140,13,200);
        rope[2].setBounds(300,140,13,200);
        
        //nest rope 
         for(int i=0;i<3;i++)
        {
            nest_rope[i]=new JLabel(rope_icon); 
            this.add(nest_rope[i]);
           
        }
        nest_rope[0].setBounds(150,140,13,200);
        nest_rope[1].setBounds(250,140,13,150);
        nest_rope[2].setBounds(350,140,13,90);
        
        //nest
        nest[0]= new Nest(this,100,330);
        nest[1]= new Nest(this,200,280);
        nest[2]= new Nest(this,300,220);
        
        nest[0].setInfo("new Game");
        nest[1].setInfo("play");
        nest[2].setInfo("option");
        
        //basket
        g= new Grass(this,50,610);
        Icon basket_icon= new ImageIcon(Constants.imageFolder+"apple_basket.jpg");
        for(int i=0;i<2;i++)
        {
             basket[i]= new JLabel(basket_icon);
             this.add(basket[i]);
        }
       basket[0].setBounds(20,600,90,84);
       basket[1].setBounds(100,580,90,84);
       
        //panel properties
        this.setLayout(null);
        this.setVisible(true);
        setSize(400,800);
        nest[0].addMouseListener(this);
    }
     public void mouseClicked(MouseEvent me)
    {	
       Object o= me.getSource();
       if(o==nest[0])
       {
           m.tree.setVisible(true);

       }
    }
    public void mouseEntered(MouseEvent me)
    {
       
            
    }
    public void mouseExited(MouseEvent me)
    {
       
       
    }
    public void mousePressed(MouseEvent me)
    {
    }
    public void mouseReleased(MouseEvent me)
    {
    }
   
}
