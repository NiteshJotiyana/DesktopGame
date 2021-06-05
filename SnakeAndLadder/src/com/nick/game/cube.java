package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class cube extends JPanel implements MouseListener,Runnable
{
	private int a,size;
	private long time;
	private Color mainColor;
	private int click;
	private Thread thread1;

	//Cunstructer
	cube()
	{	
		size=48;
		time=5;
		mainColor = Color.lightGray;
		setSize(size,size);
		this.addMouseListener(this);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRoundRect(3,3,size,size,20,20);
		g.setColor(mainColor);
	
		g.fillRoundRect(0,0,size-3,size-3,10,10);
		
		int x[] ={20,5,35,35,5,};
		int y[] ={20,5,35,5,35};
		int x6[] ={10,30,10,30,10,30};
		int y6[] ={10,10,20,20,30,30};
		
		for (int i=0;i<a;i++ )
		{
			int px=0,py=0;
			if (a<=5)
			{
				px = x[i];
				py = y[i];
			}
			if (a==6)
			{
				px = x6[i];
				py = y6[i];
			}
			g.setColor(Color.black);
			g.fillOval(px,py,5,5);
		}
	}
	public void run()
	{
		for (int i=0,j=600;i<600;i++,j--)
		{	
			try
			{
				thread1.sleep(time);
				if (i<300)
				{	
					setLocation(700,400-i);
				}
				else if(i>300) 
				{
					setLocation(700,400-j);
				}
				if (i%60==0)
				{
						number();
						repaint(1000);
				}		
			}
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
		}
	}
	private void number()
	{
		a = (int)(10*Math.random());
		if (a>0&a<7)
		{	
		}
		else
		{
			number();	
		}
	}
	
	
	//class methods
	public int getCurrentNumber()
	{
		return a;
	}
	public void setCurrentNumber(int a)
	{
		this.a=a;
		repaint();
	}
	public int getClickCount()
	{
		return click;
	}
	public long getMovingSpeed()
	{
		return time;
	}
	public void setMovingSpeed(long time)throws Exception
	{
		Exception ae = new Exception("You have passed illigle time");
		if (time<0|time>20)
		{
			throw ae;
		}
		this.time=time;
		repaint();
	}
	public void setColor(Color color)
	{
		this.mainColor=color;
		repaint();
	}
	public Color getColor()
	{
		return(mainColor);
	}

	//MouseListener methods
	public void mouseClicked(MouseEvent me)
	{
		thread1 = new Thread(this,"cube1");
		thread1.start();
		click++;
	}
	public void mouseEntered(MouseEvent me)
	{
		setColor(Color.white);
	}
	public void mouseExited(MouseEvent me)
	{
		setColor(Color.white);
	}
	public void mousePressed(MouseEvent me)
	{
		setColor(Color.pink);
	}
	public void mouseReleased(MouseEvent me)
	{
		setColor(Color.white);
	}
}
					