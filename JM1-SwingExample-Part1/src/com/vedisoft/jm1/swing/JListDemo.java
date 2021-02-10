package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListDemo extends JPanel {

	JLabel headerLabel;
	JLabel statusLabel;
	JPanel controlPanel;
	DefaultListModel<String> fruitsName;//<datatype>     1st model and its list--------use of generics
	JList<String> fruitList;//1st list
	DefaultListModel<String> vegName;//2nd model and its list
	JList<String> vegList;//2nd list
	JButton showButton;

	public JListDemo() {

		setLayout(new BorderLayout(0, 10));
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		add(headerLabel,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.CENTER);
		add(statusLabel,BorderLayout.SOUTH);

		headerLabel.setText("Control in action: JList");
		//starting of first list--------------------------->>>>>>>>>>>>>>>>>>>>>
		fruitsName = new DefaultListModel<String>();// creation of modelclass to handel data of list

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Peer");

		fruitList = new JList<String>(fruitsName);// to generate list of above model
		fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//to select single option
		fruitList.setSelectedIndex(0);//previously selected index
		fruitList.setVisibleRowCount(3);// 3 items of list to be visible on list at a time

		JScrollPane fruitListScrollPane = new JScrollPane(fruitList);// adding list to the scrollPane
		// end of first list------------------------------>>>>>>>>>>>>>>>>>>>>>>
		//starting of second list--------------------------->>>>>>>>>>>>>>>>>>>>>
		vegName = new DefaultListModel<String>();

		vegName.addElement("Lady Finger");
		vegName.addElement("Onion");
		vegName.addElement("Potato");
		vegName.addElement("Tomato");

		vegList = new JList<String>(vegName);//<angular bracket generics to show data type>
		vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//multiple list can be selected -
		//-to select multiple option you can select by ctrl+option
		vegList.setSelectedIndex(2);// 2nd index selected by default
		vegList.setVisibleRowCount(3);

		JScrollPane vegListScrollPane = new JScrollPane(vegList);
		// end of 2nd list and model----------------------------->>>>>>>>>>>>>>>>>>>>>
		showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {// anonymous action listener in inner class
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (fruitList.getSelectedIndex() != -1) {//atleast one option is selected
					data = "Fruits Selected: " + fruitList.getSelectedValue();// fetches all selected values
					statusLabel.setText(data);
				}
				if (vegList.getSelectedIndex() != -1) {
					data += " Vegetables selected: ";
				//	for (Object vegetable : vegList.getSelectedValues()) {// loop for multli selection of list
					//	data += vegetable + ",";//",";
					//}
					// new way to use function 
					for (int index: vegList.getSelectedIndices()) {
						data += vegName.elementAt(index)+",";
					}
				}
				data = data.substring(0,data.length());
				//data = data.substring(0,data.length()-1);// removes last comma
				statusLabel.setText(data);
			}
		});

		controlPanel.add(fruitListScrollPane);
		controlPanel.add(vegListScrollPane);
		controlPanel.add(showButton);

	}

	public static void main(String args[]) {
		JFrame f = new JFrame("JListDemo Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JListDemo());
		f.setBounds(10,10,600,180);
		f.setVisible(true);
	}
}
