package com.qsp.person_springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.person_springboot.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{ 
	
	

}
