package com.nick.game;

import java.awt.event.*;
import javax.swing.*;

class Players extends JPanel implements ItemListener,FocusListener
{
	JLabel play[] = new JLabel[6];
	JRadioButton rb[] = new JRadioButton[3];
	JTextField tf[] =new JTextField[4];
	start s;
	Players(theme t,start s)
	{
		this.s=s;
		setLayout(null);
		setBackground(t.green);
		play[0] = new JLabel("Select Number Of Players");
		play[1] = new JLabel(s.gs.sym[0].getImage());
		play[2] = new JLabel(s.gs.sym[1].getImage());
		play[3] = new JLabel(s.gs.sym[2].getImage());
		play[4] = new JLabel(s.gs.sym[3].getImage());
		play[5] = new JLabel("");

		rb[0] = new JRadioButton("Two");
		rb[1] = new JRadioButton("Three");
		rb[2] = new JRadioButton("Four");
		
		tf[0] = new JTextField("Player1",10); 
		tf[1] = new JTextField("Player2",10); 
		tf[2] = new JTextField("Player3",10); 
		tf[3] = new JTextField("Player4",10); 
		play[0].setFont(t.century1);
		ButtonGroup bg = new ButtonGroup();
		
		for (int i=0;i<=2;i++ )
		{
			add(rb[i]);
			bg.add(rb[i]);
			rb[i].setBackground(t.green);
			rb[i].setForeground(t.yellow);
			rb[i].setFont(t.century1);
			rb[i].addItemListener(this);
		}
		rb[0].setSelected(true);
		for (int i=0;i<4;i++ )
		{
			add(tf[i]);
			tf[i].setBackground(t.light_green);
			tf[i].setForeground(t.yellow);
			tf[i].setFont(t.century);
			tf[i].addFocusListener(this);
		}
	
		for (int i=0;i<6;i++)
		{	
			add(play[i]);
		}
		play[0].setForeground(t.black);
		play[0].setBounds(10,10,200,15);		
		play[1].setBounds(10,80,90,20);
		play[2].setBounds(10,110,90,20);
		play[3].setBounds(10,140,90,20);
		play[4].setBounds(10,170,90,20);

		rb[0].setBounds(10,40,70,15);
		rb[1].setBounds(80,40,70,15);
		rb[2].setBounds(150,40,70,15);
		
		tf[0].setBounds(100,80,90,20);	
		tf[1].setBounds(100,110,90,20);	
		tf[2].setBounds(100,140,90,20);	
		tf[3].setBounds(100,170,90,20);	
		
		tf[2].setVisible(false);
		tf[3].setVisible(false);
		play[3].setVisible(false);
		play[4].setVisible(false);
		
	}
	public int getSelectedItem()
	{
		int i=0;
		for (;i<3;i++)
		{
			if (rb[i].isSelected()==true)
			{
				break;
			}
		}
		return i;
	}
	public void itemStateChanged(ItemEvent ie)
	{
		Object o = ie.getSource();
		if (o==rb[0])
		{
			tf[2].setVisible(false);
			tf[3].setVisible(false);
			play[3].setVisible(false);
			play[4].setVisible(false);
		}
		if (o==rb[1])
		{
			tf[2].setVisible(true);
			tf[3].setVisible(false);
			play[3].setVisible(true);
			play[4].setVisible(false);
		}
		if (o==rb[2])
		{
			for (int i=0;i<4;i++ )
			{
				tf[i].setVisible(true);
				play[i+1].setVisible(true);
			}
		}
	}
	public void focusGained(FocusEvent fe)
	{
		Object o = fe.getSource();
		
		for (int i=0;i<4;i++ )
		{
			if (o==tf[i])
			{
				tf[i].selectAll();
			}
		}
	}
	public void focusLost(FocusEvent fe)
	{
	}
}
