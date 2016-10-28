package com.ravipati.web;

import java.beans.PropertyEditorSupport;

public class EmployeeNameEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String employeeName) throws IllegalArgumentException {
				
		if(employeeName.contains("Mr.") || employeeName.contains("Ms.")) {
			setValue(employeeName);
		} else {
			employeeName = "Ms."+employeeName;
			setValue(employeeName);  
			// What every value you will provide to setValue, spring MVC will use the same value to perform data binding task for studentName property
		}
	}
}