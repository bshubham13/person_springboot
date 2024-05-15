package com.qsp.person_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.person_springboot.dto.Person;
import com.qsp.person_springboot.repo.PersonRepo;

@RestController 
public class PersonController {
	
	@Autowired 
	private PersonRepo repo;
	
	
	//Method for saving data , @RequestBody is used to convert JSON data into java object.
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
		if(person2.isEmpty()) {
			return "Failed to save";
			}
			else {
				return "save successfull";
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
	
	
	//findby phone using custom method created in PersonRepo.java
	@GetMapping("/fetchbyphone")
	public Person fetchByPhone(@RequestParam long phone) {
		
		return repo.findByPhone(phone); 
		
	}
	
	
	@GetMapping("/fetchbyaddress")
	public List<Person> fetchByAddress(@RequestParam  String address) {
		return repo.findByAddress(address); 
	}
	
	
	@GetMapping("/fetchall")
	public List<Person> fetchAll() {
		return repo.findAll(); 
				
	} 
	
	
	// @RequestParam used to bind the data 
	@DeleteMapping("/delete")
	public String deletePerson(@RequestParam int id) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isEmpty()) {
			return "person with id " + id + " not found";
		}
		else 
		{
			repo.delete(optional.get());
			return "deleted Successfully"; 
		}
		
	}
	
	@PutMapping("/update")
	public String updatePerson(@RequestParam  int id, @RequestBody Person person) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			person.setId(id);
			repo.save(person);
			return "Updated Successfully";
		} else {
			return "person with id " +id+ " not found" ;

		}

	}
	
	@PatchMapping("/update/phone/{id}/{phone}")
	public String updatePhone(@PathVariable int id, @PathVariable  long phone) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			person.setPhone(phone);
			
			repo.save(person);
			return "Update Success";
		} else {
			return "person with id " +id+ " not found" ; 
		}	
	}
	
	@PatchMapping("/update/email/{id}/{email}")
	public String updateEmail(@PathVariable int id, @PathVariable  String email) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			person.setEmail(email);
			
			repo.save(person);
			return "Update Success";
		} else {
			return "person with id " +id+ " not found" ; 
		}	
	}
	
	@PatchMapping("/update/name/{id}/{name}")
	public String updateName(@PathVariable int id, @PathVariable  String name) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			person.setName(name);
			
			repo.save(person);
			return "Update Success";
		} else {
			return "person with id " +id+ " not found" ; 
		}	
	}
	
	@PatchMapping("/update/password/{id}/{password}")
	public String updatePassword(@PathVariable int id, @PathVariable  String password) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			person.setPassword(password);
			
			repo.save(person);
			return "Update Success";
		} else {
			return "person with id " +id+ " not found" ; 
		}	
	}
	
	@PatchMapping("/update/address/{id}/{address}")
	public String updateAddress(@PathVariable int id, @PathVariable  String address) {
		
		Optional<Person> optional =repo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			person.setAddress(address); 
			
			repo.save(person); 
			return "Update Success";
		} else {
			return "person with id " +id+ " not found" ; 
		}	
	}
		
	
	
	}
	
