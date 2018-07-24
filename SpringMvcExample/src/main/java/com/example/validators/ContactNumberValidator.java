package com.example.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements
		ConstraintValidator<ContactNumber, String> {

	@Override
	public void initialize(ContactNumber contactNumber) {

	}

	@Override
	public boolean isValid(String contactNumber, ConstraintValidatorContext ctx) {

		return !contactNumber.isEmpty() && !contactNumber.matches("[0-9]{9}")
				&& contactNumber.length() == 10;
	}

}
