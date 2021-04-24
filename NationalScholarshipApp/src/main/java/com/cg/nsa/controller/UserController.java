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
@PostMapping(value="/login")

/********************************************************

 * @param User 
 * @return ResponseEntity 
 * @return this method returns login method
 
 * ******************************************************
 */
public ResponseEntity<String> login(@RequestBody User user){
	try {
		service.login(user);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	catch(InvalidCredentialsException e){
      throw new InvalidCredentialsException("Invalid Credentials");
	}
	}

@PostMapping(value ="/logout")

/********************************************************

 * @param User 
 * @return ResponseEntity 
 * @return this method returns logout method
 
 * ******************************************************
 */
public ResponseEntity<String> logout(@RequestBody User user){
	try {
		service.logout(user);
		
		return new ResponseEntity<String>( "logged out",HttpStatus.OK);
	}
	catch(InvalidCredentialsException e){
	      throw new InvalidCredentialsException("Invalid Credentials");
		}
}
} 
