package com.nissan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.dto.FetchUserDTO;
import com.nissan.model.User;
import com.nissan.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService
{
	//Field Injection
	@Autowired
	IUserRepo userRepo;
	
	//Find All
	@Override
	public List<User> findAllUsers()
	{
		return (List<User>)userRepo.findAll();
	}
	


	//Find All Staffs
	@Override
	public List<FetchUserDTO> findAllStaffs()
	{
		//Filtering the informations
		List<User> users = (List<User>)userRepo.findAllStaffs();
		List<FetchUserDTO> fetchUsers = new ArrayList<>();
		for(User user : users)
		{
			FetchUserDTO fetchUser = new FetchUserDTO( user.getUserID(), user.getEmail(), user.getFullName());
			fetchUsers.add(fetchUser);
		}
		
		return fetchUsers;
	}
	
	//Find All Staffs
	@Override
	public List<FetchUserDTO> findAllApprovers()
	{
		//Filtering the informations
		List<User> users = (List<User>)userRepo.findAllApprovers();
		List<FetchUserDTO> fetchUsers = new ArrayList<>();
		for(User user : users)
		{
			FetchUserDTO fetchUser = new FetchUserDTO( user.getUserID(), user.getEmail(), user.getFullName());
			fetchUsers.add(fetchUser);
		}
		
		return fetchUsers;
	}

	
	//Find by Email & Password
	@Override
	public User findByEmailAndPassword(String email, String password)
	{
		User _user = userRepo.findByEmailAndPassword(email, password);
		
		if(_user != null)
		{
			//Check Condition for User
			if( email.equals(_user.getEmail()) && password.equals(_user.getPassword()) )
			{
				return _user;
			}
			
			return null;
		}

		return null;
	}
	

	//Add User
	@Transactional
	@Override
	public User addUser(User user)
	{
//		//Setting User Active
//		user.setActive(true);
//		
//		//Setting Role of the user As Customer
//		Role tempRole = new Role();
//		tempRole.setRoleID(3);
//		tempRole.setRoleName("Customer");
//		user.setRole(tempRole);
		
		return userRepo.save(user);
	}


	//Update User
	@Transactional
	@Override
	public User updateUser(User user)
	{
		return userRepo.save(user);
	}
	
	//Delete or Disable User
	@Transactional
	@Override
	public void deleteUser(int userId)
	{
		userRepo.disableById(userId);
	}


	


	
}
