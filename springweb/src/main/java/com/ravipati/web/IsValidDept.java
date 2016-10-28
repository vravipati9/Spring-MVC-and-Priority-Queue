package com.ravipati.web;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = DeptValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidDept {
	
    String message() default "Please provide a valid Dept; " +
    		"accepted hobbies are - HR, IT and SALES ( choose anyone )";
      
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};
       
}