package com.ty.springboot_hospital_project.exception;

public class NoSuchElementException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {

		return message;
	}

	public NoSuchElementException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementException() {
		super();
	}

}
