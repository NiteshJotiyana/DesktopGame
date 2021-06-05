package com.nick.java;

import com.nick.java.handler.NotepadWindowHandler;

import java.awt.*;

public class NotePad extends Frame
{
	public static TextArea ta;
	public String s;
	public Panel p;
	public Font f;

	public NotePad()
	{	
		super("Notepad");

		//make instance of components
		p =new Panel();
		f= new Font(this);
		File f = new File(this);
		Edit e = new Edit(this);
		Format fo = new Format(this);
		Insert i = new Insert(this);
		Help h = new Help(this);
		MenuBar bar = new MenuBar();
		ta = new TextArea();
		
		//add components on frame
		setLayout(new CardLayout());
		add(ta,"text");
		add(p,"graph");
		
		setMenuBar(bar);
		bar.add(f);
		bar.add(e);
		bar.add(fo);
		bar.add(i);
		bar.add(h);
		//set cursor type
		ta.setCursor(new Cursor(2));
		
		//add listener
		NotepadWindowHandler we = new NotepadWindowHandler();
		addWindowListener(we);
		
		//set frame size
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new NotePad();
	}
}

