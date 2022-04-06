package com.idr.forms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idr.forms.model.SkillEmployees;
import com.idr.forms.repository.SkillmatrixRepository;



@RestController
public class SkillMatrixResource {
	@Autowired
	SkillmatrixRepository smrepo;
	
    @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/SkillEmployees")
	public List<SkillEmployees> getAllUsers(){
		List<SkillEmployees> skemps = new ArrayList<>(); 
		smrepo.findAll().forEach(skemps::add); 
		return skemps; 
	
	}
    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "AddSkillEmployees")
	public SkillEmployees addEmp(@RequestBody SkillEmployees emps) {
		smrepo.save(emps); 
		return emps;
	} 
    @CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path = "/AddSkillEmployees/{id}")
	public void DeleteUser(@PathVariable long id ) {
		smrepo.deleteById(id);
	}

}
