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

import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.service.MedItemsService;
import com.ty.springboot_hospital_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemsService service;

	@ApiOperation(value = "save meditems", notes = "Api is used to save meditems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "meditems not saved Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PostMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems items,
			@RequestParam int mid) {
		return service.saveMedItems(mid, items);
	}

	@ApiOperation(value = "update meditems", notes = "Api is used to update meditems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "meditems Not updated Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@PutMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody MedItems items,
			@RequestParam int mid, @RequestParam int iid) {
		return service.updateMedItems(iid, mid, items);
	}

	@ApiOperation(value = "delete meditems", notes = "Api is used to delete meditems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "meditems Not deleted Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@DeleteMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMeditems(@RequestParam int id) {
		return service.deleteMedItems(id);
	}

	@ApiOperation(value = "get meditems", notes = "Api is used to get meditems")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully fethed"),
			@ApiResponse(code = 404, message = "meditems Not fetched Give proper input"),
			@ApiResponse(code = 401, message = "Invalid Credentials") })
	@GetMapping("/meditems")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItems(@RequestParam int id) {
		return service.getMedOrderById(id);
	}
}
