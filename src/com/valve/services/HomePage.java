package com.valve.services;
//import com.toedter.calendar.JDateChooser;
import com.valve.dao.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField taskname;
	private JTextField taskdate;
	private JTextField tasktime;
	private JTextField taskno;
	public String no;
	 public String name,date,time;
	 DataBase b = null;

	 
	   public void setName(String s) 
	 {
		 name=s;
	 }
	 public void setDate(String s) 
	 {
		 date=s;
	 }
	 public void setTime(String s) 
	 {
		 time=s;
	 }
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRO-DOER");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 27));
		lblNewLabel.setBounds(313, 11, 167, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 771, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ICON");
		lblNewLabel_1.setBounds(10, 55, 54, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HI,USER LETS COMPLETE TODAY'S TASK");
		lblNewLabel_2.setBounds(79, 55, 227, 28);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(340, 58, 421, 399);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10,0));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 81, 306, 2);
		contentPane.add(separator_1);
		JLabel t1 = new JLabel("*PLEASE ENTER NAME");
		t1.setForeground(Color.RED);
		t1.setBounds(30, 206, 157, 14);
		contentPane.add(t1);
		
		JLabel t2 = new JLabel("*PLEASE ENTER DATE");
		t2.setForeground(Color.RED);
		t2.setBounds(30, 275, 157, 14);
		contentPane.add(t2);
		
		JLabel t3 = new JLabel("*PLEASE ENTER TIME");
		t3.setForeground(Color.RED);
		t3.setBounds(30, 342, 157, 14);
		contentPane.add(t3);
		
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("TASK NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 155, 96, 28);
		contentPane.add(lblNewLabel_1_1);
		
		taskname = new JTextField();
		taskname.setBounds(20, 180, 182, 20);
		contentPane.add(taskname);
		taskname.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date to Complete");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 216, 187, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		taskdate = new JTextField();
		taskdate.setColumns(10);
		taskdate.setBounds(20, 244, 182, 20);
		contentPane.add(taskdate);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("TIME OF COMPLETITION");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(5, 286, 192, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tasktime = new JTextField();
		tasktime.setColumns(10);
		tasktime.setBounds(20, 311, 182, 20);
		contentPane.add(tasktime);
		panel.setVisible(true);
		
		taskno = new JTextField();
		taskno.setColumns(10);
		taskno.setBounds(10, 114, 182, 20);
		contentPane.add(taskno);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int no;
				//name=taskname.getText();
				//date=taskdate.getText();
				//time=tasktime.getText();
				if(taskname.getText().isEmpty()|| taskdate.getText().isEmpty()|| tasktime.getText().isEmpty()) 
				{
					t1.setVisible(true);
					t2.setVisible(true);
					t3.setVisible(true);
				}else 
				{
					t1.setVisible(false);
					t2.setVisible(false);
					t3.setVisible(false);
					no=taskno.getText();
				setName(taskname.getText());
				setDate(taskdate.getText());
				setTime(tasktime.getText());
				Task task= new Task(no,name, date, time);
				ArrayList<String> al= new ArrayList<String>();
				al.add(taskno.getText());
				al.add(taskname.getText());
				al.add(taskdate.getText());
				al.add(tasktime.getText());
				al.add("Pending");
				b= new DataBase();
				int j = b.insertData(al);
				b.getName(taskname.getText());
				System.out.print(""+j);
				panel.add(task);
				revalidate();
				taskno.setText("");
				taskname.setText("");
				taskdate.setText("");
				tasktime.setText("");
				task.getTaskInfo(panel);
				}
			}
		});
		btnNewButton.setBounds(58, 356, 114, 64);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("TASK NO");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 87, 96, 28);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("SHOW COMPLETED TASKS");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Completed c4 = new Completed();
				c4.setVisible(true);
			}
		});
		lblNewLabel_3.setBounds(47, 443, 187, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		
	}
}
