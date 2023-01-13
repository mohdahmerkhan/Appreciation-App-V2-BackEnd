package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Role;
import com.nissan.model.User;

@Repository
public interface IRoleRepo extends JpaRepositoryImplementation<Role,Integer>
{
	//Role by roleID
	@Query("from Role where roleID = ?1")
	public Role findRoleByRoleID(int roleID);
}

