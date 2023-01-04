package com.nissan.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nissan.model.Template;
import com.nissan.model.User;

public class AppreciationDTO {
	// Field
	private int apprID;
	private String title;
	private LocalDateTime date;
	private LocalDateTime createdDate;
	private int recommendByID;
	private int assignedToID;
	private int approvedByID;
	private int userID;
	private boolean isApproved;
	private int[] ccTo;
	private String[] tags;
	private boolean isActive;
	private int templateID;

	// Default Constructor
	public AppreciationDTO() {
	}

	
	//Parameterized Constructor
	public AppreciationDTO(int apprID, String title, LocalDateTime date, LocalDateTime createdDate, int recommendByID, int assignedToID,
			int approvedByID, int userID, boolean isApproved, int[] ccTo, String[] tags, boolean isActive,
			int templateID) {
		super();
		this.apprID = apprID;
		this.title = title;
		this.date = date;
		this.createdDate = createdDate;
		this.recommendByID = recommendByID;
		this.assignedToID = assignedToID;
		this.approvedByID = approvedByID;
		this.userID = userID;
		this.isApproved = isApproved;
		this.ccTo = ccTo;
		this.tags = tags;
		this.isActive = isActive;
		this.templateID = templateID;
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

	public int getRecommendByID() {
		return recommendByID;
	}

	public void setRecommendByID(int recommendByID) {
		this.recommendByID = recommendByID;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public int getAssignedToID() {
		return assignedToID;
	}

	public void setAssignedToID(int assignedToID) {
		this.assignedToID = assignedToID;
	}

	public int getApprovedByID() {
		return approvedByID;
	}

	public void setApprovedByID(int approvedByID) {
		this.approvedByID = approvedByID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int[] getCcTo() {
		return ccTo;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getTemplateID() {
		return templateID;
	}

	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

}
