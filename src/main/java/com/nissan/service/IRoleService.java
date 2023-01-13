package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.model.Role;

public interface IRoleService
{
	//Find All Roles
	List<Role> findAllRoles();	
	
	//Find Role By RoleID
	Optional<Role> findRoleByroleID(int roleID);	
	
	//Add Role
	Role addRole(Role role);
}

