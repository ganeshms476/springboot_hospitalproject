package com.ty.springboot_hospital_project.exception;

public class MedeOrderNOtFoundException extends RuntimeException {
	private String message="MedItems Not found for this id";

	@Override
	public String getMessage() {
		return message;
	}

	public MedeOrderNOtFoundException(String message) {
		super();
		this.message = message;
	}

	public MedeOrderNOtFoundException() {
		super();
	}
}
