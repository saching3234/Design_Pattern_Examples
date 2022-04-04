package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con=null;	
	
	//method to get the connection object
	public static Connection mysqlConnectio() {
	    //checking if the connection already exist or not 	
	      if(con==null) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/flightbooking";
                        con=DriverManager.getConnection(url,"root","root");
			System.out.println("Connection to db successfull");			
			
		}catch(Exception ex) {
			System.out.println("Error While Connecting to db"+ex.toString());
		}
		
	   }
	
	   return con;
	}
	
	
    
	//main method to test 
	public static void main(String[] args) {
		System.out.println(mysqlConnectio());
	}

}
