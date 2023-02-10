package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.dto.FetchUserDTO;
import com.nissan.model.User;

@Repository
public interface IUserRepo extends JpaRepositoryImplementation<User, Integer> {
	// Spring Data JPA -- JpaRepositoryImplementation,

	// Find User By userID
	@Query("from User where userID = ?1 and isActive = true")
	public User findUserByUserID(int userID);

	// Customer Retrieve (Email) & Password
	@Query("from User where email = ?1 and password = ?2 and isActive = true")
	public User findByEmailAndPassword(String email, String password);

	// Find email By userID
	@Query("select email from User where userID = ?1 and isActive = true")
	public String findEmailByUserID(int userID);

	// Find fullName By userID
	@Query("select fullName from User where userID = ?1 and isActive = true")
	public String findNameByUserID(int userID);

	// Find fullName by Email
	@Query("select fullName from User where email = ?1 and isActive = true")
	public String findNameByEmail(String email);

	// Customer Retrieve Email, Full Name, UserID of Staff
	@Query("from User where role.roleID=2 and isActive = true")
	public List<User> findAllStaffs();

	// Customer Retrieve Email, Full Name, UserID of Staff
	@Query("from User where role.roleID=4 and isActive = true")
	public List<User> findAllApprovers();

	// Get User by User ID
	@Query("from User where userID = ?1 and isActive = true")
	public User findByUserID(int userID);

	// Get User by Email
	@Query("from User where email = ?1 and isActive = true")
	public User findUserByEmail(String email);

	// Disable User
	@Modifying
	@Query("update User u set u.isActive=false where u.userID=?1")
	public void disableById(int userID);

	// Enable User
	@Modifying
	@Query("update User u set u.isActive=true where u.userID=?1")
	public void enableById(int userID);

}
