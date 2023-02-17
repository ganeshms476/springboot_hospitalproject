package com.ty.springboot_hospital_project.exception;

public class AddressNotFoundException  extends RuntimeException{
	private String message="Address Not found for this id";

	@Override
	public String getMessage() {
		return message;
	}

	public AddressNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AddressNotFoundException() {
		super();
	}
}
