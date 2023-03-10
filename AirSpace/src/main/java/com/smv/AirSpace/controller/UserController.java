package com.smv.AirSpace.controller;

import com.smv.AirSpace.dto.RegisterUserEditDTO;
import com.smv.AirSpace.service.EMailService;
import com.smv.AirSpace.service.UserServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserStatus;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	

	
	// Create new user.
	@PostMapping( consumes = "application/json")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateRegisterUser", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateRegUser(@RequestBody RegisterUserEditDTO registerUserEditDTO) {
		System.out.println("editovanje korisnika");
		boolean updated = userService.update(registerUserEditDTO);
		if(updated){
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	}




	@GetMapping(value = "/activate/{uuid}")
	public String activateUser(@PathVariable("uuid") String uuid) {
		User user = userService.findByuuid(uuid);
		if (user != null) {
			if (user.getUserStatus() == UserStatus.PENDING) {
				user.setUserStatus(UserStatus.ACTIVATED);
				userService.saveUser(user);
				return String.format("<p>Succesfully activated! <p> <p>%s welcome to site!<p>", user.getUsername());
			} else {
				return "User allready activated!";
			}
		}
		return "Bad activation link!";
	}

}
