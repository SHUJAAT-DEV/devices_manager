package com.device.manager.devicemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.device.manager.devicemanager.model.Users;
import com.device.manager.devicemanager.services.UsersServices;

@RestController
public class UsersController {

	@Autowired
	UsersServices usersServices;
	
	@RequestMapping(method=RequestMethod.POST,value = "/login")
	public boolean login(@RequestBody Users users){
		if (users != null) {
			
			return usersServices.getLogin(users.getUserName(),users.getPassword());
		
		}else{
			return false;
		}
		
	}
	@RequestMapping(method=RequestMethod.POST,value = "/users/registration")
	public void userRegistration(@RequestBody Users newUsers){
		usersServices.saveUsers(newUsers);
	}
	
	@RequestMapping("/users")
	public List<Users> getDevices(){
		return usersServices.getAllUsers();
	}
	
	
	
	
}
