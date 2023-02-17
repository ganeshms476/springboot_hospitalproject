package com.ty.springboot_hospital_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.service.PersonService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	PersonService service;

	@ApiOperation(value = "save person", notes = "Api is used to save person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "person not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "update person", notes = "Api is used to update person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "person Not updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@ApiOperation(value = "delete person", notes = "Api is used to delete person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "person Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

	@ApiOperation(value = "get person", notes = "Api is used to get person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fethed"),
			@ApiResponse(code = 404, message = "person Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}

	@GetMapping("/personall")
	public ResponseEntity<ResponseStructure<List<Person>>> getAll() {
		return service.getAllPerson();
	}
}
