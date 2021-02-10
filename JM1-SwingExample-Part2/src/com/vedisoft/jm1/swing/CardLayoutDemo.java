package com.vedisoft.jm1.swing;

import javax.swing.*;
import com.vedisoft.jm1.swing.class1.JButtonDemo;
import com.vedisoft.jm1.swing.class1.JCheckBoxDemo;
import com.vedisoft.jm1.swing.class1.JComboBoxDemo;
import com.vedisoft.jm1.swing.class1.JLabelDemo;
import com.vedisoft.jm1.swing.class1.JListDemo;
import com.vedisoft.jm1.swing.class1.JRadioButtonDemo;
import com.vedisoft.jm1.swing.class1.JSliderDemo;
import com.vedisoft.jm1.swing.class1.JSpinnerDemo;
import com.vedisoft.jm1.swing.class1.JTextAreaDemo;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends JPanel implements ActionListener {

	JButton btnFirst, btnNext, btnPrevious, btnLast;// for navigation 4 btns are created
	JPanel centerPanel, southPanel;
	CardLayout cardLayout;

	public CardLayoutDemo() {
		setLayout(new BorderLayout());

		centerPanel = new JPanel();
		cardLayout = new CardLayout();
		centerPanel.setLayout(cardLayout );
		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.setBackground(Color.darkGray);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		centerPanel.add("JLabel", new JLabelDemo());// id , panel
		centerPanel.add("JButton", new JButtonDemo());
		centerPanel.add("JRadioButton", new JRadioButtonDemo());
		centerPanel.add("JCheckBox", new JCheckBoxDemo());
		centerPanel.add("JTextArea", new JTextAreaDemo());
		centerPanel.add("JList", new JListDemo());
		centerPanel.add("JComboBox", new JComboBoxDemo());
		centerPanel.add("JSlider", new JSliderDemo());
		centerPanel.add("JSpinner", new JSpinnerDemo());

		btnFirst = new JButton("First");// action command is not given therefore equals to by default name of label
		btnFirst.setMnemonic('F');
		btnFirst.addActionListener(this);
		btnNext = new JButton("Next");
		btnNext.setMnemonic('N');
		btnNext.addActionListener(this);
		btnPrevious = new JButton("Previous");
		btnPrevious.setMnemonic('P');
		btnPrevious.addActionListener(this);
		btnLast = new JButton("Last");
		btnLast.setMnemonic('L');
		btnLast.addActionListener(this);

		southPanel.add(btnFirst);
		southPanel.add(btnNext);
		southPanel.add(btnPrevious);
		southPanel.add(btnLast);

	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals("First")) {
			cardLayout.first(centerPanel);// shows 1st card on the center panel already created function
		} else if (str.equals("Next")) {
			cardLayout.next(centerPanel);
		} else if (str.equals("Previous")) {
			cardLayout.previous(centerPanel);
		} else {
			cardLayout.last(centerPanel);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CardLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new CardLayoutDemo());
		frame.setBounds(10, 10, 700, 400);
		frame.setVisible(true);
	}
}
