/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J2EE-33
 */
public class GetData {
     private static EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {
       List<Employee> employees = new ArrayList<>();
       
      
         try {
            employees = employeeService.findAll();
            for(Employee e : employees){
                System.out.println("Name: "+e.getEmpName());
            
            }
         } catch (Exception ex) {
             Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
