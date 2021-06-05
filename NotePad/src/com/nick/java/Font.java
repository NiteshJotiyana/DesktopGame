package com.nick.java;

import com.nick.java.handler.FontWindowHandler;

import java.awt.*;

public class Font extends Dialog
{
	public Button b1,b2;
	public TextField tf1,tf2,tf3;
	public TextArea text;
	public List list1,list2,list3;
	public Label l1,l2,l3,l4;
	public Panel p;
	public NotePad n;

	public Font(NotePad ob)
	{	
		super(ob,true);
		n =ob;
			
		//make Instance
		p= new Panel();
		
		l1 = new Label("Font:");
		l2 = new Label("Font style:");
		l3 = new Label("Size:");
		l4 = new Label("Size:");
		
		text = new TextArea("AaBaYyZz",1,8,TextArea.SCROLLBARS_NONE);
		text.setEditable(false);
		

		b1 = new Button("Ok");
		b2 = new Button("Cancel");
		b1.setBackground(Color.white);		//set color of Buttons
		b2.setBackground(Color.white);

		tf1 = new TextField(150);
		tf2 = new TextField(100);
		tf3 = new TextField(50);
		
		list1 = new List();
		list2 = new List();
		list3 = new List();
	
		String s1[] = {"Monospaced","Sansserif","Serif","Dialog","DialogInput"};
		String s2[] = {"Regular","Bold","Italic","Bold Italic"};
		String s3[] = {"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
		
		//adding item in lists
		for (int i=0;i<s3.length;i++ )
		{
			list3.add(s3[i]);
		}
		for (int i=0;i<s1.length ;i++ )
		{
			list1.add(s1[i]);
		}
		for (int i=0;i<s2.length ;i++ )
		{
			list2.add(s2[i]);
		}
		
		//set list properties
		list1.setMultipleMode(false);
		list2.setMultipleMode(false);
		list3.setMultipleMode(false);
		
		list1.select(1);
		list2.select(0);
		list3.select(1);
		
		tf1.setText(list1.getSelectedItem());
		tf2.setText(list2.getSelectedItem());
		tf3.setText(list3.getSelectedItem());
		
		//adding components on dialog
		
		setLayout(null);
	
		Component c[] = {l1,l2,l3,text,b1,b2,tf1,tf2,tf3,list1,list2,list3};
		for (int i=0;i<c.length ;i++ )
		{
			add(c[i]);
		}
		//set size of components
		l1.setBounds(10,35,50,15);
		l2.setBounds(180,35,100,15);
		l3.setBounds(300,35,50,15);
		text.setBounds(200,250,130,38);
			
		b1.setBounds(370,50,70,20);
		b2.setBounds(370,75,70,20);
		
		tf1.setBounds(10,50,150,20);
		tf2.setBounds(180,50,100,20);
		tf3.setBounds(300,50,50,20);
	
		list1.setBounds(10,70,150,120);
		list2.setBounds(180,70,100,120);
		list3.setBounds(300,70,50,120);
		
		//set dialog properties
		setTitle("Font");
		setResizable(false);
		setSize(450,400);
		
		//adding Listener
		FontWindowHandler h = new FontWindowHandler(this);
		addWindowListener(h);
		list1.addItemListener(h);
		list2.addItemListener(h);
		list3.addItemListener(h);
		b1.addActionListener(h);
		b2.addActionListener(h);
	}
	
	public void paint(Graphics g)
	{
		Color c1 = new Color(0,0,255);
		Color c2 = new Color(159,207,255);
		g.setColor(c1);
		g.drawString("Sample",185,225);
		g.setColor(c2);
		g.drawRoundRect(180,235,170,70,5,5);
	}

	
}
