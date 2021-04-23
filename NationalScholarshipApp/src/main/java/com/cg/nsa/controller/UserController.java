/********************************************************
 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the User Controller class
 * Created date: 23-04-2021
 
 * ******************************************************
 */

package com.cg.nsa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;
import com.cg.nsa.service.IUserService;


@RestController
@RequestMapping(value ="/User")

public class UserController {
	
@Autowired
IUserService service;
@GetMapping(value="/login")
public ResponseEntity<User> login(@RequestBody User user) throws InvalidCredentialsException{
	
	service.login(user);
	
	return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

@GetMapping(value ="/logout")
public ResponseEntity<User> logout(@RequestBody User user){
	service.logout(user);
	
	return new ResponseEntity<>( HttpStatus.ACCEPTED);
}
} 
