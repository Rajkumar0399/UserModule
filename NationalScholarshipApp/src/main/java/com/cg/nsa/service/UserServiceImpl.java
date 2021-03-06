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
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public User login(User user) {
          
		// TODO Auto-generated method stub
	   User user1=dao.findByUserId(user.getUserId());
	   
	   if(user1!=null && user.getPassword().equals(user1.getPassword()) &&
	   user.getRole().equals(user1.getRole())) {
		   
		   user1.login();
		   return dao.save(user1);
	   }
	   else 
		   throw new InvalidCredentialsException();
	  }
	
	
	 /******************************************************
	 
     * @return this method returns a user object
     * @param this method takes User object parameter
     
     *******************************************************
     */


	@Override
	@Transactional
	public User logout(User user) {
		// TODO Auto-generated method stub
		User user1=dao.findByUserId(user.getUserId());
		
		if(user1.isLogin()==1)
		{
			user1.logout();
			
		}
		else
			   throw new InvalidCredentialsException();
		return dao.save(user1);
	}
	
}

