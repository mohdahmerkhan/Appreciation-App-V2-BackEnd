package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.dto.AppreciationDTO;
import com.nissan.dto.CommentDTO;
import com.nissan.dto.LikeDTO;
import com.nissan.model.Appreciation;
import com.nissan.model.Comment;
import com.nissan.model.Like;

public interface IAppreciationService {
	// Find All Appreciation
	List<Appreciation> findAllAppreciations();

	// Find All Filtered Appreciation
	List<Appreciation> findAllFilteredAppreciations(String email, int roleID);

	// Find All Appreciation By Approval
	List<Appreciation> findAllAppreciationsByApproval(String username, int roleID, boolean approved);

	// Find Appreciation By ID
	Optional<Appreciation> findAppreciationByApprID(int apprID);

	// Add Appreciation
	Appreciation addAppreciation(AppreciationDTO appreciationDTO);

	// Update Appreciation Request
	Appreciation updateAppreciation(Appreciation appreciation);

	// Approve Appreciation
	void updateAppreciation(int apprID);

	// Disable Appreciation
	void disableAppreciation(int apprID);

	// Find All Likes
	List<Like> findAllLikes();
	
	//Find All Likes for an Appreciation
	List<Like> findAllLikeByApprID(int apprID);

	// Find Like By likeID
	Optional<Like> findLikeByLikeID(int likeID);

	// Add Like
	Like addLike(LikeDTO likeDTO);

	// Delete Likes
	void deleteLike(int likeID);

	// Find All Comments
	List<Comment> findAllComments();

	// Find Comment By commentID
	Optional<Comment> findCommentByCommentID(int commentID);

	// Add Comment
	Comment addComment(CommentDTO commentDTO);

	// Update Comment
	Comment updateComment(CommentDTO commentDTO);

	// Delete Comment
	void deleteComment(int commentID);

	//Find All Comments by replyOnID
	List<Comment> findCommentByReplyOnID(int replyOnID);

	//Find All First Comment
	List<Comment> findAllFirstCommentByApprID(int apprID);

}
