package com.coderbd.controller;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author J2EE-33
 */
@SessionScoped
@ManagedBean
public class EmployeeController {

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
