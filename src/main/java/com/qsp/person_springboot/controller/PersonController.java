package com.qsp.person_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/saveall")
	public String savePersonAll(@RequestBody List<Person>list) {
		
		List<Person> person2= repo.saveAll(list);
		if(person2!=null) {
			return "save successfull";
			}
			else {
				return "failed to save";
			}
		} 
	
	
	@GetMapping("/fetch")
	public Optional<Person> fetch(Integer id) {
		
		Optional<Person> person =repo.findById(id);
		if(person.isPresent()) {
			return person;
		} else {
			return null; 
		}
	}
	
		
	}
	
