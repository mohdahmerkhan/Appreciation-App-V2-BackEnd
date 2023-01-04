package com.nissan.model;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nissan.dto.AppreciationDTO;

@Entity
@Table(name = "Appreciation")
public class Appreciation
{
	//Field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apprID;
	
	@Column(nullable = false)
	private String title;

	private LocalDateTime date;
	private LocalDateTime createdDate;
	
	private int[] ccTo;
	private String[] tags;
	
	@Column(columnDefinition="boolean default false")
	private boolean isApproved;
	
	@Column(columnDefinition="boolean default true")
	private boolean isActive;
	
	//@JoinColumn				//User.userID = Appreciation.recommendByID
	@JoinColumn(name = "recommendByID")
	@ManyToOne
	private User recommendBy;
	
	//@JoinColumn		//User.userID = Appreciation.assignedToID
	@JoinColumn(name = "assignedToID")
	@ManyToOne
	private User assignedTo;
	
	//@JoinColumn				//User.userID = Appreciation.approvedByID
	@JoinColumn(name = "approvedByID")
	@ManyToOne
	private User approvedBy;
	
	//@JoinColumn				//User.userID = Appreciation.userID
	@JoinColumn(name = "userID")
	@ManyToOne
	private User user;
	
	//@JoinColumn				//Appreciation.templateID = Template.templateID
	@JoinColumn(name = "templateID")
	@ManyToOne
	private Template template;

	
	//Default Constructor
	public Appreciation()
	{
	}
	
	//Mapping AppreciationDTO to Appreciation Object
	public Appreciation(AppreciationDTO appreciationDTO, User recommendBy, User assignedTo, User user, Template template) 
	{
		//Assigning ID for PUT Method
		if(appreciationDTO.getApprID() != 0)
		{
			this.apprID = appreciationDTO.getApprID();
		}
		
		this.recommendBy = recommendBy;
		this.assignedTo = assignedTo;
		this.user = user;
		this.title = appreciationDTO.getTitle();
		this.date = appreciationDTO.getDate();
		this.createdDate = appreciationDTO.getCreatedDate();
		
		
		this.template = template;
		this.ccTo = appreciationDTO.getCcTo();
		this.tags = appreciationDTO.getTags();
		
		
		//Assign ApproveBy User if Exist
		if(appreciationDTO.getApprovedByID() != 0)
		{
			this.approvedBy = new User();
			this.approvedBy.setUserID(appreciationDTO.getApprovedByID());
		}
	}


	//Parameterized Constructor
	public Appreciation(int apprID, String title, LocalDateTime date, LocalDateTime createdDate, boolean isApproved, boolean isActive,
			User recommendBy, User assignedTo, User approvedBy, User user, Template template, int[] ccTo, String[] tags) {
		super();
		this.apprID = apprID;
		this.title = title;
		this.date = date;
		this.createdDate = createdDate;
		this.isApproved = isApproved;
		this.isActive = isActive;
		this.recommendBy = recommendBy;
		this.assignedTo = assignedTo;
		this.approvedBy = approvedBy;
		this.user = user;
		this.template = template;
		this.ccTo = ccTo;
		this.tags = tags;
	}

	//Getters & Setters
	public int getApprID() {
		return apprID;
	}

	public void setApprID(int apprID) {
		this.apprID = apprID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getRecommendBy() {
		return recommendBy;
	}

	public void setRecommendBy(User recommendBy) {
		this.recommendBy = recommendBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public int[] getCcTo() {
		return ccTo;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setCcTo(int[] ccTo) {
		this.ccTo = ccTo;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
