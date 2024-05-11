package com.qsp.person_springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="person_info")
public class Person {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="personId")
	private int id;
	@Column(name="personName")
	private String name;
	@Column(name="personPhone",unique=true)
	private long phone;
	@Column(name="personAddress")
	private String address;
	@Column(name="personEmail",unique=true)
	private String email;
	@Column(name="personPassword")
	private String password;
	

}
