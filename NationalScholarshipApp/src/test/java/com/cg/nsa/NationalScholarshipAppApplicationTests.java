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
	void testlogin() {
    	User user=new User("bca","kkk","student");
    	assertEquals("bca",iuserservice.login(user).getUserId());
    	
    	
    	
	}
    @Test
    void logout() {
    	User user=new User("ram","ram1","student");
    	assertThrows(InvalidCredentialsException.class, ()->iuserservice.logout("ram","ram1","student"));
    }

}
