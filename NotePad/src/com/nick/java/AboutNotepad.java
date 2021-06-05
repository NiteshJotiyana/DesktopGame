package com.nick.java;

import com.nick.java.handler.AboutNotepadHandler;

import java.awt.*;
import java.awt.Font;

public class AboutNotepad extends Dialog
{
	public NotePad n;
	public Button b ;
	public AboutNotepad(NotePad ob)
	{
		super(ob,true);
		n=ob;
		setBackground(Color.white);
		setLayout(null);
		b = new Button("OK");
		b.setBounds(370,350,50,25);
		b.setBackground(Color.white);
		add(b);
		AboutNotepadHandler h = new AboutNotepadHandler(this);
		addWindowListener(h);
		b.addActionListener(h);

		setTitle("About_notepad");
		setResizable(false);
		setSize(450,400);
	}
	public void paint(Graphics g)
	{
		Color c1 = new Color(255,255,255);
		Color c2 = new Color(0,0,255);
		Color c3 = new Color(255,0,0);
		Color c4 = new Color(0,0,0);
		java.awt.Font f1 = new Font("Dialog",Font.BOLD,20);
		Font f2 = new Font("Dialog",Font.BOLD,17);
		Font f3 = new Font("Dialog",Font.BOLD,15);
		g.setColor(c2);
		g.fillRect(0,0,450,150);
		g.setColor(c1);
		g.setFont(f1);
		g.drawString("BIRLA INSITITUTE OF TECHNOLOGY",50,100);
		g.setFont(f2);
		g.setColor(c3);
		g.drawString("MESRA RANCHI EX.- JAIPUR",95,125);
		g.setColor(c3);
		g.drawString("DEVELOPED BY ",20,175);
		g.setColor(c4);
		g.setFont(f3);
		g.drawString("NITESH KUMAR JOTIYANA ",20,200);
		g.drawString("4BE/4013/07",20,225);
		g.setColor(c3);
		g.drawString("The Following Functions are Working.",20,250);
		g.setColor(c4);
		g.drawString("exit,cut,copy,paste,delete,selectall,date/time,font,graph",20,275);
		g.drawLine(0,340,450,340);
	}
}
