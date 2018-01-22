/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

import com.coderbd.entity.Employee;
import com.coderbd.service.EmployeeService;
import java.util.List;

/**
 *
 * @author J2EE-33
 */
public class GetAll {
       private static EmployeeService employeeService=new EmployeeService();
    public static void main(String[] args) {
        try {
            List<Employee> list=employeeService.findAll();
            System.out.println("Size: "+list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}
