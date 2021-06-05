package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame
{
	JPanel p;
	public Test()
	{
			
			p=new JPanel();
			p.setLayout(null);
		
			item i=new item();
			
			p.setBackground(Color.yellow);	
			p.setBounds(0,0,400,400);
			add(p);
			i.setLocation(100,100);
			p.add(i);
			
			
			setVisible(true);
			setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new Test();
	}
}
