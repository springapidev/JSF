/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J2EE-33
 */
public class App {
     private static EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setEmpName("Ruhul");
        employee.setEmpAddress("Naogaon");
        employee.setEmpMobileNos("4545656");
         try {
             employeeService.merge(employee);
         } catch (Exception ex) {
             Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
