/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;
//Java Package
import javax.swing.*;
import java.awt.*;

//Customized package
import control.*;
import items.*;
/**
 *
 * @author Nitesh
 */
public class Main extends JFrame implements Runnable
{
    //public member
    public JLabel tree;
    public Basket b;
    public JPanel p;

    public Layout e;
    public Apple a;
    
     //private 
    private Stone s[]= new Stone[3];
    private JLabel basket;
    private Thread t;
    private Grass g[]= new Grass[5];
    private Mushroom m[]=new Mushroom[3];
    private JLabel bird; 
    private int time=2000;
    
    //Image Icon
    Icon oak_tree = new ImageIcon(Constants.imageFolder+"oaktree2.jpg");
    Icon red_bird = new ImageIcon(Constants.imageFolder+"red_bird.gif");
    
    //Counstructor
    Main(){
        //Main Panel Properties
        p= new JPanel();
        add(p);
        p.setLayout(null);
        p.setBackground(Color.white);
        
        //Tree Properties
        tree = new JLabel(oak_tree);
        tree.setBounds(0,0,600,700);
        p.add(tree);
        tree.setName("tree");
        
        //control
        e =new Layout(this);
              
        //basket
        b= new Basket(this,300,600);


       //grass
        g[0]= new Grass(tree,0,600);
        g[1]= new Grass(tree,10,580);
        g[2]= new Grass(tree,100,620);
        g[3]= new Grass(tree,300,580);
        g[4]= new Grass(tree,330,600);
            
        //mushroom
        m[0]= new Mushroom(tree,140,600,Mushroom.SMALL);
        m[1]= new Mushroom(tree,450,600,Mushroom.SMALL);
        m[2]= new Mushroom(tree,170,575,Mushroom.BIG);
        
        //stone
        s[0] = new Stone(tree,10,550,Stone.BIG);
        s[1]= new Stone(tree,50,550,Stone.SMALL);
        s[2] = new Stone(tree,500,600,Stone.BIG);
        
        //bird
        bird = new JLabel(red_bird);
        tree.add(bird);
        bird.setBounds(500,600,86,70);
        
        //Thread Properties
        t = new Thread(this,"low");
        t.start();
        
        //Frame Properties
        setVisible(true);
	setSize(1030,800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        startNewGame();
    }

    public void startNewGame()
    {

        for(int i=0;i<10;i++)
        {
            try {
                t.sleep(time);
                if(i%5==0)
                    a= new Apple(this,300,200,10);
                else if(i%3==0)
                    a= new Apple(this,100,250,20);
                else if(i%2==0)
                    a= new Apple(this,450,300,15);
                else if(i%1==0)
                    a= new Apple(this,150,100,8);
            } catch (InterruptedException e) {
                System.out.println("child thread interrupted"+e);
            }
        }
    }
    public static void main(String[] args) 
    {
       new Main();
       System.out.println(MouseInfo.getNumberOfButtons());
    }
}
