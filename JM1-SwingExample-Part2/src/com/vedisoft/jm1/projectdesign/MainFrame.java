package com.vedisoft.jm1.projectdesign;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.vedisoft.jm1.swing.class1.*;

public class MainFrame extends JFrame implements ActionListener {

	JDesktopPane desktopPane;
	JLabel statusLabel;
	UIManager.LookAndFeelInfo laf[];
	JMenuBar menuBar;
	JToolBar jToolBar;
	JPopupMenu jPopupMenu;

	public MainFrame() {
		setLayout(new BorderLayout());
		// 1.adding image to the background ------------------------------------>>>>
		desktopPane = new JDesktopPane() {// desktopPane covers frame
			ImageIcon icon;// Image is the interface
			Image image;
			{
				icon = new ImageIcon(getClass().getResource("/icons/background1.jpg"));
				image = icon.getImage();
			}
			@Override
			protected void paintComponent(Graphics g) {//already defined function overrided to cover the background  with image
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);// adding our image with function
			}
		};
		//2. fetching look and feel details from O.S
		laf = UIManager.getInstalledLookAndFeels();
		statusLabel = new JLabel("Sample Project Developed By Vedisoft Software and Education Services Pvt. Ltd.");
		desktopPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));// upside dark and down side light
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));// vice versa-lowered
		statusLabel.setFont(new Font("Time New Roman", Font.BOLD, 16));

		createToolBar();
		createMenuBar();
		createPopupMenu();

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		getContentPane().add(statusLabel, BorderLayout.SOUTH);

		setTitle("Vedisoft : Sample Project Design");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);// output will open on fullscreen mode
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/icons/p21.png"));// seting icon of the frame
		setIconImage(icon1.getImage());// changes icon of the image
		setVisible(true);
	}

	public void createToolBar() {
		jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/icons/p1.png")));
		btn1.setActionCommand("JLabelDemo");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("JLabel Demo Example");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/icons/p2.png")));
		btn2.setActionCommand("JButtonDemo1");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("JButton Demo Example 1");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/icons/p3.png")));
		btn3.setActionCommand("JButtonDemo2");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("JButton Demo Example 2");
		btn3.addActionListener(this);
		jToolBar.add(btn3);

		JButton btn4 = new JButton(new ImageIcon(getClass().getResource("/icons/p4.png")));
		btn4.setActionCommand("JCheckBoxDemo");
		btn4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn4.setToolTipText("JCheckBox Demo Example");
		btn4.addActionListener(this);
		jToolBar.add(btn4);

		JButton btn5 = new JButton(new ImageIcon(getClass().getResource("/icons/p5.png")));
		btn5.setActionCommand("JComboBoxDemo");
		btn5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn5.setToolTipText("JComboBox Demo Example");
		btn5.addActionListener(this);
		jToolBar.add(btn5);

		JButton btn6 = new JButton(new ImageIcon(getClass().getResource("/icons/p6.png")));
		btn6.setActionCommand("JFormattedFieldDemo");
		btn6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn6.setToolTipText("JFormattedField Demo Example");
		btn6.addActionListener(this);
		jToolBar.add(btn6);

		JButton btn7 = new JButton(new ImageIcon(getClass().getResource("/icons/p7.png")));
		btn7.setActionCommand("JListDemo");
		btn7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn7.setToolTipText("JList Demo Example");
		btn7.addActionListener(this);
		jToolBar.add(btn7);

		JButton btn8 = new JButton(new ImageIcon(getClass().getResource("/icons/p8.png")));
		btn8.setActionCommand("JProgressBarDemo");
		btn8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn8.setToolTipText("JProgressBar Demo Example");
		btn8.addActionListener(this);
		jToolBar.add(btn8);

		JButton btn9 = new JButton(new ImageIcon(getClass().getResource("/icons/p9.png")));
		btn9.setActionCommand("JRadioButtonDemo");
		btn9.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn9.setToolTipText("JRadioButton Demo Example");
		btn9.addActionListener(this);
		jToolBar.add(btn9);

		JButton btn10 = new JButton(new ImageIcon(getClass().getResource("/icons/p10.png")));
		btn10.setActionCommand("JSliderDemo");
		btn10.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn10.setToolTipText("JSlider Demo Example");
		btn10.addActionListener(this);
		jToolBar.add(btn10);

		JButton btn11 = new JButton(new ImageIcon(getClass().getResource("/icons/p11.png")));
		btn11.setActionCommand("JSpinnerDemo");
		btn11.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn11.setToolTipText("JSpinner Demo Example");
		btn11.addActionListener(this);
		jToolBar.add(btn11);

		JButton btn12 = new JButton(new ImageIcon(getClass().getResource("/icons/p12.png")));
		btn12.setActionCommand("JTextAreaDemo");
		btn12.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn12.setToolTipText("JTestArea Demo Example");
		btn12.addActionListener(this);
		jToolBar.add(btn12);

		jToolBar.addSeparator();

		JButton btn13 = new JButton(new ImageIcon(getClass().getResource("/icons/p13.png")));
		btn13.setActionCommand("Metal");
		btn13.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn13.setToolTipText("Metal Look And Feel");
		btn13.addActionListener(this);
		jToolBar.add(btn13);

		JButton btn14 = new JButton(new ImageIcon(getClass().getResource("/icons/p14.png")));
		btn14.setActionCommand("Motif");
		btn14.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn14.setToolTipText("Motif Look And Feel");
		btn14.addActionListener(this);
		jToolBar.add(btn14);

		JButton btn15 = new JButton(new ImageIcon(getClass().getResource("/icons/p15.png")));
		btn15.setActionCommand("Nimbus");
		btn15.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn15.setToolTipText("Nimbus Look And Feel");
		btn15.addActionListener(this);
		jToolBar.add(btn15);

		JButton btn16 = new JButton(new ImageIcon(getClass().getResource("/icons/p16.png")));
		btn16.setActionCommand("Windows");
		btn16.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn16.setToolTipText("Windows Look And Feel");
		btn16.addActionListener(this);
		jToolBar.add(btn16);

		JButton btn17 = new JButton(new ImageIcon(getClass().getResource("/icons/p17.png")));
		btn17.setActionCommand("WindowsClassic");
		btn17.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn17.setToolTipText("Windows Classic Look And Feel");
		btn17.addActionListener(this);
		jToolBar.add(btn17);
		add(jToolBar, BorderLayout.NORTH);
	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JMenu jMenu1 = new JMenu("Examples");
		jMenu1.setMnemonic('E');

		JMenu jMenu2 = new JMenu("Look And Feel");
		jMenu2.setMnemonic('L');

		JMenuItem menuItem1 = new JMenuItem("JLabel Demo", 
				new ImageIcon(getClass().getResource("/icons/p1.png")));
		menuItem1.setActionCommand("JLabelDemo");
		menuItem1.setMnemonic('L');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.Event.CTRL_MASK));
		//  new values of key comes from keyEvent class
		menuItem1.addActionListener(this);
		jMenu1.add(menuItem1);

		JMenuItem menuItem2 = new JMenuItem("JButton Demo 1", new ImageIcon(getClass().getResource("/icons/p2.png")));
		menuItem2.setActionCommand("JButtonDemo1");
		menuItem2.setMnemonic('1');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		jMenu1.add(menuItem2);

		JMenuItem menuItem3 = new JMenuItem("JButton Demo 2", new ImageIcon(getClass().getResource("/icons/p3.png")));
		menuItem3.setActionCommand("JButtonDemo2");
		menuItem3.setMnemonic('2');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		jMenu1.add(menuItem3);

		JMenuItem menuItem4 = new JMenuItem("JCheckBox Demo", new ImageIcon(getClass().getResource("/icons/p4.png")));
		menuItem4.setActionCommand("JCheckBoxDemo");
		menuItem4.setMnemonic('C');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		jMenu1.add(menuItem4);

		JMenuItem menuItem5 = new JMenuItem("JComboBox Demo", new ImageIcon(getClass().getResource("/icons/p5.png")));
		menuItem5.setActionCommand("JComboBoxDemo");
		menuItem5.setMnemonic('b');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);
		jMenu1.add(menuItem5);

		JMenuItem menuItem6 = new JMenuItem("JFormattedField Demo",
				new ImageIcon(getClass().getResource("/icons/p6.png")));
		menuItem6.setActionCommand("JFormattedFieldDemo");
		menuItem6.setMnemonic('F');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);
		jMenu1.add(menuItem6);

		JMenuItem menuItem7 = new JMenuItem("JProgressBar Demo",
				new ImageIcon(getClass().getResource("/icons/p7.png")));
		menuItem7.setActionCommand("JProgressBarDemo");
		menuItem7.setMnemonic('L');
		menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.Event.CTRL_MASK));
		menuItem7.addActionListener(this);
		jMenu1.add(menuItem7);

		JMenuItem menuItem8 = new JMenuItem("JRadioButton Demo",
				new ImageIcon(getClass().getResource("/icons/p8.png")));
		menuItem8.setActionCommand("JRadioButtonDemo");
		menuItem8.setMnemonic('L');
		menuItem8.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.Event.CTRL_MASK));
		menuItem8.addActionListener(this);
		jMenu1.add(menuItem8);

		JMenuItem menuItem9 = new JMenuItem("JSlider Demo", new ImageIcon(getClass().getResource("/icons/p9.png")));
		menuItem9.setActionCommand("JSliderDemo");
		menuItem9.setMnemonic('L');
		menuItem9.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.Event.CTRL_MASK));
		menuItem9.addActionListener(this);
		jMenu1.add(menuItem9);

		JMenuItem menuItem10 = new JMenuItem("JSpinner Demo", new ImageIcon(getClass().getResource("/icons/p10.png")));
		menuItem10.setActionCommand("JSpinnerDemo");
		menuItem10.setMnemonic('L');
		menuItem10.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.Event.CTRL_MASK));
		menuItem10.addActionListener(this);
		jMenu1.add(menuItem10);

		JMenuItem menuItem11 = new JMenuItem("JTextArea Demo", new ImageIcon(getClass().getResource("/icons/p11.png")));
		menuItem11.setActionCommand("JTextAreaDemo");
		menuItem11.setMnemonic('L');
		menuItem11.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem11.addActionListener(this);
		jMenu1.add(menuItem11);
// seperator used after 11 buttons
		jMenu1.addSeparator();

		JMenuItem menuItem13 = new JMenuItem("Exit");
		menuItem13.setActionCommand("Exit");
		menuItem13.setMnemonic('x');
		menuItem13.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.Event.CTRL_MASK));
		menuItem13.addActionListener(this);
		jMenu1.add(menuItem13);

		JCheckBoxMenuItem menuItem14 = new JCheckBoxMenuItem("Metal");
		menuItem14.setSelected(true);// selected by default ---------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>
		menuItem14.setActionCommand("Metal");
		menuItem14.setMnemonic('e');
		menuItem14.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		menuItem14.addActionListener(this);
		jMenu2.add(menuItem14);

		JCheckBoxMenuItem menuItem15 = new JCheckBoxMenuItem("Motif");
		menuItem15.setActionCommand("Motif");
		menuItem15.setMnemonic('f');
		menuItem15.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem15.addActionListener(this);
		jMenu2.add(menuItem15);

		JCheckBoxMenuItem menuItem16 = new JCheckBoxMenuItem("Nimbus");
		menuItem16.setActionCommand("Nimbus");
		menuItem16.setMnemonic('N');
		menuItem16.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		menuItem16.addActionListener(this);
		jMenu2.add(menuItem16);

		JCheckBoxMenuItem menuItem17 = new JCheckBoxMenuItem("Windows");
		menuItem17.setActionCommand("Windows");
		menuItem17.setMnemonic('W');
		menuItem17.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));
		menuItem17.addActionListener(this);
		jMenu2.add(menuItem17);

		JCheckBoxMenuItem menuItem18 = new JCheckBoxMenuItem("Windows Classic");
		menuItem18.setActionCommand("WindowsClassic");
		menuItem18.setMnemonic('C');
		menuItem18.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		menuItem18.addActionListener(this);
		jMenu2.add(menuItem18);

		ButtonGroup bg = new ButtonGroup();
		bg.add(menuItem14);
		bg.add(menuItem15);
		bg.add(menuItem16);
		bg.add(menuItem17);
		bg.add(menuItem18);

		menuBar.add(jMenu1);// adding example 
		menuBar.add(jMenu2);// adding  look and feel on the menubar
		setJMenuBar(menuBar);// function of JFrame class and add the menu bar on its location
		
		
		
	}
	// 3. 12 buttons then a seperator than 5 more buttons
	public void createPopupMenu() {
		JMenuItem menuItem1 = new JMenuItem("JLabel Demo", new ImageIcon(getClass().getResource("/icons/p1.png")));
		menuItem1.setActionCommand("JLabelDemo");
		menuItem1.setMnemonic('L');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);


		JMenuItem menuItem2 = new JMenuItem("JButton Demo 1", new ImageIcon(getClass().getResource("/icons/p2.png")));
		menuItem2.setActionCommand("JButtonDemo1");
		menuItem2.setMnemonic('1');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);


		JMenuItem menuItem3 = new JMenuItem("JButton Demo 2", new ImageIcon(getClass().getResource("/icons/p3.png")));
		menuItem3.setActionCommand("JButtonDemo2");
		menuItem3.setMnemonic('2');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);


		JMenuItem menuItem4 = new JMenuItem("JCheckBox Demo", new ImageIcon(getClass().getResource("/icons/p4.png")));
		menuItem4.setActionCommand("JCheckBoxDemo");
		menuItem4.setMnemonic('C');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);


		JMenuItem menuItem5 = new JMenuItem("JComboBox Demo", new ImageIcon(getClass().getResource("/icons/p5.png")));
		menuItem5.setActionCommand("JComboBoxDemo");
		menuItem5.setMnemonic('b');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);


		JMenuItem menuItem6 = new JMenuItem("JFormattedField Demo",
				new ImageIcon(getClass().getResource("/icons/p6.png")));
		menuItem6.setActionCommand("JFormattedFieldDemo");
		menuItem6.setMnemonic('F');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);


		JMenuItem menuItem7 = new JMenuItem("JProgressBar Demo",
				new ImageIcon(getClass().getResource("/icons/p7.png")));
		menuItem7.setActionCommand("JProgressBarDemo");
		menuItem7.setMnemonic('L');
		menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.Event.CTRL_MASK));
		menuItem7.addActionListener(this);


		JMenuItem menuItem8 = new JMenuItem("JRadioButton Demo",
				new ImageIcon(getClass().getResource("/icons/p8.png")));
		menuItem8.setActionCommand("JRadioButtonDemo");
		menuItem8.setMnemonic('L');
		menuItem8.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.Event.CTRL_MASK));
		menuItem8.addActionListener(this);


		JMenuItem menuItem9 = new JMenuItem("JSlider Demo", new ImageIcon(getClass().getResource("/icons/p9.png")));
		menuItem9.setActionCommand("JSliderDemo");
		menuItem9.setMnemonic('L');
		menuItem9.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.Event.CTRL_MASK));
		menuItem9.addActionListener(this);


		JMenuItem menuItem10 = new JMenuItem("JSpinner Demo", new ImageIcon(getClass().getResource("/icons/p10.png")));
		menuItem10.setActionCommand("JSpinnerDemo");
		menuItem10.setMnemonic('L');
		menuItem10.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.Event.CTRL_MASK));
		menuItem10.addActionListener(this);


		JMenuItem menuItem11 = new JMenuItem("JTextArea Demo", new ImageIcon(getClass().getResource("/icons/p11.png")));
		menuItem11.setActionCommand("JTextAreaDemo");
		menuItem11.setMnemonic('L');
		menuItem11.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem11.addActionListener(this);


		jPopupMenu = new JPopupMenu();// created a popmenu and added all 11 items
		jPopupMenu.add(menuItem1);
		jPopupMenu.add(menuItem2);
		jPopupMenu.add(menuItem3);
		jPopupMenu.add(menuItem4);
		jPopupMenu.add(menuItem5);
		jPopupMenu.add(menuItem6);
		jPopupMenu.add(menuItem7);
		jPopupMenu.add(menuItem8);
		jPopupMenu.add(menuItem9);
		jPopupMenu.add(menuItem10);
		jPopupMenu.add(menuItem11);
		
		desktopPane.setComponentPopupMenu(jPopupMenu);// memberfunction comes from desktoppane---add popupmenu to the desktop  by this on rightclicking on the desktoppane 
		//pop up menu appears
		
	}
// same action performed will be called on clicking on either of the toolbar
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		int i = -1;
		if (str.equals("Metal")) {
			i = 0;
		} else if (str.equals("Nimbus")) {
			i = 1;
		} else if (str.equals("Motif")) {
			i = 2;
		} else if (str.equals("Windows")) {
			i = 3;
		} else if (str.equals("WindowsClassic")) {
			i = 4;
		}

		if (i > -1) {
			try {
				UIManager.setLookAndFeel(laf[i].getClassName());// change the look and feel to current index
				SwingUtilities.updateComponentTreeUI(this);// updates the look and feel
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Unable to Apply Look And Feel");
			}
			return;
		}

		JInternalFrame internalFrame = new JInternalFrame("Title", true, true, true, true);
		if (str.equals("JLabelDemo")) {
			internalFrame.setTitle("JJLabel Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p1.png")));// internal frame icon
			internalFrame.setContentPane(new JLabelDemo());
		} else if (str.equals("JButtonDemo1")) {
			internalFrame.setTitle("JButton Demo Example 1");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p2.png")));
			internalFrame.setContentPane(new JButtonDemo());
		} else if (str.equals("JButtonDemo2")) {
			internalFrame.setTitle("JButton Demo Example 2");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p3.png")));
			internalFrame.setContentPane(new JButtonGraphics());
		} else if (str.equals("JCheckBoxDemo")) {
			internalFrame.setTitle("JCheckBox Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p4.png")));
			internalFrame.setContentPane(new JCheckBoxDemo());
		} else if (str.equals("JComboBoxDemo")) {
			internalFrame.setTitle("JComboBox Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p5.png")));
			internalFrame.setContentPane(new JComboBoxDemo());
		} else if (str.equals("JFormattedFieldDemo")) {
			internalFrame.setTitle("JFormattedField Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p6.png")));
			internalFrame.setContentPane(new JFormattedFieldDemo());
		} else if (str.equals("JListDemo")) {
			internalFrame.setTitle("JListDemo");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p7.png")));
			internalFrame.setContentPane(new JListDemo());
		} else if (str.equals("JProgressBarDemo")) {
			internalFrame.setTitle("JProgressBar Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p8.png")));
			internalFrame.setContentPane(new JProgressBarDemo());
		} else if (str.equals("JRadioButtonDemo")) {
			internalFrame.setTitle("JRadioButton Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p9.png")));
			internalFrame.setContentPane(new JRadioButtonDemo());
		} else if (str.equals("JSliderDemo")) {
			internalFrame.setTitle("JSlider Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p10.png")));
			internalFrame.setContentPane(new JSliderDemo());
		} else if (str.equals("JSpinnerDemo")) {
			internalFrame.setTitle("JSpinner Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p11.png")));
			internalFrame.setContentPane(new JSpinnerDemo());
		} else if (str.equals("JTextAreaDemo")) {
			internalFrame.setTitle("JTextArea Demo Example");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icons/p12.png")));
			internalFrame.setContentPane(new JTextAreaDemo());
		} else if (str.equals("Exit")) {
			System.exit(0);
		}
		internalFrame.pack();
		internalFrame.setVisible(true);
		desktopPane.add(internalFrame, new Integer(1));// layer no is 1 therefore on clicking on the opened block that comes on foreground
	}

	public static void main(String args[]) {
		new MainFrame();
	}
}
