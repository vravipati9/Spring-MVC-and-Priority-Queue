package com.ravipati.web;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeAdmissionController {
	
	EmployeeService employeeService;
	
	@RequestMapping(value = "regForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("registrationForm");
		return model;
	}

	@RequestMapping(value = "submitRegistrationForm_Oldway.html", method = RequestMethod.POST)
//	public ModelAndView submitAdmissionForm(@RequestParam(value="employeeName", required=true, defaultValue="******") String empName, @RequestParam("deptName") String deptName) {
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> requestParams) {										
		ModelAndView model = new ModelAndView("registrationSuccess");
		Employee e = new Employee();
		e.setEmpName(requestParams.get("empName"));
		e.setDeptName(requestParams.get("deptName"));
		model.addObject("msg", "Details Submitted by you::Name:  "+requestParams.get("employeeName")+", deptName: "+requestParams.get("deptName"));
		model.addObject("employee", e);
		return model;
	}
	
	@ModelAttribute
	public void commonAttriubtesAcrossApplication(Model model) {
		model.addAttribute("msg", "Details Submitted by you");
	}
	
	@InitBinder
	public void customBinderToIgnoreSpecificProperties(WebDataBinder binder) {
		binder.setDisallowedFields("empMobileNo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy**mm**dd");
		//binder.registerCustomEditor(Date.class, "empDOB", new CustomDateEditor(sdf, false));
		binder.registerCustomEditor(String.class, "empName", new EmployeeNameEditor());
	}
	
	
	@RequestMapping(value = "submitRegistrationForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute(value="employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("registrationForm");
			return model;			
		}
		System.out.println("Employee Service:::"+employeeService);
		try {
			//employeeService.message();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("registrationSuccess");
		return model;
	}

}