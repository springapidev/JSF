/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.controller;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import com.coderbd.test.AnothertestUsingChain;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rajaul Islam
 */
@SessionScoped
@ManagedBean(name = "employeeController")
public class EmployeeController implements Serializable{
     private static EmployeeService employeeService=new EmployeeService();
     
     private Employee employee;
     
     
     public void saveEmployee(){
     /* Employee emp = new Employee();
        emp.setEmpName("Nipa");
        emp.setEmpMobileNos("01686239147");
        emp.setEmpAddress("Dhaka");
*/
        try {
            employeeService.persist(employee);
        } catch (Exception ex) {
            Logger.getLogger(AnothertestUsingChain.class.getName()).log(Level.SEVERE, null, ex);
        }
     }


    public Employee getEmployee() {
        if(employee == null ){
        employee=new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
     
     
}
