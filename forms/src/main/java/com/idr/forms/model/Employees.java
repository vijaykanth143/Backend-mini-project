package com.idr.forms.model;

import javax.persistence.*;

@Entity

public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ename;
    @Column(unique=true)
    private String email;
    private String username;
    private String password; 
    private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) { 
		this.role = role;
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	

}