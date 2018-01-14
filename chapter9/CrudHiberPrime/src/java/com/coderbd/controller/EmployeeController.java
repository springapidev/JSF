/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.controller;

import com.coderbd.dao.EmployeeDao;
import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rajaul Islam
 */
@ViewScoped
@ManagedBean(name = "employeeController", eager = true)
public class EmployeeController implements Serializable {

    private Employee employee;
    
    @ManagedProperty("#{employeeService}")
    private EmployeeService employeeService;
    

   

    public EmployeeController() {
    }

    public void saveEmployee() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            employeeService=new EmployeeService();
            System.out.println("Name: " + employee.getEmpName() + " Add: " + employee.getEmpAddress() + " Mob: " + employee.getEmpMobileNos());
            employeeService.persist(employee);
            context.addMessage(null, new FacesMessage("Successfully Saved"));
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
        if(employeeService == null ){
        employeeService =new EmployeeService();
        }
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   
}
