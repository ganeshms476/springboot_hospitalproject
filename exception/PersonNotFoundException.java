package com.ty.springboot_hospital_project.exception;

public class PersonNotFoundException extends RuntimeException {
	private String message = "Person Not found for this id";

	@Override
	public String getMessage() {
		return message;
	}

	public PersonNotFoundException(String message) {
		super();
		this.message = message;
	}

	public PersonNotFoundException() {
		super();
	}
}
