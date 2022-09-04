package com.email.entities;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	private int id;
	
	private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    
	    
	    public User(int id2,String firstName2, String lastName2, String email2, String password2) {
	    	this.id=id2;
	    	this.firstName=firstName2;
			this.lastName=lastName2;
			this.email=email2;
			this.password=password2;
		}
	    public User(String firstname2, String lastname2, String email2, String password2) {
	    	this.firstName=firstname2;
			this.lastName=lastname2;
			this.email=email2;
			this.password=password2;
		}
	    public User() {
	    	
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    }




