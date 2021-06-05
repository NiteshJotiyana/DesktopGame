package com.nick.java;

import com.nick.java.handler.InsertHandler;


import java.awt.*;

public class Insert extends Menu
{
	public NotePad n;
	public MenuItem m1,m2;
	public Insert(NotePad ob)
	{	
		super("Insert");
		n= ob;
		//make instance
		m1 = new MenuItem("Graph..");
		m2 = new MenuItem("Text");
		
		//adding Menuitem
		add(m1);
		add(m2);
		
		//add listener
		InsertHandler h = new InsertHandler(this);
		m1.addActionListener(h);
		m2.addActionListener(h);
	}
	
}
