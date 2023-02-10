package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Appreciation;

@Repository
public interface IAppreciationRepo extends JpaRepositoryImplementation<Appreciation, Integer> {
	// Spring Data JPA -- JpaRepositoryImplementation

	// Retrieve All Appreciations List of Staff
//	@Query("from Appreciation where user.userID = ?1 and isApproved = true and isActive = true")
	@Query("from Appreciation where user.userID = ?1 and isActive = true")
	public List<Appreciation> findAppreciationsOfStaff(int userID);

	// Retrieve All Appreciations List Assigned To Approver
	@Query("from Appreciation where assignedTo.userID = ?1 and isApproved = false")
	public List<Appreciation> findAppreciationsAssignedTo(int userID);

	// Retrieve All Appreciations List Recommended By Recommender
	@Query("from Appreciation where recommendBy.userID = ?1")
	public List<Appreciation> findAppreciationsRecommendBy(int userID);

	// Retrieve All Appreciations List Approved By Approver
	@Query("from Appreciation where assignedTo.userID = ?1 and isApproved = true")
	public List<Appreciation> findAppreciationsApprovedBy(int userID);

	// Retrieve Appreciation By apprID
	@Query("from Appreciation where apprID = ?1 and isActive = true")
	public Appreciation findAppreciationsByApprID(int apprID);
}
