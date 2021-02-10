package com.vedisoft.jm1.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.*;

public class JSliderDemo extends JPanel implements ChangeListener {
	JSlider s1, s2, s3;
	JLabel l1;
	Hashtable<Integer, JLabel> h = new Hashtable<>();
	{
		h.put(0, new JLabel("Zero"));// image icon can also be used instead of text
		h.put(10, new JLabel("Ten"));
		h.put(20, new JLabel("Twenty"));
		h.put(30, new JLabel("Thirty"));
		h.put(40, new JLabel("Forty"));
		h.put(50, new JLabel("Fifty"));
	}

	public JSliderDemo() {
		setLayout(new FlowLayout());

		s1 = new JSlider();
		s2 = new JSlider(0, 50, 10);
		s3 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
		l1 = new JLabel("Value : ");

		// almost every property of slider
		s1.setValue(20);// 
		s1.setMinimum(10);
		s1.setMaximum(40);
		s1.setValue(42);// default display
		s1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		s1.setMinorTickSpacing(5);
		s1.setMajorTickSpacing(10);
		s1.setPaintLabels(true);
		s1.setPaintTicks(true);
		s1.setSnapToTicks(true);// displays  the tick mark on the nearest tick
		s1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		s1.addChangeListener(this);

		s2.setMajorTickSpacing(10);
		s2.setPaintLabels(true);
		s2.setLabelTable(h);
		s2.setOrientation(JSlider.VERTICAL);// vertical slider

		s3.setMinorTickSpacing(5);
		s3.setMajorTickSpacing(10);
		s3.setPaintLabels(true);
		s3.setPaintTicks(true);
		s3.setExtent(20);

		add(s1);
		add(s2);
		add(s3);
		add(l1);
	}

	@Override
	public void stateChanged(ChangeEvent e) {// on clicking change listener will be called
		JSlider js = (JSlider) e.getSource();
		l1.setText("Value : " + js.getValue());
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("JSlider Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JSliderDemo());
		frame.setBounds(10, 10, 600, 300);
		frame.setVisible(true);
	}
}// used to take feedback