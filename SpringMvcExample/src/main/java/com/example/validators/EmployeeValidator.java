package com.example.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.domain.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "id", "id is required");
		Employee employee = (Employee) obj;
		if (employee.getId() <= 0) {
			err.rejectValue("id", "negativeVal", new Object[] { "'id'" },
					"id can't be negative");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "contactno",
				"contactno.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "emailid",
				"emailid.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "role", "role.required");
	}

}
