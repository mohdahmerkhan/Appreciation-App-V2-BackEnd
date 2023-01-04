package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Template;

@Repository
public interface ITemplateRepo extends JpaRepositoryImplementation<Template,Integer>
{
	
	
	//Get Template by Template ID
	@Query("from Template where templateID = ?1 and isActive = true")
	public Template findByTemplateID(int templateID);
}

