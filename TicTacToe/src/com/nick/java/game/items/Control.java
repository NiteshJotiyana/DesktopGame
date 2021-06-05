package com.nick.java.game.items;

import com.nick.java.game.runner.StartTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control extends JPanel implements MouseListener
{
	//variables
	JLabel l[] = new JLabel[5];
	public int counter1,counter2;
	//image 
	Icon demo = new ImageIcon(Constants.resourceFolder+"/images/pic.gif");		//Big Picture
	JLabel pic = new JLabel(demo);
	//new game 
	Button b = new Button("New game");

	//creating font
	Font century = new Font("Century",Font.BOLD,20);
	Font kristen = new Font("Kristen ITC",Font.BOLD,25);
	Font kristen_big = new Font("Kristen ITC",Font.BOLD,30);

	//options of different variables
	String levelSt[]={"Easy Level","Hard Level","Expert Level"};
	String playerSt[]={"User vs Comp","User1 vs user2"};
	StartTicTacToe s;

	//counstructor
	public Control(StartTicTacToe s)
	{
		this.s =s;
		l[0] = new JLabel(levelSt[counter1]);
		l[1] = new JLabel(playerSt[counter2]);
		l[2] = new JLabel("New Game");
		l[3] = new JLabel("");
		l[4] = new JLabel("");
		for(int i=0;i<5;i++)
		{
			l[i].setForeground(Color.blue);
			l[i].setFont(kristen);
			
			add(l[i]);
			l[i].addMouseListener(this);
	
	
		}

		l[0].setBounds(50,200,250,40);
		l[1].setBounds(50,250,250,40);
		l[2].setBounds(50,300,250,40);
		//setting button
		//add(b);
		b.setLocation(50,400);
		b.addMouseListener(this);
		//setting pic	
		add(pic);
		pic.setBounds(0,0,300,225);
		
		//setting panel
		setBackground(Color.black);
		setSize(500,800);
		setLayout(null);
	}

	//Mouselistener Methods
	public void mouseClicked(MouseEvent me)
	{
		
		Object o = me.getSource();
		if(o==l[2])
		{
			s.clear();
		}
		if(o==b)
		{
			s.clear();
		}
		if(o==l[0])
		{	
			counter1++;
			if(counter1==3)
				counter1=0;
		
			l[0].setText(levelSt[counter1]);
		}
		if(o==l[1])
		{	
			counter2++;
			if(counter2==2)
				counter2=0;
		
			l[1].setText(playerSt[counter2]);
			s.setPlayer(counter2+1);
		}
	}
	public void mouseEntered(MouseEvent me)
	{
		Object o = me.getSource();
		for(int i=0;i<5;i++)
		{
			if(o==l[i])
			{	
				l[i].setFont(kristen_big);
				l[i].setForeground(Color.red);
			}
		}
	}
	public void mouseExited(MouseEvent me)
	{
		Object o = me.getSource();
		for(int i=0;i<5;i++)
		{
			if(o==l[i])
			{	
				l[i].setFont(kristen);
				l[i].setForeground(Color.blue);
			}
		}
	}
	public void mousePressed(MouseEvent me)
	{
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void actionPerformed(ActionEvent ae)
	{	
	}
	

}