package com.nissan.dto;

public class CommentDTO {

	private int commentID;
	private String commentMessage;
	private boolean edited = false;
	private int userID;
	private int apprID;
	private int replyOnID;

	public CommentDTO() {
		super();
	}

	public CommentDTO(int commentID, String commentMessage, boolean edited, int userID, int apprID, int replyOnID) {
		super();
		this.commentID = commentID;
		this.commentMessage = commentMessage;
		this.edited = edited;
		this.userID = userID;
		this.apprID = apprID;
		this.replyOnID = replyOnID;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getApprID() {
		return apprID;
	}

	public void setApprID(int apprID) {
		this.apprID = apprID;
	}

	public int getReplyOnID() {
		return replyOnID;
	}

	public void setReplyOnID(int replyOnID) {
		this.replyOnID = replyOnID;
	}

}
