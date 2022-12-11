package com.valve.services;
import com.valve.dao.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Task extends JPanel {

	/**
	 * Create the panel.
	 */
	public String task1;
	public String date;
	public String time;
	public JLabel index;
	public JTextField taskName;
	public JButton done;
	public int TaskCompleted=0;
	public boolean checked;
	public String a,b,c;
	DataBase d = null;
	//public JDateChooser jc = new JDateChooser();
	public JPanel getTaskInfo(JPanel jp) 
	{
		return jp;
		
	}
	public String taskname() 
	{
		return a;
		
	}
	public String datename() 
	{
		return b;
	}
	public String timename() 
	{
		return c;
	}
	@SuppressWarnings("deprecation")
	public Task(String n,String name, String date, String time) {
		this.task1=name;
		this.date=date;
		this.time=time;
		String no=n;
		this.setPreferredSize(new Dimension(40,40));
		this.setBackground(Color.red);
		this.setLayout(new BorderLayout());
		checked=false;
		Completed c4 = new Completed();
		a=this.task1;
		b=this.date;
		c=this.time;
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20,20));
		index.setHorizontalAlignment(JLabel.CENTER);
		index.setForeground(Color.white);
		this.add(index,BorderLayout.WEST);
		//MenuBar mb = new MenuBar();
		JPopupMenu jp = new JPopupMenu();
		JMenuItem i1 = new JMenuItem("CHANGE TASK NAME");
		JMenuItem i2 = new JMenuItem("CHANGE TASK DATE");
		JMenuItem i3 = new JMenuItem("CHANGE TASK TIME");
		JMenuItem i4 = new JMenuItem("CHANGE TASK TO COMPLETED");
		jp.add(i1);
		jp.add(i2);
		jp.add(i3);
		jp.add(i4);
		
	
		taskName= new JTextField(task1+"          :          "+date+"     :     "+time);
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setEditable(false);
		taskName.setForeground(Color.white);
		taskName.setBackground(Color.red);
		this.add(taskName,BorderLayout.CENTER);
		done= new JButton("DONE");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		this.add(done,BorderLayout.EAST);
		HomePage pf = new HomePage();
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String data= taskName.getText();
				taskName.setBackground(Color.GREEN);
				String date1="COMPLETED";
				String time1="COMPLETED";
				taskName.setText(task1+"            "+date1+"     "+time1);
				int i=d.updateStatus(no);
				System.out.println(i);
				revalidate();
				c4.setData(data);
				TaskCompleted++;
				
				
			}
		});
		taskName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s,d,f;
				
			}
		});
		
		
		

	}

}
