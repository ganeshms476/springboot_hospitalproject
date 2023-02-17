package com.ty.springboot_hospital_project.exception;

public class HospitalNotFoundException extends RuntimeException {
	private String message="Hospital Not found for this id";

	public String getMessage() {
		return message;
	}

	public HospitalNotFoundException(String message) {
		super();
		this.message = message;
	}

	public HospitalNotFoundException() {
		super();
	}
}
