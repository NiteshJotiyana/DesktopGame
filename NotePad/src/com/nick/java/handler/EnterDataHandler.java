package com.nick.java.handler;

import com.nick.java.ColumnGrpah;
import com.nick.java.EnterData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EnterDataHandler implements ActionListener, ItemListener {
	EnterData ed;

	public EnterDataHandler(EnterData ed) {
		this.ed = ed;
	}

	public void itemStateChanged(ItemEvent ie) {
		Object o = ie.getSource();
		if (o == ed.list1) {
			ed.tf.setText(ed.list1.getSelectedItem());
		}
	}

	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o == ed.b4)                    //Add
		{
			String s = ed.tf.getText();
			if (s.equals("")) {
				javax.swing.JOptionPane.showMessageDialog(ed, "U have not entered data ... ");
			} else {
				ed.list1.add(s);
				ed.tf.setText(null);
			}
		}
		if (o == ed.b5)                    //Replace
		{
			try {
				ed.list1.replaceItem(ed.tf.getText(), ed.list1.getSelectedIndex());
				ed.tf.setText(null);
			} catch (Exception e) {
				javax.swing.JOptionPane.showMessageDialog(ed, "U have not selected Data ");
			}
		}
		if (o == ed.b2)                    //Cancle
		{
			ed.g.setVisible(false);
		}
		if (o == ed.b3)                    //Clear
		{
			ed.list1.removeAll();
		}
		if (o == ed.b1)                    //Ok
		{

			String s[] = ed.list1.getItems();
			int count = ed.list1.getItemCount();
			if (count == 0) {
				javax.swing.JOptionPane.showMessageDialog(ed, "U have not entered data ... ");
			} else {
				try {
					double data[] = new double[count];
					for (int i = 0; i < count; i++) {
						data[i] = Double.parseDouble(s[i]);
					}
					ColumnGrpah ob = new ColumnGrpah(data, ed.g);

					ed.g.n.p.removeAll();
					ed.g.n.p.setLayout(null);
					ob.setBounds(0, 0, 1000, 400);
					ed.g.n.p.add(ob);
					CardLayout c1 = (CardLayout) (ed.g.n.getLayout());
					c1.show(ed.g.n, "graph");
					ed.g.setVisible(false);

				} catch (NumberFormatException ne) {
					javax.swing.JOptionPane.showMessageDialog(ed, "U have entered illegal data ... ");
				}
			}
		}

	}
}

