package com.idr.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idr.forms.model.Projects;
import com.idr.forms.repository.ProjectsRepository;

@RestController
public class ProjectResource {
	
	@Autowired
	private ProjectsRepository proRepo;
	
	@GetMapping("/")
	public String show() {
		Projects pro = new Projects();
		pro.setProject("SMS");
//		pro.setProject("VFS");
//		pro.setProject("BIOMET");
//		pro.setProject("BRH");
		proRepo.save(pro);
		return "saved";
		
		
	}
	
	
}
