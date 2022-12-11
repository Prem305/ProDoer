package com.valve.services;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Completed extends JFrame {

	JTextField taskName;
	public static String taskName1,taskDate,taskTime;
	public String com;
	private JPanel contentPane;
	HomePage pf = new HomePage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Completed frame = new Completed();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void setData(String a) 
	{
		com=a;
	}
	public void addTask(JPanel j) 
	{
		//taskName1=pf.name;
		//taskDate=pf.date;
		//taskTime=pf.time;
		taskName= new JTextField(com);
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setEditable(false);
		taskName.setForeground(Color.white);
		taskName.setBackground(Color.GREEN);
		j.add(taskName,BorderLayout.CENTER);
		revalidate();
	}
	public Completed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 11, 354, 446);
		panel.setLayout(new GridLayout(10,0));
		contentPane.add(panel);
		addTask(panel);
		System.out.println(""+com);
	}
}
