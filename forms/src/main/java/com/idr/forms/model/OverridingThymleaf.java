package com.idr.forms.model;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class OverridingThymleaf implements UserDetails {

private Employees user;

public OverridingThymleaf(Employees user) {
// TODO Auto-generated constructor stub
this.user = user;
}



@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
// TODO Auto-generated method stub
return null;
}

@Override
public String getPassword() {
// TODO Auto-generated method stub
return user.getPassword();
}

@Override
public String getUsername() {
// TODO Auto-generated method stub
return user.getEmail();
}

@Override
public boolean isAccountNonExpired() {
// TODO Auto-generated method stub
return true;
}

@Override
public boolean isAccountNonLocked() {
// TODO Auto-generated method stub
return true;
}

@Override
public boolean isCredentialsNonExpired() {
// TODO Auto-generated method stub
return true;
}

@Override
public boolean isEnabled() {
// TODO Auto-generated method stub
return true;
}

}