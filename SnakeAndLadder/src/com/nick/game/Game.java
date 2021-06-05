package com.nick.game;

import java.awt.event.*;
import java.applet.*;
/*
<Applet Code = game.class Width=1280 height =770>
</Applet>
*/

public class Game extends Applet implements MouseListener,Runnable
{
	Thread thread;
	start s;
	public void init()
	{	
		try
		{
			s = new start(this);	
			s.setBounds(0,0,1280,770);
			add(s);
			//s.c.b1.addMouseListener(this);
			//s.c.b2.addMouseListener(this);
			//s.c.b3.addMouseListener(this);
			//s.c.b4.addMouseListener(this);
			//s.c.b5.addMouseListener(this);
			//s.c.b6.addMouseListener(this);
			//s.snake.j2.addMouseListener(this);
			this.setLayout(null);
		}
		catch (Exception e)
		{
			System.out.println("Error"+e);
		}
		thread = new Thread(this,"low");
		thread.start();
		
		
		}
	public void open(int i)
	{
		play(getCodeBase(), Constants.resourcesFolder+"/audio/yahoo2.au");
	}
	public void snakeAction()
	{
		play(getCodeBase(), Constants.resourcesFolder+"/audio/snake.au");
	}
	public void laderAction()
	{
		play(getCodeBase(), Constants.resourcesFolder+"/audio/lader.au");
	}
	public void win()
	{
		play(getCodeBase(), Constants.resourcesFolder+"/audio/lader.au");
	}
	public void run()
	{
		for (int i=1;i>0;i++)
		{	
			try
			{
				play(getCodeBase(), Constants.resourcesFolder+"/audio/backsound2.au");
				thread.sleep(100000);
			}
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		Object o= me.getSource();
		if ((o==s.c.b1)|(o==s.c.b3)|(o==s.c.b4)|(o==s.c.b5))
		{
			play(getCodeBase(), Constants.resourcesFolder+"/audio/click2.au");
		}
		if (o==s.c.b2)
		{
			play(getCodeBase(), Constants.resourcesFolder+"/audio/click.au");
		}
		if (o==s.snake.j2)
		{
			if (s.snake.password.equals("game32"))
			{
				play(getCodeBase(), Constants.resourcesFolder+"/audio/enter.au");
			}
			else
			{

				play(getCodeBase(), Constants.resourcesFolder+"/audio/danger.au");
			}	
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
