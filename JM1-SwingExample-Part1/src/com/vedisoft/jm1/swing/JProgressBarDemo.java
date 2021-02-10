package com.vedisoft.jm1.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JProgressBarDemo extends JPanel {

	JProgressBar jp;
	Timer t;// already created thread
	int i = 0;

	public JProgressBarDemo() {
		setLayout(new GridLayout());
		setVisible(true);
		jp = new JProgressBar();
		jp.setStringPainted(true);// true then percentage is written on the progressbar
		jp.setPreferredSize(new Dimension(500, 30));
		jp.setMinimum(0);// minimum time
		jp.setMaximum(1000);
		t = new Timer(2, new ActionListener() {//timer given task to call actionperform after every 2milisecond 
			public void actionPerformed(ActionEvent ae) {
				if (i == 1000)// when reaches to 1000 progress bar become 0-------
					//loop through  timer
					i = 0;
				jp.setValue(i++);
			}
		});
		t.start();
		add(jp);
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("JProgressBar Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JProgressBarDemo());
		frame.pack();
		frame.setVisible(true);
	}
}
