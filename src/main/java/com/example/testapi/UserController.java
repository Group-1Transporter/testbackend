package com.example.testapi;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  
	@GetMapping("/user")
	public ResponseEntity<ArrayList<User>> getUserList(){
		ArrayList<User> al = UserDAO.getUserList();
	    return new ResponseEntity<>(al,HttpStatus.OK);
	}
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User u = UserDAO.save(user);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
  
}
