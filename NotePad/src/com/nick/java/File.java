package com.nick.java;

import com.nick.java.handler.FileHandler;

import java.awt.*;

public class File extends Menu
{
	public MenuItem t1,t2,t3,t4,t5,t6,t7,t8,t9;
	public NotePad n;

	public File(NotePad ob)
	{
		super("File");
		n=ob;

		//make instance
		t1 = new MenuItem("New             Ctrl+N");
		t2 = new MenuItem("Open...        Ctrl+O");
		t3 = new MenuItem("Save            Ctrl+S");
		t4 = new MenuItem("SaveAs...");
		t5 = new MenuItem("-");
		t6 = new MenuItem("PageSetup...");
		t7 = new MenuItem("Print....         Ctrl+P");
		t8 = new MenuItem("-");
		t9 = new MenuItem("Exit");
		
		//add items in Menu & add Listener
		MenuItem item[] = {t1,t2,t3,t4,t5,t6,t7,t8,t9}; //array of MenuItem
		FileHandler h= new FileHandler(this);
		for (int i=0;i<item.length ;i++ )
		{
			add(item[i]);
			item[i].addActionListener(h);
		}
	}
}
