package com.nick.java.handler;

import com.nick.java.AboutNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AboutNotepadHandler extends WindowAdapter implements ActionListener
{
	public AboutNotepad an;
	public AboutNotepadHandler(AboutNotepad ob)
	{
		this.an = ob;
	}
	public void windowClosing(WindowEvent we)
	{
		an.setVisible(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==an.b)
		{
			an.setVisible(false);
		}
	}
	
}