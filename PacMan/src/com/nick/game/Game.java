package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements Runnable,KeyListener
{
	Thread thread;
	JPanel main;
	int x,y,temp;
	PacMan m;
	public Game()
	{
		thread = new Thread(this,"low");
		thread.start();
		main = new JPanel();
		
		setLayout(null);
		main.setLayout(null);
		main.setBackground(Color.yellow);
		m = new PacMan();
		m.setLocation(30,30);
		main.setBounds(0,0,1280,770);
		add(main);
		main.add(m);
		//setResizable(false);
		setVisible(true);
		setSize(1280,770);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	public void paint(Graphics g)
	{
		System.out.println("hello");
	}
	public void run()
	{
		for (int count=1;count>0;count++)
		{	
			try
			{
				thread.sleep(10);
				if (temp==0)
				{
					moveLeft();
				}
				if (temp==1)
				{
					moveDown();
				}
				if (temp==2)
				{
					moveRight();
				}
				if (temp==3)
				{
					moveUp();
				}
			}
			
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
		}
	}
	public void moveLeft()
	{
		m.x=-35;
		Point p = m.getLocation();
		int k = (int)p.getX();
		int l = (int)p.getY();
		k=k+2;
		m.setLocation(k,l);	
		if (k==1100)
		{
			temp=1;
		}
	}
	public void moveRight()
	{
		m.x=145;	
		Point p = m.getLocation();
		int k = (int)p.getX();
		int l = (int)p.getY();
		k=k-2;
		m.setLocation(k,l);
		if (k==50)
		{
			temp=3;
		}
	}
	public void moveDown()
	{
		m.x=-125;
		Point p = m.getLocation();
		int k = (int)p.getX();
		int l = (int)p.getY();
		l=l+2;
		m.setLocation(k,l);					
		if (l==650)
		{
			temp=2;
		}
	}
	public void moveUp()
	{
		m.x=55;
		Point p = m.getLocation();
		int k = (int)p.getX();
		int l = (int)p.getY();
		l=l-2;
		m.setLocation(k,l);
		if (l==50)
		{
			temp=0;
		}
		
	}
	public void keyPressed(KeyEvent ke)
	{
		Point p = m.getLocation();
		int k = (int)p.getX();
		int l = (int)p.getY();
		
		int code =ke.getKeyCode();
		if (code==38)		//key up
		{
			temp=3;
		}
		if (code==40)		//key down
		{
			temp=1;
		}
		if (code==37)		//key left
		{
			temp=2;
		}
		if (code==39)		//key right
		{
			temp=0;
		}
	
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	
	public static void main(String[] args) 
	{
		new Game();
	}
}
