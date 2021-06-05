package com.nick.java;

import java.awt.*;
import java.awt.event.*;

public class Help extends Menu implements ActionListener
{
	public MenuItem m;
	public NotePad n;
	public Help(NotePad ob)
	{	
		super("Help");
		n=ob;
		m = new MenuItem("About_notepad..");
		add(m);
		m.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==this.m)
		{
			AboutNotepad an=  new AboutNotepad(n);
			an.setVisible(true);
		}
	}
}
