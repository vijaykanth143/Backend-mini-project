package com.idr.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idr.forms.model.Employees;


public interface RegistrationRepository extends JpaRepository<Employees, Long> {

//	Optional<Employees> findByUsername(String username);
//
	@Query("SELECT u FROM Employees u WHERE u.email = :email")
    public Employees findByEmail(@Param("email") String email);
//
//	Employees findByUsernamePassword(String username, String password);
}