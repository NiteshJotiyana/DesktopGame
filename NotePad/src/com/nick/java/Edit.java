package com.nick.java;

import com.nick.java.handler.EditHandler;

import java.awt.*;

public class Edit extends Menu
{
	public MenuItem t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	public NotePad n;

	public Edit(NotePad ob)
	{
		super("Edit");
		n=ob;
		//make Instance
		t1 = new MenuItem("Undo             Ctrl+Z");
		t2 = new MenuItem("-");
		t3 = new MenuItem("Cut                Ctrl+X");
		t4 = new MenuItem("Copy             Ctrl+C");
		t5 = new MenuItem("Paste            Ctrl+V");
		t6 = new MenuItem("Delete           del");
		t7 = new MenuItem("-");
		t8 = new MenuItem("Find..             Ctrl+f");
		t9 = new MenuItem("FindNext        F3");
		t10 = new MenuItem("Replace        Ctrl+H");
		t11 = new MenuItem("Go To            Ctrl+G");
		t12 = new MenuItem("-");
		t13 = new MenuItem("SelectAll         Ctrl+A");
		t14 = new MenuItem("Time/Date      F5");
	
		//adding menuItem on Menu & add Listener
		MenuItem c[] = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14};
		EditHandler h = new EditHandler(this);
		for (int i=0;i<c.length ;i++ )
		{
			add(c[i]);
			c[i].addActionListener(h);
		}
	}
}
