package com.email.dao;

import com.email.entities.User;
import com.email.metier.IUser;

public class testAjout {

	public static void main(String[] args) {
		User user = new User(1,"ahmed","el alami","ahmed@mohamed.local","123456");
		IUser service = new UserDao();
		//	String result="";
			//if (service.findOne(email) != null) {
			

			  service.RegisterUser(user);

	}

}
