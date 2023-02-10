package com.nissan.dto;

public class LikeDTO {
	private int likeID;
	private int userID;
	private int apprID;

	public LikeDTO() {
		super();
	}

	public LikeDTO(int likeID, int userID, int apprID) {
		super();
		this.likeID = likeID;
		this.userID = userID;
		this.apprID = apprID;
	}

	public int getLikeID() {
		return likeID;
	}

	public void setLikeID(int likeID) {
		this.likeID = likeID;
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

}
