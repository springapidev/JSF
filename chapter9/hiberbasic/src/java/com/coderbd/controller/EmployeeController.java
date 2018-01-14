package com.coderbd.controller;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author J2EE-33
 */
@ViewScoped
@ManagedBean(name = "employeeController")
public class EmployeeController implements Serializable{

    private Employee employee;
    private EmployeeService employeeService = new EmployeeService();

    
    
    public void saveEmployee(){
        try {
            employeeService.persist(employee);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
