package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Template;
import com.nissan.repo.ITemplateRepo;


@Service
public class TemplateServiceImpl implements ITemplateService
{
	//Field Injection
	@Autowired
	ITemplateRepo templateRepo;
	
	//Find All Templates
	@Override
	public List<Template> findAllTemplates()
	{
		return (List<Template>)templateRepo.findAll();
	}

	//Add Template
	@Override
	public Template addTemplate(Template template)
	{
		System.out.println(template);
		return templateRepo.save(template);
	}
	
	//Update Template
	@Override
	public Template updateTemplate(Template template)
	{
		System.out.println(template);
		return templateRepo.save(template);
	}
	
}
