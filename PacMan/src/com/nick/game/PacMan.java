package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacMan extends JLabel implements Runnable
{
	int i,x=-35;
	Thread thread;
	public PacMan()
	{
		
		thread = new Thread(this,"hello");
		thread.start();
		
		setSize(50,50);
	}

	public void paint(Graphics g)
	{
		if (i==1)
		{
			img2(g);
		}
		else if (i==0)
		{
			img1(g);
		}
		
	}
	public void run()
	{
		for (int j=1;j>0;j++)
		{	
			try
			{
				thread.sleep(300);
				if (i==1)
				{
					i=0;
				}
				else
				{
					i=1;
				}
				repaint();		
			}
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
		}
	}
	public void img1(Graphics g)
	{
		g.setColor(Color.green);
		g.fillOval(0,0,45,40);
	}
	public void img2(Graphics g)
	{
		g.setColor(Color.green);
		g.fillOval(0,0,45,40);
		g.setColor(Color.yellow);
		g.fillArc(0,0,45,40,x,70);
	}
}
