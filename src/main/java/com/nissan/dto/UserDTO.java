package com.nissan.dto;

public class UserDTO
{
	//Field
	private int userID;
	private String email;
	private String password;
	private String fullName;
	private boolean isActive;
	private int roleID;
	
	//Default Constructor
	public UserDTO()
	{
	}
	
	//Parameterized Constructor
	public UserDTO(int userID, String email, String password, String fullName, boolean isActive, int roleID) {
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.isActive = isActive;
		this.roleID = roleID;
	}
	
	
	//Getters & Setters
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	
}
