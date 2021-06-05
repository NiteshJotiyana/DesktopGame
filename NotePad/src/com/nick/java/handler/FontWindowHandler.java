package com.nick.java.handler;

import com.nick.java.Font;

import java.awt.event.*;
import java.awt.font.*;

public class FontWindowHandler extends WindowAdapter implements ActionListener, ItemListener
{
	Font f;
	public FontWindowHandler(Font f)
	{
		this.f = f;
	}
	public void windowClosing(WindowEvent we)
	{
		f.setVisible(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==f.b1)
		{	
			int no = Integer.parseInt(f.list3.getSelectedItem());
			java.awt.Font font = new java.awt.Font(f.list1.getSelectedItem(),f.list2.getSelectedIndex(),no);
			f.n.ta.setFont(font);
			f.setVisible(false);
		}
		if (o==f.b2)
		{	
			f.setVisible(false);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		Object o = ie.getSource();
		if (o==f.list1|o==f.list2|o==f.list3)
		{
			int no = Integer.parseInt(f.list3.getSelectedItem());
			java.awt.Font font = new java.awt.Font(f.list1.getSelectedItem(),f.list2.getSelectedIndex(),no);
			f.text.setFont(font);
			
			f.tf1.setText(f.list1.getSelectedItem());
			f.tf2.setText(f.list2.getSelectedItem());
			f.tf3.setText(f.list3.getSelectedItem());
		}
	}
}