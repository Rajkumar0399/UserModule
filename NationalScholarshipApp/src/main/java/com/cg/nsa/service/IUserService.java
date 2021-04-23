/********************************************************
 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the IUserService interface.
 * Created date: 22-04-2021
 
 * ******************************************************
 */
package com.cg.nsa.service;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;

public interface IUserService {

	User login(User user) throws InvalidCredentialsException;
	User logout(User user);

}