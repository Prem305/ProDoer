package com.valve.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField FName;
	private JTextField LName;
	private JTextField Pass;
	private JTextField CPass;
	private JTextField Email;
	String fName,lName,pass,cPass,e2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(106, 133, 117, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setBounds(359, 10, 95, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		FName = new JTextField();
		FName.setBounds(224, 136, 203, 20);
		contentPane.add(FName);
		FName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(106, 182, 117, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PASSWORD");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(106, 240, 117, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CONFIRM");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(106, 294, 117, 23);
		contentPane.add(lblNewLabel_1_3);
		
		LName = new JTextField();
		LName.setColumns(10);
		LName.setBounds(224, 186, 203, 20);
		contentPane.add(LName);
		
		Pass = new JTextField();
		Pass.setColumns(10);
		Pass.setBounds(224, 244, 203, 20);
		contentPane.add(Pass);
		
		JLabel first = new JLabel("");
		first.setForeground(Color.RED);
		first.setBounds(234, 161, 180, 14);
		contentPane.add(first);
		
		JLabel last = new JLabel("");
		last.setForeground(Color.RED);
		last.setBounds(234, 219, 180, 14);
		contentPane.add(last);
		
		JLabel pwd = new JLabel("");
		pwd.setForeground(Color.RED);
		pwd.setBounds(234, 275, 180, 14);
		contentPane.add(pwd);
		
		JLabel cpwd = new JLabel("");
		cpwd.setForeground(Color.RED);
		cpwd.setBounds(234, 325, 180, 14);
		contentPane.add(cpwd);
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(224, 85, 203, 20);
		contentPane.add(Email);
		
		JLabel email = new JLabel("");
		email.setForeground(Color.RED);
		email.setBounds(234, 111, 180, 14);
		contentPane.add(email);
		
		
		CPass = new JTextField();
		CPass.setColumns(10);
		CPass.setBounds(224, 298, 203, 20);
		contentPane.add(CPass);
		
		String fReg,lReg,pReg,eReg;
		fReg="^[a-zA-z0-9]{4}$";
		lReg="^[a-zA-z0-9]{4}$";
		eReg="^^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
		pReg="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$";
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f1,f2,f3,f4,f5;
				e2= Email.getText();
				fName=FName.getText();
				lName=LName.getText();
				pass=Pass.getText();
				cPass=CPass.getText();
				boolean f,l,e1,p,c;
				f=Pattern.compile("^[a-zA-z0-9]{4}$").matcher(FName.getText()).matches();
				l=Pattern.compile("^[a-zA-z0-9]{4}$").matcher(LName.getText()).matches();
				p=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$").matcher(Pass.getText()).matches();
				e1=Pattern.compile("\"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \r\n"
						+ "        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$\"").matcher(Email.getText()).matches();
				c=Pattern.compile(pass).matcher(CPass.getText()).matches();
				if(fName.isEmpty()&&lName.isEmpty()&&pass.isEmpty()&&cPass.isEmpty()) 
				{
					email.setText("EMAIL FIELD MANDATORY");
					email.setVisible(true);
					first.setText("*NAME FIELD MANDATORY");
					first.setVisible(true);
					last.setText("*NAME FIELD IS MANDATORY");
					last.setVisible(true);
					pwd.setText("*PASSWORD MANDATORY ");
					pwd.setVisible(true);
					cpwd.setText("*CONFIRM FIELD MANDATORY");
					cpwd.setVisible(true);
				}
				else if(f==false) 
				{
					first.setText("*Enter name with only alphabets");
					first.setVisible(true);
					f1=1;
				}
				else 
				{
					first.setVisible(false);
					f1=0;
				}
				if(l==false) 
				{
					last.setText("*Enter name with only alphabets");
					last.setVisible(true);
					f2=1;
				}
				else 
				{
					last.setVisible(false);
					f2=0;
				}
				if(e1==false) 
				{
					email.setText("*ENTER PROPER EMAIL");
					email.setVisible(true);
					f3=1;
				}
				else 
				{
					f3=0;
					email.setVisible(false);
				}
				if(p==false) 
				{
					pwd.setText("*ENTER A STRONG PASSWORD");
					pwd.setVisible(true);
					f4=1;
				}
				else 
				{
					pwd.setVisible(false);
					f4=0;
				}
				if(c==false) 
				{
					cpwd.setText("*CONFIRM FIELD MANDATORY");
					cpwd.setVisible(true);
					f5=1;
				}
				else 
				{
					cpwd.setVisible(false);
					f5=0;
				}
				
				
				if(f==true && l==true && e1==true && p==true && c==true) 
				{
					JOptionPane.showMessageDialog(null,"LOGINNNNNNNN123123123123123123123");
				}
				
			}
		});
		btnNewButton.setBounds(106, 436, 111, 31);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Email.setText("");
				FName.setText("");
				LName.setText("");
				Pass.setText("");
				CPass.setText("");
			}
		});
		btnReset.setBounds(255, 436, 111, 31);
		contentPane.add(btnReset);
		
		JLabel lEm = new JLabel("CONFIRM");
		lEm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lEm.setBounds(100, 85, 117, 23);
		contentPane.add(lEm);
		
		
		
	}
}
