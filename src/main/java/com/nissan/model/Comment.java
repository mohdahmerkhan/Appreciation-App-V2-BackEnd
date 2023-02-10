package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nissan.dto.CommentDTO;

@Entity
@Table(name = "Comment")
public class Comment {
	// Field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;

	private String commentMessage;
	@Column(columnDefinition = "bit default 0")
	private boolean edited;

	// @JoinColumn //User.userID = Comment.userID
	@JoinColumn(name = "userID")
	@ManyToOne
	private User user;

	// @JoinColumn //Appreciation.apprID = Comment.apprID
	@JoinColumn(name = "apprID")
	@ManyToOne
	private Appreciation appreciation;

	@JoinColumn(name = "replyOn")
	@ManyToOne
	private Comment replyOn;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentID, String commentMessage, boolean edited, User user, Appreciation appreciation,
			Comment replyOn) {
		super();
		this.commentID = commentID;
		this.commentMessage = commentMessage;
		this.edited = edited;
		this.user = user;
		this.appreciation = appreciation;
		this.replyOn = replyOn;
	}

	public Comment(CommentDTO commentDTO, User user, Appreciation appreciation, Comment replyOn) {
		this.commentID = commentDTO.getCommentID();
		this.commentMessage = commentDTO.getCommentMessage();
		this.edited = commentDTO.isEdited();
		this.user = user;
		this.appreciation = appreciation;
		this.replyOn = replyOn;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
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

	public Comment getReplyOn() {
		return replyOn;
	}

	public void setReplyOn(Comment replyOn) {
		this.replyOn = replyOn;
	}
}
