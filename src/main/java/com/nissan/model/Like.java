package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.nissan.dto.LikeDTO;

@Entity
@Table(name = "Liked", uniqueConstraints = { @UniqueConstraint(columnNames = { "userID", "apprID" }) })
public class Like {
	// Field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeID;

	// @JoinColumn //User.userID = likeID.userID
	@JoinColumn(name = "userID")
	@ManyToOne
	private User user;

	// @JoinColumn //Appreciation.apprID = likeID.apprID
	@JoinColumn(name = "apprID")
	@ManyToOne
	private Appreciation appreciation;

	// Default Constructor
	public Like() {
		super();
	}

	// Parameterized Constructor
	public Like(int likeID, User user, Appreciation appreciation) {
		super();
		this.likeID = likeID;
		this.user = user;
		this.appreciation = appreciation;
	}

	public Like(LikeDTO likeDTO, User user, Appreciation appreciation) {
		if (likeDTO.getLikeID() != 0) {
			this.likeID = likeDTO.getLikeID();
		}
		this.user = user;
		this.appreciation = appreciation;
	}

	// Getters & Setters
	public int getlikeID() {
		return likeID;
	}

	public void setlikeID(int likeID) {
		this.likeID = likeID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Appreciation getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(Appreciation appreciation) {
		this.appreciation = appreciation;
	}
}
