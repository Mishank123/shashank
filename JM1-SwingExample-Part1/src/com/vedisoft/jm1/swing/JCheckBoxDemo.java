package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheckBoxDemo extends JPanel {

	JCheckBox jcbChin;
	JCheckBox jcbGlasses;
	JCheckBox jcbHair;
	JCheckBox jcbTeeth;

	StringBuffer choices;
	JLabel jlbPicture;
	CheckBoxListener myListener = null;

	public JCheckBoxDemo() {

		myListener = new CheckBoxListener();

		jcbChin = new JCheckBox("Chin");
		jcbChin.setMnemonic(KeyEvent.VK_C);
		jcbChin.setSelected(true);
		jcbChin.addItemListener(myListener);

		jcbGlasses = new JCheckBox("Glasses");
		jcbGlasses.setMnemonic(KeyEvent.VK_G);
		jcbGlasses.setSelected(true);
		jcbGlasses.addItemListener(myListener);//itemlistener looks for itemstatechange

		jcbHair = new JCheckBox("Hair");
		jcbHair.setMnemonic(KeyEvent.VK_H);
		jcbHair.setSelected(true);
		jcbHair.addItemListener(myListener);

		jcbTeeth = new JCheckBox("Teeth");
		jcbTeeth.setMnemonic(KeyEvent.VK_T);
		jcbTeeth.setSelected(true);
		jcbTeeth.addItemListener(myListener);

		choices = new StringBuffer("cght");

		jlbPicture = new JLabel(
				new ImageIcon(getClass().getResource("/images/geek-" + choices.toString().trim() + ".gif")));
		jlbPicture.setToolTipText(choices.toString().trim());

		JPanel jplCheckBox = new JPanel();
		jplCheckBox.setLayout(new GridLayout(0, 1)); // 0 rows, 1 Column
		jplCheckBox.add(jcbChin);
		jplCheckBox.add(jcbGlasses);
		jplCheckBox.add(jcbHair);
		jplCheckBox.add(jcbTeeth);

		setLayout(new BorderLayout());
		add(jplCheckBox, BorderLayout.WEST);
		add(jlbPicture, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int index = 0;
			char c = '-';
			Object source = e.getSource();
			if (source == jcbChin) {
				index = 0;
				c = 'c';
			} else if (source == jcbGlasses) {
				index = 1;
				c = 'g';
			} else if (source == jcbHair) {
				index = 2;
				c = 'h';
			} else if (source == jcbTeeth) {
				index = 3;
				c = 't';
			}

			if (e.getStateChange() == ItemEvent.DESELECTED)
				c = '-';

			choices.setCharAt(index, c);//changes letter with '-' symbol
			jlbPicture.setIcon(
					new ImageIcon(getClass().getResource("/images/geek-" + choices.toString().trim() + ".gif")));
			jlbPicture.setToolTipText(choices.toString());
		}
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("JCheckBox Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JCheckBoxDemo());
		frame.pack();
		frame.setVisible(true);
	}

}
