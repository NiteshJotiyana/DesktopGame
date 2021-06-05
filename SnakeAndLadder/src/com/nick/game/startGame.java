package com.nick.game;

import javax.swing.*;

class startGame extends JPanel 
{
	JLabel p[] = new JLabel[10];
	
	private start s;
	startGame(theme t,start s)
	{
		this.s = s;
		setLayout(null);
		setBackground(t.green);
	
		p[0] = new JLabel("Players");
		p[1] = new JLabel("Score");
		p[2] = new JLabel("Player1",s.gs.sym[0].getImage(),2);
		p[3] = new JLabel("Player2",s.gs.sym[1].getImage(),2);
		p[4] = new JLabel("Player3",s.gs.sym[2].getImage(),2);
		p[5] = new JLabel("Player4",s.gs.sym[3].getImage(),2);
		p[6] = new JLabel("0");
		p[7] = new JLabel("0");
		p[8] = new JLabel("0");
		p[9] = new JLabel("0");
		
		p[2].setHorizontalTextPosition(2);
		p[3].setHorizontalTextPosition(2);
		p[4].setHorizontalTextPosition(2);
		p[5].setHorizontalTextPosition(2);
		
		for (int i=0;i<=9;i++)
		{
			add(p[i]);
			p[i].setForeground(t.yellow);
			p[i].setFont(t.century);
		}
		p[0].setForeground(t.black);
		p[1].setForeground(t.black);

		p[0].setBounds(30,10,70,15);
		p[1].setBounds(130,10,70,15);
		p[2].setBounds(20,40,100,22);
		p[3].setBounds(20,80,100,22);
		p[4].setBounds(20,120,100,22);
		p[5].setBounds(20,160,100,22);
		p[6].setBounds(130,40,70,22);
		p[7].setBounds(130,80,70,22);
		p[8].setBounds(130,120,70,22);
		p[9].setBounds(130,160,70,22);
		
		p[4].setVisible(false);
		p[5].setVisible(false);
		p[8].setVisible(false);
		p[9].setVisible(false);
	}	
}
