package com.nissan.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Template")
public class Template
{
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int templateID;
	
	private String themeName;
	private String[] themeTags;
	
	@Column(columnDefinition="bit default 1")
	private boolean isActive = true;
	
	
	//For One Role Many Users
	@JsonIgnore					//Avoid Recursive
	@OneToMany(mappedBy = "template", cascade = CascadeType.ALL)	//One Template Many Appreciations
	private List<Appreciation> appreciations;


	//Default Constructor
	public Template()
	{
	}


	//Parameterized Constructor
	public Template(int templateID, String themeName, String[] themeTags, List<Appreciation> appreciations, boolean isActive)
	{
		super();
		this.templateID = templateID;
		this.themeName = themeName;
		this.themeTags = themeTags;
		this.appreciations = appreciations;
		this.isActive = isActive;
	}


	//Getters & Setters
	public int getTemplateID() {
		return templateID;
	}


	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}


	public String getThemeName() {
		return themeName;
	}


	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}


	public String[] getThemeTags() {
		return themeTags;
	}


	public void setThemeTags(String[] themeTags) {
		this.themeTags = themeTags;
	}


	public List<Appreciation> getAppreciations() {
		return appreciations;
	}


	public void setAppreciations(List<Appreciation> appreciations) {
		this.appreciations = appreciations;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	//Overriding toString()
	@Override
	public String toString() {
		return String.format("Template [templateID=%s, themeName=%s, themeTags=%s, isActive=%s, appreciations=%s]",
				templateID, themeName, Arrays.toString(themeTags), isActive, appreciations);
	}
	
}

