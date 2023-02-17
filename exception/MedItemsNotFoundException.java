package com.ty.springboot_hospital_project.exception;

public class MedItemsNotFoundException extends RuntimeException {
	private String message="MedItems Not found for this id";

	@Override
	public String getMessage() {
		return message;
	}

	public MedItemsNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedItemsNotFoundException() {
		super();
	}
}
