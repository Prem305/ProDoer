package com.valve.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 27));
		lblNewLabel.setBounds(161, 11, 102, 49);
		contentPane.add(lblNewLabel);
		
		userField = new JTextField();
		userField.setBounds(165, 87, 151, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(80, 87, 75, 20);
		contentPane.add(lblNewLabel_1);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(165, 141, 151, 20);
		contentPane.add(passField);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(53, 137, 102, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel userLabel = new JLabel("");
		userLabel.setForeground(Color.RED);
		userLabel.setBounds(161, 118, 212, 14);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("");
		passLabel.setForeground(Color.RED);
		passLabel.setBounds(161, 172, 212, 14);
		contentPane.add(passLabel);
		userLabel.setVisible(false);
		passLabel.setVisible(false);
		
		
		String passRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		String userRegex="^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
		
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 boolean u,p;
				
				String user= userField.getText();
				String pass= passField.getText();
				u=Pattern.compile(userRegex).matcher(user).matches();
				p=Pattern.compile(passRegex).matcher(pass).matches();
				if(user.isEmpty()&& pass.isEmpty()) 
				{
					userLabel.setText("*USER NAME REQUIRED FIELD");
					passLabel.setText("*PASSWORD REQUIRED FIELD");
					userLabel.setVisible(true);
					passLabel.setVisible(true);
				}
				//userLabel.setVisible(false);
				//passLabel.setVisible(false);
				
				else if(u==false && p==false) 
				{
						userLabel.setText("*INCORRECT USER ID");
						passLabel.setText("*INCORRECT PASSWORD");
						passLabel.setVisible(true);
						userLabel.setVisible(true);
					
				}
				else if(u==false) 
				{
					userLabel.setText("*INCORRECT USER ID");
					userLabel.setVisible(true);
				}
				else if(p==false) 
				{
					passLabel.setText("*INCORRECT PASSWORD");
					passLabel.setVisible(true);
				}
				else if(u==true && p==true)
				{
					JOptionPane.showMessageDialog(btnNewButton, e, "Login Success", ABORT);;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(187, 206, 102, 30);
		contentPane.add(btnNewButton);
		
		
	}
}
