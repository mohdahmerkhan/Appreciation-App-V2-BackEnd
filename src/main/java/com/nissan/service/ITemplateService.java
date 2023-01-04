package com.nissan.service;

import java.util.List;
import com.nissan.model.Template;

public interface ITemplateService
{
	//Find All Templates
	List<Template> findAllTemplates();
	
	//Add Template
	Template addTemplate(Template template);
	
	//Update Template
	Template updateTemplate(Template template);

}

