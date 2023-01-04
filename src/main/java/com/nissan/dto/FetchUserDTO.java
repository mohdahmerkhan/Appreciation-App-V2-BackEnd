package com.nissan.dto;

public class FetchUserDTO
{
	//Fields
	private int userID;
	private String email;
	private String fullName;
	
	//Default Constructor
	public FetchUserDTO()
	{
	}
	
	//Parameterized Constructor
	public FetchUserDTO(int userID, String email, String fullName)
	{
		super();
		this.userID = userID;
		this.email = email;
		this.fullName = fullName;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
