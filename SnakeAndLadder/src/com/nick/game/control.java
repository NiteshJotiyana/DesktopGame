package com.nick.game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class control extends JPanel implements MouseListener 
{
	button b1,b2,b3,b4,b5,b6;
	JLabel pic,info;
	JPanel main;
	public startGame sg;
	public Players ps;
	public option op;
	private start s;
	private theme t;
	Game g;
	control(theme t,start s,Game g)
	{
		this.s=s;
		this.t=t;
		this.g=g;
		main = new JPanel();
		sg = new startGame(t,s);
		ps = new Players(t,s);
		op = new option(s,t);
		info = new JLabel("Welcome to Snake&Lader");

		//current Panel
		setBackground(t.green);
		setLayout(null);
	
		b1 = new button("Start game");			//Different Buttons
		b2 = new button("New game");
		b3 = new button("   Player");
		b4 = new button("   Option");
		b5 = new button("    Help");
		b6 = new button("    Exit");
		
		Icon demo = new ImageIcon(Constants.resourcesFolder+"/images/demo.gif");		//Big Picture
		pic = new JLabel(demo);
		
		b1.setLocation(20,400);						//Different Buttons
		b2.setLocation(20,450);
		b3.setLocation(20,500);
		b4.setLocation(20,550);
		b5.setLocation(20,650);
		b6.setLocation(250,650);
		
		pic.setBounds(25,20,342,300);				//BigPicture
		info.setBounds(30,350,340,20);
		info.setFont(t.century);
		info.setForeground(t.yellow);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(pic);
		add(main);
		add(info);
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		b4.addMouseListener(this);
		b5.addMouseListener(this);
		b6.addMouseListener(this);
		
		//main Panel
		main.setLayout(new CardLayout());
		main.setBounds(150,400,200,200);
		main.add(sg,"start");
		main.add(ps,"player");
		main.add(op,"option");
		
		setSize(380,700);
	}
	public void mouseClicked(MouseEvent me)
	{
		Object o = me.getSource();
		CardLayout c1 = (CardLayout)(main.getLayout());
		if (o==b1)
		{
			c1.show(main,"start");
			s.cb.setVisible(true);
		
			sg.p[2].setText(ps.tf[0].getText());
			sg.p[3].setText(ps.tf[1].getText());
			sg.p[4].setText(ps.tf[2].getText());
			sg.p[5].setText(ps.tf[3].getText());
			
			if (ps.rb[0].isSelected()==true)
			{
				int x =s.cb.getClickCount();
				sg.p[4].setVisible(false);
				sg.p[5].setVisible(false);
				sg.p[8].setVisible(false);
				sg.p[9].setVisible(false);
				info.setText(ps.tf[s.p.next].getText()+"'s turn");
				ps.rb[1].setVisible(false);
				ps.rb[2].setVisible(false);
			}
			if (ps.rb[1].isSelected()==true)
			{
				sg.p[4].setVisible(true);
				sg.p[5].setVisible(false);
				sg.p[8].setVisible(true);
				sg.p[9].setVisible(false);
				info.setText(ps.tf[s.p.next].getText()+"'s turn");
				ps.rb[0].setVisible(false);
				ps.rb[2].setVisible(false);	
			}
			if (ps.rb[2].isSelected()==true)
			{
				for (int i=0;i<=9;i++ )
				{
					sg.p[i].setVisible(true);
				}
				info.setText(ps.tf[s.p.next].getText()+"'s turn");
				ps.rb[0].setVisible(false);
				ps.rb[1].setVisible(false);
			}	
		}
		if (o==b2)
		{
			s.p.current=-1;
			s.p.next=0;
			s.p.mes=0;
			s.cb.setVisible(false);
			
			s.cb.addMouseListener(s.cb);
			s.cb.addMouseListener(s.p);
			for (int i=0;i<4;i++ )
			{
				s.gs.sym[i].setVisible(false);
				sg.p[i+6].setText("0");
			}
			s.gs.sym[0].setLocation(10,560);
			s.gs.sym[1].setLocation(40,560);
			s.gs.sym[2].setLocation(10,590);
			s.gs.sym[3].setLocation(40,590);
			
			ps.rb[0].setVisible(true);
			ps.rb[1].setVisible(true);
			ps.rb[2].setVisible(true);
			
			s.c.b1.addMouseListener(s.c);
			s.c.b3.addMouseListener(s.c);
			s.c.b4.addMouseListener(s.c);
			s.c.b5.addMouseListener(s.c);
			
			info.setText(ps.tf[0].getText()+"'s turn");
		}
		if (o==b3)
		{
			c1.show(main,"player");
			s.cb.setVisible(false);
		}
		if (o==b4)
		{
			c1.show(main,"option");
			s.cb.setVisible(false);
		}
		if (o==b5)
		{
			c1.show(main,"help");
		}
		if (o==b6)
		{
			//System.exit(0);
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
