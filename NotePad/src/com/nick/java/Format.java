package com.nick.java;

import com.nick.java.handler.FormatHandler;

import java.awt.*;

public class Format extends Menu
{
	public MenuItem t1,t2;
	public NotePad n;
	public Format(NotePad ob)
	{
		super("Format");
		n=ob;
		
		//make Instance
		t1 = new MenuItem("Word Wrap");
		t2 = new MenuItem("Font..");
		
		//adding menuItem on menu
		add(t1);
		add(t2);
		
		//add Listener
		FormatHandler h = new FormatHandler(this);
		t1.addActionListener(h);
		t2.addActionListener(h);
	}
}
