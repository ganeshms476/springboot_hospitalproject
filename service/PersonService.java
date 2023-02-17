package com.ty.springboot_hospital_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.PersonDAO;
import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.NoSuchElementException;
import com.ty.springboot_hospital_project.exception.PersonNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDAO dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (dao.savePerson(person) != null) {
			structure.setMessage("Created");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.savePerson(person));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (dao.updatePerson(id, person) != null) {
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updatePerson(id, person));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (dao.deletePerson(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletePerson(id));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (dao.getPersonById(id) != null) {
			structure.setMessage("fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getPersonById(id));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		}else {
			throw new PersonNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Person>>> getAllPerson(){
		ResponseStructure<List<Person>> structure = new ResponseStructure<>();
		if (dao.getAllPerson() != null) {
			structure.setMessage("fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getAllPerson());
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.OK);
		}else {
			throw new PersonNotFoundException();
		}
	}
}
