package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JColorChooserDemo extends JPanel implements ActionListener {
	JButton btnColorChooser;

	public JColorChooserDemo() {
		setLayout(new FlowLayout());
		btnColorChooser = new JButton("Color Chooser");
		btnColorChooser.addActionListener(this);
		add(btnColorChooser);
	}

	public void actionPerformed(ActionEvent ae) {
		Color color = getBackground();
		color = JColorChooser.showDialog(this, "Choose background color", color);
		if (color != null) {// if condition not used and user does not select any color null will be selected ---
			//due to which exception occur
			setBackground(color);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("ColorChooser Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JColorChooserDemo());
		frame.setBounds(100, 100, 400, 400);
		frame.setVisible(true);
	}

}
