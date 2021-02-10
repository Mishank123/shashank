package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonDemo extends JPanel {

	JLabel jlbPicture;
	JRadioButton jrbNumbers, jrbAlphabets, jrbSymbols;
	RadioListener myListener = null;//handler in another class

	public JRadioButtonDemo() {
		jrbNumbers = new JRadioButton("Numbers");
		jrbNumbers.setMnemonic(KeyEvent.VK_N);//	jrbNumbers.setMnemonic("N");
		jrbNumbers.setActionCommand("numbers");
		jrbNumbers.setSelected(true);
		jrbAlphabets = new JRadioButton("Alphabets");
		jrbAlphabets.setMnemonic(KeyEvent.VK_A);
		jrbAlphabets.setActionCommand("alphabets");
		jrbSymbols = new JRadioButton("Symbols");
		jrbSymbols.setMnemonic(KeyEvent.VK_S);
		jrbSymbols.setActionCommand("symbols");
		
		ButtonGroup group = new ButtonGroup();//Button group object to group button----- one object for three button
		group.add(jrbNumbers);
		group.add(jrbAlphabets);
		group.add(jrbSymbols);
		
		myListener = new RadioListener();//action listener to group button 
		jrbNumbers.addActionListener(myListener);
		jrbAlphabets.addActionListener(myListener);
		jrbSymbols.addActionListener(myListener);
		
		jlbPicture = new JLabel(new ImageIcon(getClass().getResource("/images/numbers.jpg")));
		jlbPicture.setPreferredSize(new Dimension(177, 122));
		JPanel jplRadio = new JPanel();
		jplRadio.setLayout(new GridLayout(0, 1));
		jplRadio.add(jrbNumbers);
		jplRadio.add(jrbAlphabets);
		jplRadio.add(jrbSymbols);
		setLayout(new BorderLayout());
		add(jplRadio, BorderLayout.WEST);
		add(jlbPicture, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// creates empty border 
	}

	class RadioListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			jlbPicture.setIcon(new ImageIcon(getClass().getResource("/images/" + e.getActionCommand() + ".jpg")));//action command fetches name from set action command in line no 16.18.20..
		}
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("JRadioButton Usage Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JRadioButtonDemo(), BorderLayout.CENTER);
		frame.pack();// same as setBounds to set size of frame--------no need to mention size -componenet size= frame size
		frame.setVisible(true);
	}
}