package com.nick.java.handler;

import com.nick.java.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileHandler implements ActionListener
{
	File f;
	public FileHandler(File f)
	{
		this.f = f;
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==f.t9)
		{
			System.exit(0);
		}
	}
}