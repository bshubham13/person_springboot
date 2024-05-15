package com.qsp.person_springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.person_springboot.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{ 
	
	Person findByPhone(long phone);
	
	@Query("SELECT p FROM Person p WHERE P.address=?1")
	List<Person> findByAddress(String address);
  
}
