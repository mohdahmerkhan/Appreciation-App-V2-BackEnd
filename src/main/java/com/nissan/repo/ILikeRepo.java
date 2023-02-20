package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Like;

public interface ILikeRepo extends JpaRepositoryImplementation<Like, Integer> {

	@Query("from Like where likeID = ?1")
	public Like findLikeByLikeID(int likeID);

	@Query("from Like where apprID = ?1")
	public List<Like> findAllLikeByApprID(int apprID);

}
