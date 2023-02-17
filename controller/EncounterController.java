package com.ty.springboot_hospital_project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.service.EncounterService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService service;

	@ApiOperation(value = "save encounter", notes = "Api is used to save encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "Encounter not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid@RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return service.saveEncounter(encounter, pid, bid);
	}

	@ApiOperation(value = "update encounter", notes = "Api is used to update encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "encounter Not updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@Valid@RequestBody Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {
		return service.updateEncounter(eid, encounter, bid);
	}

	@ApiOperation(value = "delete encounter", notes = "Api is used to delete encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "encounter Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@Valid@RequestParam int id) {
		return service.deleteEncounter(id);
	}

	@ApiOperation(value = "get encounter", notes = "Api is used to get encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fethed"),
			@ApiResponse(code = 404, message = "encounter Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@Valid@RequestParam int id) {
		return service.getEncounterById(id);
	}
}
