package com.valve.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "System";
	private static String pass= "root";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	public static String name;
	
	public int insertData(ArrayList a) 
	{
		String sql;
		PreparedStatement stm= null;
		Connection con = null;
		Statement stmt= null;
		int b=0;
		try {
		Class.forName(driver);
		con= DriverManager.getConnection(url, user, pass);
		stmt = con.createStatement();
		sql="insert into premTask values(?,?,?,?,?)";
		stm=con.prepareStatement(sql);
		

		stm.setString(1, (String) a.get(0));
		stm.setString(2, (String) a.get(1));
		stm.setString(3, (String) a.get(2));
		stm.setString(4, (String) a.get(3));
		stm.setString(5, (String) a.get(4));
		
		b=stm.executeUpdate();
		
		}  
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return b;
	}
	public void getName(String s) {
		DataBase.name=s;
	}
	public void getName1(String text) {
		// TODO Auto-generated method stub
		DataBase.name=text;}
	
	public int updateStatus(String t) {
		
		
		String sql;
		PreparedStatement stm= null;
		Connection con = null;
		Statement stmt= null;
		int no= Integer.parseInt(t);
		int b=0;
		try {
		Class.forName(driver);
		con= DriverManager.getConnection(url, user, pass);
		stmt = con.createStatement();
		sql="Update premTask set TaskStatus='Completed' where TaskId=''"+no;
		stm=con.prepareStatement(sql);
		b= stm.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return b;
	}
	
		
	}

	
