package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	  
	    private int id;
	  
	    private String userName;
	    private String password;
	    private boolean active=true;
	    private String roles="ROLE_USER";
	    private String name;
	   
	    
		public User() {
			super();
		}
		public User(int id, String userName, String password, boolean active, String roles,String name) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.active = active;
			this.roles = roles;
			this.name = name;
		
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			
			this.active = active;
		}
		public String getRoles() {
			return roles;
		}
		public void setRoles(String roles) {
			
			this.roles = roles;
		}
	
		
	    
	   
	    
	    
	    
}
