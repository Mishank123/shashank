package com.vedisoft.jm1.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JButtonDemo extends JPanel implements ActionListener {

	JButton button1, button2, button3;
	JLabel label1;

	public JButtonDemo() {
		setLayout(new FlowLayout());
		button1 = new JButton();
		button1.setText("Click Me");
		button1.setActionCommand("button1");
		button1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button1.setToolTipText("Simple Text Button");
		button1.addActionListener(this);
		add(button1);

		button2 = new JButton();
		button2.setText("Click Me");
		button2.setActionCommand("button2");
		button2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button2.setOpaque(true);
		button2.setBackground(Color.red);
		button2.setForeground(Color.yellow);
		button2.setToolTipText("Button with Colored Text");
		button2.addActionListener(this);
		add(button2);

		button3 = new JButton();
		button3.setActionCommand("button3");
		Icon icon = new ImageIcon(getClass().getResource("images/koala.jpg"));
		button3.setIcon(icon);
		button3.setToolTipText("This is JLabel with Icon");
		button3.addActionListener(this);
		add(button3);

		label1 = new JLabel();
		label1.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 24));
		label1.setOpaque(true);
		label1.setForeground(Color.red);
		add(label1);
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals("button1"))
			label1.setText("User Clicked on the First Button");
		else if (str.equals("button2"))
			label1.setText("User Clicked on the Second Button");
		else if (str.equals("button3"))
			label1.setText("User Clicked on the Third Button");
	}

	public static void main(String args[]) {
		JFrame f = new JFrame("JButon Demo Example ");
		f.setContentPane(new JButtonDemo());
		f.setBounds(10,10,600,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
