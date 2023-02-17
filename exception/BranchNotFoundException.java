package com.ty.springboot_hospital_project.exception;

public class BranchNotFoundException extends RuntimeException {
	private String message="Branch Not found for this id";

	public String getMessage() {
		return message;
	}

	public BranchNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BranchNotFoundException() {
		super();
	}
}
