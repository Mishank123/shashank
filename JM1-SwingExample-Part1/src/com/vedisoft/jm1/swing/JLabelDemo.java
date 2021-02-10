package com.vedisoft.jm1.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class JLabelDemo extends JPanel//JPanel helps to integrate i.e. add differents label to Frame 
{

	JLabel label1, label2, label3, label4, label5;
	JTextField textField1, textField2;

	public JLabelDemo() {
		setLayout(new FlowLayout());
		label1 = new JLabel();
		label1.setText("Hello World");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label1.setOpaque(true);// used to change background color --true
		label1.setBackground(Color.red);
		label1.setForeground(Color.yellow);
		label1.setToolTipText("This is JLabel with text");
		add(label1);

		label2 = new JLabel();
		Icon icon = new ImageIcon(getClass().getResource("/images/koala.jpg"));//Icon is an interface 
		label2.setIcon(icon);
		label2.setToolTipText("This is JLabel with Icon");
		add(label2);

		label3 = new JLabel();
		Icon icon1 = new ImageIcon(getClass().getResource("/images/koala.jpg"));
		label3.setIcon(icon1);
		label3.setText("Koala Bear");
		label3.setVerticalTextPosition(JLabel.BOTTOM);
		label3.setHorizontalTextPosition(JLabel.CENTER);
		label3.setToolTipText("This is JLabel with Icon and text");
		label3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		label3.setOpaque(true);
		label3.setBackground(Color.white);
		add(label3);

		label4 = new JLabel("Enter Your Name ");
		textField1 = new JTextField(20);
		label4.setDisplayedMnemonic('N');//alt+n
		label4.setLabelFor(textField1);
		add(label4);
		add(textField1);

		label5 = new JLabel("Enter Your Address");
		textField2 = new JTextField(20);
		label5.setDisplayedMnemonic('A');
		label5.setLabelFor(textField2);
		add(label5);
		add(textField2);
	}

	public static void main(String args[]) {
		JFrame f = new JFrame("JLabel Demo Example ");
		// methods of frame class
		f.setContentPane(new JLabelDemo());//set panel on frame---------panel is subcontainer therefore needs to add on frame
		
		f.setBounds(10, 10, 750, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// jframe is static data as classname.methodname
	}
}





