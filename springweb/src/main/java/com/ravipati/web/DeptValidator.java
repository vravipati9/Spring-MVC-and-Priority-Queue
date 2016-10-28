package com.ravipati.web;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class DeptValidator implements ConstraintValidator<IsValidDept, String> {

	public void initialize(IsValidDept constraintAnnotation) {
	}

	public boolean isValid(String deptName, ConstraintValidatorContext context) {
    	if(deptName == null) {
            return false;
        }
    	if (deptName.matches("HR|IT|Sales")) {
    		return true;
    	} else {
    		return false;
    	}
	}
}