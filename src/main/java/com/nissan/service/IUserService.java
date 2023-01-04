package com.nissan.service;

import java.util.List;

import com.nissan.dto.FetchUserDTO;
import com.nissan.model.User;

public interface IUserService
{
	//Find All Users
	List<User> findAllUsers();
	
	//Find all Staffs
	List<FetchUserDTO> findAllStaffs();

	//Find all Approvers
	List<FetchUserDTO> findAllApprovers();
	
	//Find By Email & password
	User findByEmailAndPassword(String email, String password);
	
	//Insert User
	User addUser(User user);
	
	//Update User
	User updateUser(User user);
	
	//Delete(Actually Disable) User
	void deleteUser(int userID);
}
