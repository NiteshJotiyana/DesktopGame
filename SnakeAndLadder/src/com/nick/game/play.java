package com.nick.game;

import java.awt.event.*;

class play implements MouseListener,Runnable
{
	private start s;
	private static final String info[] ={"'s turn"," click on your symbol"};
	public int current=-1,next=0;
	private Thread thread;
	Game g;
	int mes;
	play(start s,Game g)
	{
		this.g=g;
		this.s=s;
		s.cb.addMouseListener(this);
	}
	public void change(int x)
	{	
		int no = s.cb.getCurrentNumber();
		if (next==x+1)
		{
			next=0;
			current++;
		}
		else if (current==x+1)
		{
			current=0;
			next++;
		}
		else
		{
			next++;
			current++;	
		}
	
		if (s.gs.sym[current].isVisible()==false)
		{
			if (no==6|no==1)
			{
				s.gs.sym[current].setVisible(true);
				g.open(current);
				//s.c.sg.p[current+6].setText("1");
			}
			
			s.c.info.setText(s.c.ps.tf[next].getText()+info[0]);
		}
		else if (s.gs.sym[current].isVisible()==true)
		{
			s.c.sg.p[current+6].setText(""+((int)Integer.parseInt(s.c.sg.p[current+6].getText())+no));
			s.c.info.setText(s.c.ps.tf[current].getText()+info[1]);
			s.cb.removeMouseListener(s.cb);
			s.cb.removeMouseListener(s.p);
			s.c.b1.removeMouseListener(s.c);
			s.c.b3.removeMouseListener(s.c);
			s.c.b4.removeMouseListener(s.c);
			s.c.b5.removeMouseListener(s.c);
			
			s.gs.sym[current].addMouseListener(s.gs);
			s.gs.sym[current].addMouseMotionListener(s.gs);
		
			mes = (int)Integer.parseInt(s.c.sg.p[current+6].getText());
			System.out.println(""+mes);
				if (mes==8)
				{
					s.c.sg.p[current+6].setText("31");
					g.laderAction();
				}
				if (mes==15)
				{
					s.c.sg.p[current+6].setText("97");
					g.laderAction();
				}
				if (mes==42)
				{
					s.c.sg.p[current+6].setText("81");
					g.laderAction();
				}
				if (mes==66)
				{
					s.c.sg.p[current+6].setText("87");
					g.laderAction();
				}
				//for snake
				if (mes==24)
				{
					s.c.sg.p[current+6].setText("1");
					g.snakeAction();
				}
				if (mes==55)
				{
					s.c.sg.p[current+6].setText("13");
					g.snakeAction();

				}
				if (mes==71)
				{
					s.c.sg.p[current+6].setText("29");
					g.snakeAction();	
				}
				if (mes==99)
				{
					s.c.sg.p[current+6].setText("6");
					g.snakeAction();
				}
				if (mes==88)
				{
					s.c.sg.p[current+6].setText("67");
					g.snakeAction();
				}
				
				if (mes==100)
				{	
					g.win();
					s.c.b1.addMouseListener(s.c);
					s.c.b3.addMouseListener(s.c);
					s.c.b4.addMouseListener(s.c);
					s.c.b5.addMouseListener(s.c);
						
					s.gs.sym[0].removeMouseListener(s.gs);
					s.gs.sym[1].removeMouseListener(s.gs);
					s.gs.sym[2].removeMouseListener(s.gs);
					s.gs.sym[3].removeMouseListener(s.gs);
				}	
		}
		
	}
	public void run()
	{
			try
			{
				s.c.b3.removeMouseListener(s.c);
				s.c.b4.removeMouseListener(s.c);
				s.c.b5.removeMouseListener(s.c);
				long speed = s.cb.getMovingSpeed();
				thread.sleep(speed*650);
				s.c.b3.addMouseListener(s.c);
				s.c.b4.addMouseListener(s.c);
				s.c.b5.addMouseListener(s.c);
				int type =s.c.ps.getSelectedItem();
				change(type);			
			}
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
	}	
	
	public void mouseClicked(MouseEvent me)
	{		
		Object o = me.getSource();
		{
			if (o==s.cb)
			{
				thread = new Thread(this,"com.nick.game.play");
				thread.start();
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
