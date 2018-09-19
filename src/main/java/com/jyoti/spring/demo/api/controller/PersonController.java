package com.jyoti.spring.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyoti.spring.demo.api.dao.PersonDao;
import com.jyoti.spring.demo.api.model.Person;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController {
	
	@Autowired
	private PersonDao dao;
	
	@PostMapping("/savePerson")
	public String savePerson(@RequestBody Person person) {
		dao.savePersion(person);
		return "Successfully saved, id : "+person.getId();
	}
	
	@GetMapping("/getAllPerson")
	public List<Person> getAllPerson(){
		return dao.getListOfPersions();
	}
	
	@GetMapping("/getPersonById/{personId}")
	public Person getIndividualPerson(@PathVariable("personId") String id){
		return dao.getPersionById(id);
	}

}
