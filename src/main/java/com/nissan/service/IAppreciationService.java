package com.nissan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nissan.dto.AppreciationDTO;
import com.nissan.model.Appreciation;

public interface IAppreciationService
{
	//Find All Appreciation
	List<Appreciation> findAllAppreciations();
		
	//Find All Filtered Appreciation
	List<Appreciation> findAllFilteredAppreciations(String email, int roleID);
	
	//Find All Appreciation By Approval
	List<Appreciation> findAllAppreciationsByApproval(String username, int roleID, boolean approved);
	
	
	//Find Appreciation By ID
	Optional<Appreciation> findAppreciationByApprID(int apprID);
	
	//Add Appreciation
	Appreciation addAppreciation(AppreciationDTO appreciationDTO);
	
	//Update Appreciation Request
	Appreciation updateAppreciation(Appreciation appreciation);
	
	//Approve Appreciation
	void updateAppreciation(int apprID);
	
	//Disable Appreciation
	void disableAppreciation(int apprID);
	
	
}


