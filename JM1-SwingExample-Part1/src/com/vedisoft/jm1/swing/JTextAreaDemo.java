package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaDemo extends JPanel implements ActionListener {

	JTextField jtfInput;
	JTextArea jtAreaOutput;
	String newline = "\n";

	public JTextAreaDemo() {
		jtfInput = new JTextField(20);//20 =columns
		jtfInput.addActionListener(this);
		jtAreaOutput = new JTextArea(5, 20);
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument().getLength());// function to move caret to next line  - cursor of keyboard
		// data in output moves up by 1 position due to above line
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//ScrollPane to provide scrollbar
		setLayout(new BorderLayout());
		add(jtfInput, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent evt) {
		String text = jtfInput.getText();
		jtAreaOutput.append(text + newline);// adds new line
		jtfInput.selectAll();// select the content of textfield
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTextArea Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JTextAreaDemo());
		frame.pack();
		frame.setVisible(true);
	}
}