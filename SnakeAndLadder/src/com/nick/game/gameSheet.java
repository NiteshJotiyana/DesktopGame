package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class gameSheet extends JPanel implements MouseListener,MouseMotionListener
{
	symbol sym[] = new symbol[4];
	JLabel main;
	private JLabel l[] = new JLabel[4];
	private JLabel key = new JLabel("");
	private int click;
	private start s;
	private final Icon HBorder = new ImageIcon(Constants.resourcesFolder+"/images/newHBorder3.gif");
	private final Icon VBorder = new ImageIcon(Constants.resourcesFolder+"/images/newVBorder3.gif");
	private final Icon gameSheet = new ImageIcon(Constants.resourcesFolder+"/images/gameSheet.gif");
	
	gameSheet(theme t,start s)
	{
		this.s=s;
		//making of instance
		sym[0]= new symbol(t.g1);
		sym[1]= new symbol(t.g2);
		sym[2]= new symbol(t.g3);
		sym[3]= new symbol(t.g4);

		l[0] = new JLabel(HBorder);
		l[1] = new JLabel(HBorder);
		l[2] = new JLabel(VBorder);
		l[3] = new JLabel(VBorder);

		main = new JLabel(gameSheet);
		
		//setting of main
		main.setLayout(null);
		for (int i=0;i<4;i++)
		{
			main.add(sym[i]);
			sym[i].setVisible(false);
		}
		sym[0].setLocation(10,560);
		sym[1].setLocation(40,560);
		sym[2].setLocation(10,590);
		sym[3].setLocation(40,590);
		
		//setting of class
		setLayout(new BorderLayout());
		add(l[0],BorderLayout.NORTH);
		add(l[1],BorderLayout.SOUTH);
		add(l[2],BorderLayout.EAST);
		add(l[3],BorderLayout.WEST);
		add(main,BorderLayout.CENTER);
		setSize(628,650);	
		
		//adding Listeners
		key.addMouseListener(this);
		key.addMouseMotionListener(this);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);	
	}
	public void mouseClicked(MouseEvent me)
	{	
		Object o = me.getSource();
		for (int i=0;i<4;i++)
		{
			if (o==sym[i]&click==0)
			{
				s.c.info.setText("Click to place it");
				key=sym[i];
				click=1;
				Cursor c = new Cursor(12);
				setCursor(c);
				break;
			}
		}
		if (o==this&click==1)
		{
			int x =me.getX();
			int y =me.getY();
			key.setLocation(x,y);
			s.c.info.setText(s.c.ps.tf[s.p.next].getText()+"'s turn");
			key=new JLabel("");
			click=0;
			Cursor c = new Cursor(0);
			setCursor(c);
			s.c.b1.addMouseListener(s.c);
			s.c.b3.addMouseListener(s.c);
			s.c.b4.addMouseListener(s.c);
			s.c.b5.addMouseListener(s.c);
			
			s.cb.addMouseListener(s.cb);
			s.cb.addMouseListener(s.p);
			sym[s.p.current].removeMouseListener(this);
			sym[s.p.current].removeMouseMotionListener(this);
		}
	}
	public void mouseMoved(MouseEvent me)
	{
		Object o = me.getSource();
		int x =me.getX();
		int y =me.getY();
					
		if (o==this)
		{
			key.setLocation(x,y);
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
	public void mouseDragged(MouseEvent me)
	{	
	}
}
/*
for(int count=0,j=560;j>=20;j-60,count++)
{
	for(int i=10;i<550;)
	{
		setLocation(j,i);
		if(count%2==0)
		{
			i=i+60;
		}
		else
		{
			i=i-60;
		}
	}
}
for(int i=40;i<590;i+60)
{
	for(int j=560;j>=20;j-60)
}
*/
