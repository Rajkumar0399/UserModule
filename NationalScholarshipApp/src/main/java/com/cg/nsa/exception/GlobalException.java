package com.cg.nsa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/************************
 * 
 * @author Rajkumar V
 * Version 1.0
 * Description This is GlobalException class.
 * Created date: 21-04-2021
 * 
 ***********************/

@RestControllerAdvice
public class GlobalException 
{
	/*************
	 * 
	 * @param exception
	 * @return - error messages
	 *
	 **************/
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Object> handleException(InvalidCredentialsException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
}