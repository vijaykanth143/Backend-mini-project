package com.idr.forms.model;

import java.sql.Array;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkillEmployees {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String empname; 
	private String empcode; 
	private String technologies; 
	private String yearofexperience; 
	private String projectname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getYearofexperience() {
		return yearofexperience;
	}
	public void setYearofexperience(String yearofexperience) {
		this.yearofexperience = yearofexperience;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	
	
}
