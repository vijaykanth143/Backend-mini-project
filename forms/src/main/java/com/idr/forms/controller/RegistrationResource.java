package com.idr.forms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idr.forms.model.Employees;
import com.idr.forms.model.SkillEmployees;
import com.idr.forms.repository.RegistrationRepository;

@RestController
public class RegistrationResource {

    @Autowired
    RegistrationRepository fieldsRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/employees")
    public List<Employees> getAllUsers() {
        List<Employees> fields = new ArrayList<>();
        fieldsRepository.findAll().forEach(fields::add);
        return fields;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/addemployees")
    public Employees addUser(@RequestBody Employees fields) throws Exception {
//        fieldsRepository.save(fields);
//        return fields;
    	 
    	   Employees emailEntry = fieldsRepository.findByEmail(fields.getEmail());
    	   
    	    if(emailEntry.isPresent()){
    	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
    	    } else {
    	    	fieldsRepository.save(fields);
    	        return fields;
    	    }
    	  
    }

 

	@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/employees/{id}")
    public void deleteUser(@PathVariable long id) {
        fieldsRepository.deleteById(id);
    } 
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/skillmatrix")
	public String Skill(HttpServletRequest request, Model model) {
	model.addAttribute("skill", new SkillEmployees());
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentUserName = authentication.getName();
	System.out.println(currentUserName);
	Employees user = fieldsRepository.findByEmail(currentUserName);
	System.out.println(user);
	String test = user.getRole();
	System.out.println(test);
	if (test.equalsIgnoreCase("Admin")) {
	return "/";
	} else {
	return "/skillMatrixRegistration";
	}
	}
//	@PostMapping("/login")
//	public String login_user(@RequestParam("username") String username,@RequestParam("password") String password,
//			HttpSession session,ModelMap modelMap)
//	{
//		
//	Employees auser=fieldsRepository.findByUsernamePassword(username, password);
//	
//	if(auser!=null)
//	{
//		String uname=auser.getUsername();
//		String upass=auser.getPassword();
//	
//		if(username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
//		{
//			session.setAttribute("username",username);
//		    return "ntg";
//		}
//		else 
//		{
//			modelMap.put("error", "Invalid Account");
//			return "login";
//			
//		}
//	}
//	else
//	{
//		modelMap.put("error", "Invalid Account");
//		return "login";
//	}
//	
//	}
//	
//	@GetMapping(value = "/logout")
//	public String logout_user(HttpSession session)
//	{
//		session.removeAttribute("username");
//		session.invalidate();
//		return "redirect:/login";
//	}
//	


}