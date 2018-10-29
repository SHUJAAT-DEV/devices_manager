package com.device.manager.devicemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.device.manager.devicemanager.model.Employees;
import com.device.manager.devicemanager.services.EmployeesServices;


@RestController
public class EmployeesController {
	
	@Autowired
	EmployeesServices employeesServices;
	
	@RequestMapping("/employees")
	public List<Employees> getEmployees(){
		return employeesServices.getAllEmployees();
	}

	@RequestMapping(method =RequestMethod.POST,value = "/employees")
	public void getDevices(@RequestBody Employees employees){
		employeesServices.saveEmployees(employees);
	}
	
	

}
