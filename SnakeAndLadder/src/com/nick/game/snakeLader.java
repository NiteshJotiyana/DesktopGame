package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class snakeLader extends JPanel implements MouseListener
{
	private final String passwordString="game32";
	String password;
	private JLabel pic,l1,l2,l3,l4;
	 button j2,j3;
	private JPanel p;
	private start s;
	private final Font f = new Font("",Font.ITALIC,20);
	private final Color c = new Color(255,0,0);	
	private final Icon img = new ImageIcon(Constants.resourcesFolder+"/images/com.nick.game.start.GIF");
	private final Icon img1 = new ImageIcon(Constants.resourcesFolder+"/images/danger.GIF");
	private final Icon img2 = new ImageIcon(Constants.resourcesFolder+"/images/bdance.GIF");
	Color green = new Color(0,90,0);
	Color light_green= new Color(0,150,0);
	Color pink = new Color(255,0,255);
	Color dark_pink = new Color(196,0,98);
	
	JPasswordField jpw= new JPasswordField();
	
	snakeLader(start s)
	{
		this.s=s;
		p= new JPanel();
		pic = new JLabel(img);
		j2 = new button("Enter");
		j3 = new button("Exit");
		l1 = new JLabel(" Enter Password :");
		l2 = new JLabel(" Select Option");
		l4 = new JLabel("");
		l3 = new JLabel(img2);
		jpw.setFocusable(true);
		l1.setForeground(Color.yellow);
		l1.setFont(f);
		l1.setBounds(750,50,200,20);
		
		l2.setBounds(750,400,200,20);
		l2.setFont(f);
		l2.setForeground(Color.yellow);

		l3.setBounds(800,200,120,130);
		
		l4.setBounds(780,320,200,30);
		l4.setForeground(Color.green);
		l4.setFont(f);

		//setting Button properties
		j2.setFont(f);
		j3.setFont(f);
		j2.setLocation(850,480);
		j3.setLocation(850,550);
	
		jpw.setBounds(760,100,220,30);
		jpw.setFont(f);
	
		jpw.setBackground(pink);
		jpw.setForeground(Color.red);
		
		j2.addMouseListener(this);
		j3.addMouseListener(this);
		
		//setting pan
		p.setLayout(null);
		p.setBackground(dark_pink);
		p.add(pic);
		p.setBounds(100,50,1050,650);
		pic.setBounds(50,25,664,600);
		p.add(j2);
		p.add(j3);
		p.add(l1);
		p.add(l2);
		p.add(jpw);
		p.add(l3);
		p.add(l4);
		//setting class
		add(p);
		setBackground(pink);
		setLayout(null);
	}
	public void mouseClicked(MouseEvent me)
	{
		Object o = me.getSource();
		char temp[] = jpw.getPassword();
		password = new String(temp);
		if (o==j2&password.equals(passwordString))
		{
			CardLayout c1 = (CardLayout)(s.getLayout());
			c1.show(s,"main");
		}
		else
		{
			l3.setIcon(img1);
			l4.setText("Wrong Password");
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
