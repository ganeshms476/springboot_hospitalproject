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

import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.service.AddressService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;

	@ApiOperation(value = "save Address", notes = "Api is used to save Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "Address not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}

	@ApiOperation(value = "update Address", notes = "Api is used to update Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Address Not updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @RequestBody Address address,
			@RequestParam int id) {
		return service.updateAddress(id, address);
	}

	@ApiOperation(value = "delete Address", notes = "Api is used to delete Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Address Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam int id) {
		return service.deleteAddress(id);
	}

	@ApiOperation(value = "get Address", notes = "Api is used to get Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fethed"),
			@ApiResponse(code = 404, message = "Address Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@Valid @RequestParam int id) {
		return service.getAddressById(id);
	}

}
