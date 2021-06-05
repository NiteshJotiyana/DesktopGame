package com.nick.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class NumberSystem extends JDialog implements ActionListener
{
	JPanel jp2;
	JComboBox jcb;
	JButton b1,b2,b3;
	JTextField jt1;
	JLabel l1,l2;

	public NumberSystem()
	{
		setTitle("Number System");
		jp2 = new JPanel();

		String a[] = {"OCTAL","BINARY","HEXA"};
		jcb = new JComboBox(a);
		
		b1 = new JButton("close");
		b2 = new JButton("clear");
		b3 = new JButton("ok");
		
		jt1 = new JTextField(10);

		l1 = new JLabel("Decimal");
		l2 = new JLabel("null");

		
		//arrangemant of p2
		getContentPane().add(jp2);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		jp2.setLayout(gbl);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2,2,2,2);
				
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(l1,gbc);
		jp2.add(l1);

		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(jt1,gbc);
		jp2.add(jt1);

		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(jcb,gbc);
		jp2.add(jcb);

		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(l2,gbc);
		jp2.add(l2);

		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(b1,gbc);
		jp2.add(b1);

		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(b2,gbc);
		jp2.add(b2);

		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(b3,gbc);
		jp2.add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		//set size of frame
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	void conversion(int t)
	{
		int a = Integer.parseInt(jt1.getText());
		String b[] = new String[10];
		for (int i=0;i<=10;i++ )
		{		
			if (a>t-1)
			{	
				b[i] =a%t+"";
				a = a/t;
			}
			else
			{
				String p[] = {"A","B","C","D","E","F"};
				String q[] = {"10","11","12","13","14","15"};
				String s = "";
				b[i]=a+"";
				for (;i>=0;i--)
				{	
					for (int j=0;j<6 ;j++ )
					{
						if (b[i].equals(q[j]))
						{
							b[i]=p[j];
						}
					}
					s = s+b[i];
				}
				l2.setText(s);	
				break;
			}
		}

	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o =ae.getSource();
		if (o==b1)
		{
			setVisible(false);
		}
		if (o==b2)
		{
			String s = "Decimal : "+jt1.getText()+" Binary : "+l2.getText();
			try
			{
				RandomAccessFile lfile = new RandomAccessFile("dbnumber.txt","rw");
				lfile.seek(lfile.length());
				lfile.writeBytes(s);

			}
			catch (IOException ie)
			{
				
			}
			jt1.setText("");
			l2.setText("null");
			
		}
		if (o==b3)
		{
			String s1 =(String)jcb.getSelectedItem();
			if (s1.equals("BINARY"))
			{
				conversion(2);	
			}
			if (s1.equals("OCTAL"))
			{
				conversion(8);
			}
			if (s1.equals("HEXA"))
			{
				conversion(16);
			}
		}
	}
}
