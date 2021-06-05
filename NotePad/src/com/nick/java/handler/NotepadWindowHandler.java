package com.nick.java.handler;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NotepadWindowHandler extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}