package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class DateComboBoxDemo extends JPanel {

	JLabel jlbResult;
	String currentPattern;
	JLabel jlbHeading;
	JComboBox<String> patternList;

	public DateComboBoxDemo() {
		String[] datePatterns = { "dd MMMMM yyyy", "dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd G 'at' hh:mm:ss z",
				"EEE, MMM d, ''yy", "h:mm a", "H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa" };
		currentPattern = datePatterns[0];
		jlbHeading = new JLabel("Enter Date pattern /Select from list:", JLabel.LEFT);
		patternList = new JComboBox<String>(datePatterns);// array passed in combo box
		patternList.setEditable(true);// we can also type the pattern as editable is true

		patternList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbDates = (JComboBox) e.getSource();
				String seletedDate = (String) jcmbDates.getSelectedItem();// fetc
				currentPattern = seletedDate;// the pattern we write is intialise in object
				showDateinLabel();// displaying written format in the currentlalbel block
			}
		});

		JLabel jlbResultHeading = new JLabel("Current Date/Time", JLabel.LEFT);
		jlbResult = new JLabel(" ");
		jlbResult.setForeground(Color.black);
		jlbResult.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));// mixture of two border

		setLayout(new GridLayout(4, 1, 0, 5));// hgap - 0 as only one row is present
		add(jlbHeading);
		add(patternList);
		add(jlbResultHeading);
		add(jlbResult);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		showDateinLabel();
	}

	public void showDateinLabel() {
		Date today = new Date();
		try {
			// formating todays date in label in next 4 lines
			SimpleDateFormat formatter = new SimpleDateFormat(currentPattern);
			String dateString = formatter.format(today);
			jlbResult.setForeground(Color.black);
			jlbResult.setText(dateString);
		} catch (IllegalArgumentException e) {
			// if wrong format is entered error with red color appear on the 2nd label
			jlbResult.setForeground(Color.red);
			jlbResult.setText("Error: " + e.getMessage());
		}
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("JComboBox Date Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DateComboBoxDemo());
		frame.pack();
		frame.setVisible(true);
	}
}