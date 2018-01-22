/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.controller;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Rajaul Islam
 */
@SessionScoped
@ManagedBean(name = "employeeController")
public class EmployeeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private List<Employee> employees;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	public EmployeeController() {
	}

	@PostConstruct
	public void init() {
		// getEmployees();
	}

	public void saveEmployee() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			employeeService = new EmployeeService();
			System.out.println("Name: " + employee.getEmpName() + " Add: " + employee.getEmpAddress() + " Mob: "
					+ employee.getEmpMobileNos());
			employeeService.persist(employee);
			context.addMessage(null, new FacesMessage("Successfully Saved"));
		} catch (Exception ex) {
			Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updateEmployee() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			employeeService = new EmployeeService();
			System.out.println("Name: " + employee.getEmpName() + " Add: " + employee.getEmpAddress() + " Mob: "
					+ employee.getEmpMobileNos());
			employeeService.merge(employee);
			context.addMessage(null, new FacesMessage("Successfully Updated"));
		} catch (Exception ex) {
			Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void deleteEmployee() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			employeeService = new EmployeeService();
			// System.out.println("Name: " + employee.getEmpName() + " Add: " +
			// employee.getEmpAddress() + " Mob: " + employee.getEmpMobileNos());
			employeeService.remove(employee);
			context.addMessage(null, new FacesMessage("Successfully Deleted"));
		} catch (Exception ex) {
			Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Employee getEmployee() {
		if (employee == null) {
			this.employee = new Employee();
		}
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Employee> getEmployees() {
		employees = new ArrayList<>();
		employeeService = new EmployeeService();

		try {
			employees = employeeService.findAll();
			System.out.println("size: " + employees.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
}
