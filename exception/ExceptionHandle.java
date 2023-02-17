package com.ty.springboot_hospital_project.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_project.util.ResponseStructure;
@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(IdNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> getException(NoSuchElementException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("No element found for id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> exceptions = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for(ObjectError error:exceptions) {
			String fieldname = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
		Set<ConstraintViolation<?>> set = ex.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for(ConstraintViolation<?> ex1 :set) {
			String name = ex1.getMessage();
			list.add(name);
		}
		return new  ResponseEntity<Object>(list,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(AddressNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Address not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BranchNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Branch not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(HospitalNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Hospital not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(PersonNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Person not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EncounterNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(EncounterNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Encounter not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedItemsNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedItemsNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedItems not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedeOrderNOtFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedeOrderNOtFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedItems not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
