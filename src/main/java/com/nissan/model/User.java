package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nissan.dto.UserDTO;

@Entity
@Table(name = "AppUser")
public class User
{
	//Field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	private String fullName;
	private int score = 0;
	private boolean isActive = true;
	//@JoinColumn				//User.roleID = Role.roleID
	@JoinColumn(name = "roleID")
	@ManyToOne
	private Role role;
	
	
	//For One User Many Appreciations
	@JsonIgnore					//Avoid Recursive
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)	//One User Many Appreciations
	private List<Appreciation> appreciations;


	//Default Constructor
	public User() 
	{
	}
	
	//Mapping UserDTO to User Object
	public User(UserDTO userDTO) 
	{
		//Assigning UserID for PUT Method
		if(userDTO.getUserID() != 0)
		{
			this.userID = userDTO.getUserID();
		}
		this.email = userDTO.getEmail();
		this.password = userDTO.getPassword();
		this.fullName = userDTO.getFullName();
		this.isActive =  userDTO.isActive();
		this.role = new Role();
	}


	//Parameterized Constructor
	public User(int userID, String email, String password, String fullName, int score, boolean isActive, Role role,
			List<Appreciation> appreciations)
	{
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.score = score;
		this.isActive = isActive;
		this.role = role;
		this.appreciations = appreciations;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public List<Appreciation> getAppreciations() {
		return appreciations;
	}


	public void setAppreciations(List<Appreciation> appreciations) {
		this.appreciations = appreciations;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
