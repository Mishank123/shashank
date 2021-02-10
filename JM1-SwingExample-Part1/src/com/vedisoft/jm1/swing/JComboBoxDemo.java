package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxDemo extends JPanel {

	JComboBox<String> comboTypesList;
	JLabel jlbPicture;

	public JComboBoxDemo() {
		String[] comboTypes = { "Numbers", "Alphabets", "Symbols" };// array of combobox

		comboTypesList = new JComboBox<String>(comboTypes);// passing array to combobox
		comboTypesList.setSelectedIndex(2);// by default 2nd index selected
		comboTypesList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbType = (JComboBox) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();// return the selected item from list e.g alphebets
				jlbPicture.setIcon(
						new ImageIcon(getClass().getResource("/images/" + cmbType.trim().toLowerCase() + ".jpg")));
			}
		});

		jlbPicture = new JLabel(new ImageIcon(
				getClass().getResource("/images/" + comboTypes[comboTypesList.getSelectedIndex()] + ".jpg")));
		jlbPicture.setPreferredSize(new Dimension(177, 132));// tells width and height of level in pixel

		setLayout(new BorderLayout(0,5));//hgap-0 vgap-5
		add(comboTypesList, BorderLayout.NORTH);
		add(jlbPicture, BorderLayout.SOUTH);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("JComboBox Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JComboBoxDemo());// contentpane- centre part of frame
		frame.pack();
		frame.setVisible(true);
	}
}
