package com.qsp.person_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.person_springboot.dto.Person;
import com.qsp.person_springboot.repo.PersonRepo;

@RestController 
public class PersonController {
	
	@Autowired 
	private PersonRepo repo;
	
	@PostMapping("/save")
	public String savePerson(@RequestBody Person person) {
		
		Person person2= repo.save(person);
		if(person2!=null) {
			return "save successfull";
			}
			else {
				return "failed to save";
			}
		}
		
	}
	
