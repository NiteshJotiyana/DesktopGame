package com.nick.java;

import com.nick.java.handler.EnterDataHandler;

import java.awt.*;

public class EnterData extends Panel
{
	public TextField tf;
	public Label l1;
	public List list1;
	public Button b1,b2,b3,b4,b5;
	public Graph g;

	public EnterData(Graph ob)
	{
		g = ob;
	
		//make Instance
		list1 = new List();
		
		b1 = new Button("Ok");
		b2 = new Button("Cancel");
		b3 = new Button("Clear");
		b4 = new Button("Add");
		b5 = new Button("Replace");
		
		l1 = new Label("Enter Data");
		tf = new TextField();

		//adding components on panel
		setLayout(null);
		Component c[] = {l1,tf,list1,b1,b2,b3,b4,b5};
		for (int i=0;i<c.length ;i++ )
		{
			add(c[i]);
		}
		for (int i=3;i<c.length ;i++ )
		{
			c[i].setBackground(Color.white);		//set Buttons Color
		}
		//set size of components 
		l1.setBounds(10,10,60,20);
		tf.setBounds(70,10,140,20);
		list1.setBounds(10,35,320,150);
		b1.setBounds(160,210,50,20);
		b2.setBounds(220,210,50,20);
		b3.setBounds(280,210,50,20);
		b4.setBounds(220,10,50,20);
		b5.setBounds(280,10,50,20);
		
		//adding listener on components
		EnterDataHandler h = new EnterDataHandler(this);
		b1.addActionListener(h);
		b2.addActionListener(h);
		b3.addActionListener(h);
		b4.addActionListener(h);
		b5.addActionListener(h);
		list1.addItemListener(h);
	}
}
