package com.nick.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener,FocusListener
{
	JPanel jmain,jp1,jp2;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21;
	JTextField jt1;
	JMenuBar bar;
	JMenu m1,m2,m3;
	JMenuItem t1,t2,t3,t4;

	public Calculator()
	{
		super("Calculator");
		jmain = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
	
		b1 = new JButton("+");
		b2 = new JButton("-");
		b3 = new JButton("*");
		b4 = new JButton("/");
		b5 = new JButton("=");
		b6 = new JButton("R");
		b7 = new JButton("O");
		b8 = new JButton("C");
		b10 = new JButton("0");
		b11 = new JButton("1");
		b12 = new JButton("2");
		b13 = new JButton("3");
		b14 = new JButton("4");
		b15 = new JButton("5");
		b16 = new JButton("6");
		b17 = new JButton("7");
		b18 = new JButton("8");
		b19 = new JButton("9");
		b20 = new JButton(".");
		b21 = new JButton("+-");

		jt1 = new JTextField(20);
		
		bar = new JMenuBar();

		m1 = new JMenu("file");
		m2 = new JMenu("edit");
		m3 = new JMenu("help");

		t1 = new JMenuItem("close");
		t2 = new JMenuItem("save");
		t3 = new JMenuItem("topicHelp");
		t4 = new JMenuItem("Conversion");

		bar.add(m1);
		bar.add(m2);
		bar.add(m3);

		m1.add(t1);
		m2.add(t2);
		m2.add(t4);
		m3.add(t3);
		
		setJMenuBar(bar);

		getContentPane().add(jmain);
		jmain.setLayout(new BorderLayout());
		jmain.add(jp1,BorderLayout.NORTH);
		jmain.add(jp2,BorderLayout.CENTER);

		//set panel1 arrangement
		jp1.add(jt1);

		//set panel2 arrangement
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
				
		jp2.setLayout(gbl);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2,2,2,2);
				
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(b7,gbc);
		jp2.add(b7);

		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(b8,gbc);
		jp2.add(b8);
			
	
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(b6,gbc);
		jp2.add(b6);
			
		gbc.gridx=3;
		gbc.gridy=0;
		gbl.setConstraints(b21,gbc);
		jp2.add(b21);
			
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(b17,gbc);
		jp2.add(b17);
			
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(b18,gbc);
		jp2.add(b18);
			
		gbc.gridx=2;
		gbc.gridy=1;
		gbl.setConstraints(b19,gbc);
		jp2.add(b19);
			
		gbc.gridx=3;
		gbc.gridy=1;
		gbl.setConstraints(b1,gbc);
		jp2.add(b1);
			
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(b14,gbc);
		jp2.add(b14);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(b15,gbc);
		jp2.add(b15);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbl.setConstraints(b16,gbc);
		jp2.add(b16);
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbl.setConstraints(b2,gbc);
		jp2.add(b2);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(b11,gbc);
		jp2.add(b11);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(b12,gbc);
		jp2.add(b12);
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbl.setConstraints(b13,gbc);
		jp2.add(b13);
		
		gbc.gridx=3;
		gbc.gridy=3;
		gbl.setConstraints(b3,gbc);
		jp2.add(b3);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(b10,gbc);
		jp2.add(b10);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(b20,gbc);
		jp2.add(b20);
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbl.setConstraints(b5,gbc);
		jp2.add(b5);
		
		gbc.gridx=3;
		gbc.gridy=4;
		gbl.setConstraints(b4,gbc);
		jp2.add(b4);
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		jt1.addFocusListener(this);
		b10.addFocusListener(this);
		b11.addFocusListener(this);
		b12.addFocusListener(this);
		t1.addActionListener(this);
		t3.addActionListener(this);
		t4.addActionListener(this);

		//set size of frame
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();	
	}
	double n1=0,n2=0,action=0;
	public void key()
	{
		n1 = Double.parseDouble(jt1.getText());
		jt1.setText("");
	}
	public void print(double s)
	{
	
		jt1.setText("                                                       "+s);	
		
	}
	public void print(String s)
	{
		jt1.setText("                                                      "+s);
	}
	public void focusLost(FocusEvent fe)
	{
	}
	public void focusGained(FocusEvent fe)
	{	Object o1 = fe.getSource();
		if (o1==jt1)
		{	
			String s = jt1.getText();
			jt1.setText("                                                          "+s);
			
		}	
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==t1)
		{	
			System.exit(0);
		}
		if (o==t3)
		{
			//IMPORTANT
			Help h = new Help();
			h.setVisible(true);
		}
		if (o==t4)
		{
			NumberSystem ns = new NumberSystem();
			ns.setVisible(true);
		}
		if (o==b10)
		{	
			String s1 = jt1.getText();
			print(s1+"0");
		}
		if (o==b11)
		{	
		
			String s1 = jt1.getText();
			print(s1+"1");
		}
		if (o==b12)
		{	
			String s1 = jt1.getText();
			print(s1+"2");
		}
		if (o==b13)
		{	
			String s1 = jt1.getText();
			print(s1+"3");
		}
		if (o==b14)
		{	
			String s1 = jt1.getText();
			print(s1+"4");
		}
		if (o==b15)
		{	
			String s1 = jt1.getText();
			print(s1+"5");
		}
		if (o==b16)
		{
			String s1 = jt1.getText();
			print(s1+"6");
		}
		if (o==b17)
		{
			String s1 = jt1.getText();
			print(s1+"7");
		}
		if (o==b18)
		{	
			String s1 = jt1.getText();
			print(s1+"8");
		}
		if (o==b19)
		{	
			String s1 = jt1.getText();
			print(s1+"9");
		}
		if (o==b20)
		{		
			String s =jt1.getText();
			int n = s.indexOf(".");
			if (n==-1)
			{	
				print(s+".");
			}
			
		}
		if (o==b21)
		{	
			double s1= Double.parseDouble(jt1.getText());
			print(s1*(-1));
		}
		if (o==b7)
		{
			System.exit(0);
		}
		if (o==b8)
		{
			jt1.setText("");
		}
		if (o==b1)
		{	
			key();
			action=1;
		}
		if (o==b2)
		{
			key();
			action=2;
		}
		if (o==b3)
		{
			key();
			action=3;
		}if (o==b4)
		{
			key();
			action=4;
		}
		if (o==b6)
		{
			key();
			double s =Math.sqrt(n1);
			print(s);
			
		}

		if (o==b5)
		{	
			double s =0;
			n2 = Double.parseDouble(jt1.getText());
			if(action==1)
			{
				 s =n1+n2;
			}
			if (action==2)
			{
				 s =n1-n2;
			}
			if (action==3)
			{
				 s =n1*n2;
			}
			if (action==4)
			{	
				try
				{
					s=n1/n2;	
				}
				catch (ArithmeticException e)
				{
				}
			}
			print(s);	
		}
	}

	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		new Calculator();
	}
}
