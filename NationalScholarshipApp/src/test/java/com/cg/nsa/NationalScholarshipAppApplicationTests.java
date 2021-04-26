package com.cg.nsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;
import com.cg.nsa.service.IUserService;

@SpringBootTest
class NationalScholarshipAppApplicationTests {
    @Autowired
    IUserService iuserservice;
    
   @Test
	void login() {
    	User user=new User("300","bvrit","Institution");
    	assertEquals("300",iuserservice.login(user).getUserId());
    	
    	}
   
   @Test
   	void testlogin() {
   		User user=new User("800","bvrit","Institution");
   		assertThrows(InvalidCredentialsException.class, ()->iuserservice.login(user));
   	}
   
    @Test
    void logout() {
    	User user=new User("300","bvrit","Institution");
    	assertEquals("300",iuserservice.logout(user).getUserId()); 	
    }
    
    @Test
    void testlogout() {
    	User user=new User("500","kk","officer");
    	assertThrows(InvalidCredentialsException.class, ()->iuserservice.logout(user));
    }

}
