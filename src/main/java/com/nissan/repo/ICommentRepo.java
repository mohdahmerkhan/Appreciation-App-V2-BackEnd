package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Comment;

public interface ICommentRepo extends JpaRepositoryImplementation<Comment, Integer> {

	@Query("from Comment where commentID = ?1")
	public Comment findCommentByCommentID(int commentID);
	
	@Query("from Comment where replyOn.commentID = ?1")
	public List<Comment> findAllCommentWithReplyOn(int commentID);
}
