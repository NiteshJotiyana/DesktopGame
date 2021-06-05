package com.nick.java.handler;

import com.nick.java.Edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class EditHandler implements ActionListener
{
	public Edit e;
	public EditHandler(Edit e)
	{
		this.e = e;
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==e.t3)							//Cut
		{
			e.n.s = e.n.ta.getSelectedText();
			int start = e.n.ta.getSelectionStart();
			int end = e.n.ta.getSelectionEnd();
			e.n.ta.replaceRange("",start,end);
		}
		if (o==e.t4)							//Copy
		{
			e.n.s =e.n.ta.getSelectedText();
		}
		if (o==e.t5)							//paste
		{
			int pos = e.n.ta.getCaretPosition();
			e.n.ta.insert(e.n.s,pos);
		}
		if (o==e.t6)							//Delete
		{
			String del =e.n.ta.getSelectedText();
			int start = e.n.ta.getSelectionStart();
			int end = e.n.ta.getSelectionEnd();
			e.n.ta.replaceRange("",start,end);
		}
		if (o==e.t13)							//selectAll
		{
			e.n.ta.selectAll();
		}
		if (o==e.t14)							//date & time
		{
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			int hour = cal.get(Calendar.HOUR);
			int min = cal.get(Calendar.MINUTE);
			int sec = cal.get(Calendar.SECOND);
			int am = cal.get(Calendar.AM_PM);
			String cas[] ={"AM","PM"};
			e.n.ta.append("\n"+hour+":"+min+":"+sec+" "+cas[am]+"  "+day+"/"+(month+1)+"/"+year);
		}	
	}
}