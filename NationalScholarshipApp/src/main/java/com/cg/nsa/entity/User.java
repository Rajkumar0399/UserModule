/********************************************************
 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the user entity class 
 * Created date: 20-04-2021
 
 * ******************************************************
 */
package com.cg.nsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name="user10")
@Inheritance(strategy = InheritanceType.JOINED)
public class User 
{
	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	private int loggedin;
	
	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.loggedin=0;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void login()
	{
		this.loggedin=1;
	}
     public int isLogin()
     {
    	 return this.loggedin;
    	 
     }
     public void logout()
 	{
 		this.loggedin=0;
 	}
     
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
