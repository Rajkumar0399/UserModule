/********************************************************
 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the sevice method implementation of IUserService interface
 * Created date: 22-04-2021
 
 * ******************************************************
 */
package com.cg.nsa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.repository.IUserRepository;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	
	IUserRepository dao;
	
	/******************************************************
	 
     * @return this method returns a user object
     * @param this method takes User object parameter
     * @throws this method throws InvalidCredentialsException
     
     *******************************************************
     */

	@Override
	public User login(User user) {
          
		// TODO Auto-generated method stub
	   User user1=dao.findByUserId(user.getUserId());
	   
	   if(user.getPassword().equals(user1.getPassword()) &&
	   user.getRole().equals(user1.getRole())) {
		   
		   user.login();
		   System.out.println("Successfully logged in");
		   
		   return user1;
	   }
	   else 
		   throw new InvalidCredentialsException("Invalid Credentials");
	  }
	
	
	 /******************************************************
	 
     * @return this method returns a user object
     * @param this method takes User object parameter
     
     *******************************************************
     */


	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		User user1=dao.findByUserId(user.getUserId());
		if(user.isLogin()==1)
		{
			user.logout();
			System.out.println("Successfully logged out");
		}
		return user;
	}
	
}

