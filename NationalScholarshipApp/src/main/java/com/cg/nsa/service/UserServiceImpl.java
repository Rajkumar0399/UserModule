package com.cg.nsa.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.nsa.repository.IUserRepository;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;

public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository dao;

	@Override
	public User login(User user) throws InvalidCredentialsException {
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

	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		User user1=dao.findByUserId(user.getUserId());
		if(user.isLogin())
		{
			user.logout();
			System.out.println("Successfully logged out");
		}
		
		return user;
	}
	

}

