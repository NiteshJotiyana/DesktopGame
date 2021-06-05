package com.nick.game;

import java.awt.event.*;
import javax.swing.*;

class option extends JPanel implements ItemListener,ActionListener
{
	JLabel l;
	JRadioButton b[]= new JRadioButton[3];
	JButton button;
	private start s;
	private theme t;
	private ButtonGroup bg = new ButtonGroup();

	option(start s,theme t)
	{
		this.s = s;
		this.t = t;
	
		l= new JLabel("Select Theme :");
		button = new JButton("Advanced Setting");
		
		b[0]= new JRadioButton("Theme1");
		b[1]= new JRadioButton("Theme2");
		b[2]= new JRadioButton("Theme3");
				
		//setting RadioButton properties
		b[0].setSelected(true);
		for (int i=0;i<3;i++)
		{
			add(b[i]);
			bg.add(b[i]);
			b[i].setBackground(t.green);
			b[i].setForeground(t.yellow);
			b[i].setFont(t.century);		
			b[i].addItemListener(this);
		}
		b[0].setBounds(10,40,100,15);
		b[1].setBounds(10,70,100,15);
		b[2].setBounds(10,100,100,15);
		button.setBounds(10,150,150,20);
		button.addActionListener(this);
		//setting label properties
		l.setBounds(10,10,200,15);
		l.setFont(t.century);		

		//setting class 
		setLayout(null);
		setBackground(t.green);
		add(l);
		add(button);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		Object o = ie.getSource();
		if (o==b[0])
		{
			s.main.setBackground(t.light_green);
			s.c.setBackground(t.green);
			s.c.sg.setBackground(t.green);
			s.c.ps.setBackground(t.green);
			s.c.op.setBackground(t.green);
			for (int i=0;i<3;i++ )
			{
				s.c.ps.rb[i].setBackground(t.green);
				s.c.op.b[i].setBackground(t.green);
			}
			for (int i=0;i<4;i++ )
			{
				s.c.ps.tf[i].setBackground(t.light_green);
			}
		}
		if (o==b[1])
		{
			s.main.setBackground(t.pink);
			s.c.setBackground(t.dark_pink);
			s.c.sg.setBackground(t.dark_pink);
			s.c.ps.setBackground(t.dark_pink);
			s.c.op.setBackground(t.dark_pink);
			for (int i=0;i<3;i++ )
			{
				s.c.ps.rb[i].setBackground(t.dark_pink);
				s.c.op.b[i].setBackground(t.dark_pink);
			}
			for (int i=0;i<4;i++ )
			{
				s.c.ps.tf[i].setBackground(t.pink);
			}
		}
		if (o==b[2])
		{
			s.main.setBackground(t.yellow);
			s.c.setBackground(t.dark_yellow);
			s.c.sg.setBackground(t.dark_yellow);
			s.c.ps.setBackground(t.dark_yellow);
			s.c.op.setBackground(t.dark_yellow);
			for (int i=0;i<3;i++ )
			{
				s.c.ps.rb[i].setBackground(t.dark_yellow);
				s.c.op.b[i].setBackground(t.dark_yellow);
			}
			for (int i=0;i<4;i++ )
			{
				s.c.ps.tf[i].setBackground(t.dark_yellow);
			}
			
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==button)
		{
			advanceSetting ac = new advanceSetting();
			ac.setVisible(true);
		}
	}
}
