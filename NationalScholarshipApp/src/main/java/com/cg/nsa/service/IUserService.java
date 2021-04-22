package com.cg.nsa.service;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;

public interface IUserService {

	User login(User user) throws InvalidCredentialsException;
	User logout(User user);

}