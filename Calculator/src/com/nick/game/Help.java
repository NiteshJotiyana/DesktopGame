package com.nick.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Help extends JFrame implements ActionListener
{	
	JPanel jmain,jp1,jp2,jp3,jp4;
	JLabel j1,j2,j3;
	JButton b1;
	public Help()
	{	
		super("HELP");
		jmain = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		b1 = new JButton("OK");
		
		j1 = new JLabel("WELCOME IN HELP MENU:");
		j2= new JLabel("THIS FACILITY HAS NOT PROVIDED IN THIS CALCULATOR");
		
		Icon img = new ImageIcon("images/6.GIF");
		j3 = new JLabel(img);
		getContentPane().add(jmain);
		jmain.setLayout(new BorderLayout());
		jmain.add(jp2,BorderLayout.SOUTH);
		jmain.add(jp1,BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(1,2));
		jp1.add(jp3);
		jp1.add(jp4);

		jp3.setLayout(new GridLayout(2,1));
		jp3.add(j1);
		jp3.add(j2);

		jp4.add(j3);

		jp2.add(b1);
	
	b1.addActionListener(this);
	setSize(400,200);				
	setVisible(true);				
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	
	}
	public void actionPerformed(ActionEvent ae)
	{	
		Object o = ae.getSource();
		if (o==b1)
		{
			setVisible(false);
		}
	}
	
}
