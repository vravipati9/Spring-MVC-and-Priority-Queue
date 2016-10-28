package com.ravipati.web;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class Employee {
	private String empName;
	
	//@Size(min=2, max=8, message="Please enter a value for deptName between {min} and {max} characters")
	@Size(min=2, max=8) @IsValidDept
	private String deptName;
	
	private Long empMobileNo;
	private Date empDOB;
	private List<String> empSkills;
	
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(Long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	public List<String> getEmpSkills() {
		return empSkills;
	}
	public void setEmpSkills(List<String> empSkills) {
		this.empSkills = empSkills;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
