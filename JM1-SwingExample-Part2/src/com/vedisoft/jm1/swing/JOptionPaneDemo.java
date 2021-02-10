package com.vedisoft.jm1.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JOptionPaneDemo extends JPanel implements ActionListener {
	JButton button1, button2, button3, button4, button5;

	public JOptionPaneDemo() {
		setLayout(new FlowLayout());
		button1 = new JButton("Message Dialog 1");
		button2 = new JButton("Message Dialog 2");
		button3 = new JButton("Confirm Dialog");
		button4 = new JButton("Input Dialog 1");
		button5 = new JButton("Input Dialog 2");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
	}

	public void actionPerformed(ActionEvent ae) {
		Icon icon = new ImageIcon(getClass().getResource("/images/koala.jpg"));
		String str = ae.getActionCommand();
		if (str.equals("Message Dialog 1")) {
			JOptionPane.showMessageDialog(this, "This is Message", "Title", JOptionPane.INFORMATION_MESSAGE);// argument 1 - parent
		} else if (str.equals("Message Dialog 2")) {
			JOptionPane.showMessageDialog(this, "This is Message", "Title", JOptionPane.INFORMATION_MESSAGE, icon);
		} else if (str.equals("Confirm Dialog")) {
			int option = JOptionPane.showConfirmDialog(this, "Do You Want to Continue ?", "Continue App",
					JOptionPane.YES_NO_CANCEL_OPTION);// type casting
			if (option == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Yes Option");
			} else if (option == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "No Option");
			}
		} else if (str.equals("Input Dialog 1")) {
			String input = JOptionPane.showInputDialog(this, "Enter Your Name", "Manish");
			JOptionPane.showMessageDialog(this, "You Typed : " + input);
		} else if (str.equals("Input Dialog 2")) {
			String options[] = { "Red", "Green", "Blue", "Cyan", "Magenta" };
			String input = (String) JOptionPane.showInputDialog(this, "Enter Your Name", "Name",
					JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
			JOptionPane.showMessageDialog(this, "You Typed : " + input);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JOptionPane  Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JOptionPaneDemo());
		frame.pack();
		frame.setVisible(true);
	}
}





