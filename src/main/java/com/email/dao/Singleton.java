package com.email.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.email.dao.Singleton;

public class Singleton {
	private static Singleton uniqueInstance;	
	private Singleton() {
	
	}
	
	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.112.142:3306/projetMail?characterEncoding=utf8", "userdb","Mohamed0000++");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Erreur de pilote : " + ex.getMessage());
		}
		catch(SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return conn;
	}
	
	// test connetion 
//   public static void  main(String args[]) {
//	Singleton sing =getInstance();
//	Connection conn =sing.getConnection();
//    if (conn == null) 
//	System.out.println("Faild");
//	else		System.out.println("succusful ");}
	
//	

	
}

