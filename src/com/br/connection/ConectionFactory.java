package com.br.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
	     try {
	    	 
	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost/mercadorias", "root", "caique123tascano");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
