package com.ty.springboot_hospital_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.service.MedOrderService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService service;

	@ApiOperation(value = "save medorder", notes = "Api is used to save medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "medorder not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder order,
			@RequestParam int eid) {
		return service.saveMedOrder(eid, order);
	}

	@ApiOperation(value = "update medorder", notes = "Api is used to update medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "medorder Not updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder order,
			@RequestParam int eid, @RequestParam int mid) {
		return service.updateMedorder(eid, mid, order);
	}

	@ApiOperation(value = "delete medorder", notes = "Api is used to delete medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "medorder Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}

	@ApiOperation(value = "get medorder", notes = "Api is used to get medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fethed"),
			@ApiResponse(code = 404, message = "medorder Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@RequestParam int id) {
		return service.getMedOrderById(id);
	}

}
