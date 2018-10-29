package com.device.manager.devicemanager.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.device.manager.devicemanager.model.Users;
import com.device.manager.devicemanager.respository.UsersRespository;


@Service
public class UsersServices {
	
	@Autowired
	UsersRespository usersRespository;
	
	public boolean  getLogin(String userName,String password){
		if(usersRespository.findByuserName(userName) != null && usersRespository.findBypassword(password) != null) {
			 return true;
		}else{
			 return false;
		}		
	}
	
	
	
	
	public List<Users> getAllUsers(){
	 return usersRespository.findAll();
  	}
	
	public Users getUsersById(int id){
		return usersRespository.findById(id).get();
	}
	
	public void saveUsers(Users users){
		usersRespository.save(users); 
	}
	
	public void deleteUsersById(int id){
		usersRespository.deleteById(id);
	}
	
	public void deleteUsers(Users users){
		usersRespository.delete(users);
	}
	
	public void deleteAllUsers(){
		usersRespository.deleteAll();
	}

}
