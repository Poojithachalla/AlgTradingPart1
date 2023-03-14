package com.newproject.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrderDAO {
	
	String url = "jdbc:mysql://localhost:3306/AlgorithmicTrading";
    String username= "root";
    String pass = "Myworld";
   String dbDriver = "com.mysql.cj.jdbc.Driver";
   public void loadDriver(String dbDriver) {
   	
   	try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	
   }
	  
	  public Connection getConnection() {
		  Connection con = null;
		try {
			con =  DriverManager.getConnection(url,username,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	
        
	  }
	  
	

}
