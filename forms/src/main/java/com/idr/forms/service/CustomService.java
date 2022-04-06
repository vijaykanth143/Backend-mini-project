package com.idr.forms.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.idr.forms.model.Employees;
import com.idr.forms.repository.RegistrationRepository;
import com.idr.forms.model.OverridingThymleaf;


public class CustomService implements UserDetailsService {
@Autowired
private RegistrationRepository repos;

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
// TODO Auto-generated method stub
	Employees user = repos.findByEmail(email);
if(user == null) {
throw new UsernameNotFoundException("User not found");
}
return new OverridingThymleaf(user);
}
}