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

import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.service.BranchService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	private BranchService service;

	@ApiOperation(value = "save branch", notes = "Api is used to save Branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "Branch Not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return service.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "update Branch", notes = "Api is used to update Branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Branch Not Updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid@RequestParam int hid, @RequestBody Branch branch,
			@RequestParam int id, @RequestParam int aid) {
		return service.updateBranch(hid, id, branch, aid);
	}

	@ApiOperation(value = "delete Branch", notes = "Api is used to delete Branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Branch Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@Valid@RequestParam int id) {
		return service.deleteBranch(id);
	}

//	@GetMapping("/branch")
//	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHOspitalId(@RequestParam int id){
//		return service.getAllBranchByHOspitalId(id);
//	}

	@ApiOperation(value = "get Branch", notes = "Api is used to get branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fetched"),
			@ApiResponse(code = 404, message = "Branch Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getHospitalById(@Valid@RequestParam int id) {
		return service.getBranchById(id);
	}

}
