package com.vedisoft.jm1.swing;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class JFileChooserDemo extends JPanel implements ActionListener {

	JButton btnOpen, btnSave, btnFolderBrowser;
	JLabel lblFile;

	public JFileChooserDemo() {
		setLayout(new FlowLayout());
		btnOpen = new JButton("File Open");
		btnSave = new JButton("File Save");
		btnFolderBrowser = new JButton("Folder Browser");
		lblFile = new JLabel("Selected File :");
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		btnFolderBrowser.addActionListener(this);

		add(btnOpen);
		add(btnSave);
		add(btnFolderBrowser);
		add(lblFile);
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals("File Open")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("."));// current folder should be visible
			jFileChooser.setMultiSelectionEnabled(true);// user can select multiple files
			int result = jFileChooser.showOpenDialog(this);// display the opened dialog
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFiles[] = jFileChooser.getSelectedFiles();// returns the multiple selected files
				StringBuilder sb = new StringBuilder();// lang package class -to add the path as it has append function 
				sb.append("Selected Files : ");
				for (File file : selectedFiles)// runs the no of files selected-----due to string builder its appends like A,B,C,
					sb.append(file.getAbsolutePath() + ",");// adds the path of the selected file on the label
				sb.deleteCharAt(sb.length() - 1);
				lblFile.setText("Selected file: " + sb);
			}
		} else if (str.equals("File Save")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("."));
			int result = jFileChooser.showSaveDialog(this);// show dialog has 2 btn save and cancel
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				lblFile.setText("Selected file: " + selectedFile.getAbsolutePath());
			}
		} else if (str.equals("Folder Browser")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("."));
			jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// only directory will be visible
			int result = jFileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				lblFile.setText("Selected file: " + selectedFile.getAbsolutePath());
			}
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFileChooser Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JFileChooserDemo());
		frame.setBounds(100, 100, 400, 150);
		frame.setVisible(true);
	}
}
