package com.email.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;

import com.email.entities.User;
import com.email.metier.IUser;

public class UserDao implements IUser {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public void RegisterUser(User user) {
	
		 try {
			 
			 			Connection conn = Singleton.getInstance().getConnection();
			 			PreparedStatement stmt = conn.prepareStatement("INSERT INTO virtual_users (domain_id,First_name, Last_name, email, password)\r\n"
			 					+ "VALUES (1, ?, ?, ?, ?);");
			 			stmt.setString(1, user.getFirstName());
			 			stmt.setString(2, user.getLastName());
			 			stmt.setString(3, user.getEmail());
			 			stmt.setString(4, user.getPassword());
			 			stmt.execute();
			 			System.out.println("add avec seccus");
			 		} catch (SQLException ex) {
			 			System.out.println("Erreur SQL : " + ex.getMessage());
			 		}
		 
	 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	/*	    
		    int i = 0;
		    try {
		    Connection conn = Singleton.getInstance().getConnection();
		     
  
		    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO virtual_users(First_name,Last_name,email,password) VALUES (?,?,?,?)");
		    preparedStatement.setString(1, user.getFirstName());
		      preparedStatement.setString(2, user.getLastName());
		      preparedStatement.setString(3, user.getEmail());
		      preparedStatement.setString(4, user.getPassword());
              
		      preparedStatement.execute();
			    i=1;  
    

		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    if (i != 0) {
		      return "User is registered";
		    } else {
		      return "Error!!!!";
		    }
		  */
	
	
	
	
	
	
	@Override
	
	public boolean findOne(String  email) {
		
		
		try {
             
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT email FROM virtual_users WHERE email = ?");
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				
				return true;
			} else return false;
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
			
		}
		return false;
	}
	 
	 
	

//	@Override
//	public Collection<User> findAll() {
//		Collection<User> users = new ArrayList<User>();
//		try {
//
//			Connection conn = Singleton.getInstance().getConnection();
//			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM virtual_users");
//			ResultSet result = stmt.executeQuery();
//			while(result.next()) {
//				int id = result.getInt("id");
//				String firstName = result.getString("firstName");
//				String lastName = result.getString("lastName");
//				String email = result.getString("email");
//				String password = result.getString("password");
//				User user = new User(id, firstName, lastName, email,password);
//				users.add(user);
//			}
//		} catch (SQLException ex) {
//			System.out.println("Erreur SQL : " + ex.getMessage());
//		}
//		return users;
//	}

//	@Override
//	public void add(User user) {
//		try {
//
//			Connection conn = Singleton.getInstance().getConnection();
//			PreparedStatement stmt = conn.prepareStatement("INSERT INTO virtual_users(id,First_name,Last_name,email,password)	 VALUES (NULL, ?, ?, ?, ?)");
//			stmt.setString(1, user.getFirstName());
//			stmt.setString(2, user.getLastName());
//			stmt.setString(3, user.getEmail());
//			stmt.setString(4, user.getPassword());
//			stmt.execute();
//		} catch (SQLException ex) {
//			System.out.println("Erreur SQL : " + ex.getMessage());
//		}
//	}

//	@Override
//	public void update(User user) {
//		try {
//
//			Connection conn = Singleton.getInstance().getConnection();
//			PreparedStatement stmt = conn.prepareStatement("UPDATE virtual_users SET nom = ?, prenom = ?, note = ? WHERE id = ?");
//			stmt.setString(1, user.getFirstName());
//			stmt.setString(2, user.getLastName());
//			stmt.setString(3, user.getEmail());
//			stmt.setString(3, user.getPassword());
//			stmt.setInt(4, user.getId());
//			stmt.execute();
//		} catch (SQLException ex) {
//			System.out.println("Erreur SQL : " + ex.getMessage());
//		}
//	}

//	@Override
//	public void delete(int id) {
//		try {
//
//			Connection conn = Singleton.getInstance().getConnection();
//			PreparedStatement stmt = conn.prepareStatement("DELETE FROM virtual_users WHERE id = ?");
//			stmt.setInt(1, id);
//			stmt.execute();
//		} catch (SQLException ex) {
//			System.out.println("Erreur SQL : " + ex.getMessage());
//		}
//	}

	
	
}
