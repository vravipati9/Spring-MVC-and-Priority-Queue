package com.ravipati.web;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	public String message() {
		try {
			
			throw new ClassCastException();
		} catch(Exception e) {
			
		}
		System.out.println("after throwing excepiton");
		return "From EmployeeService";
	}
}