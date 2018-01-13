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
 * @author Rajaul Islam
 */
public class AnothertestUsingChain {

    private static EmployeeService employeeService=new EmployeeService();

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpName("Nipa");
        emp.setEmpMobileNos("01686239147");
        emp.setEmpAddress("Dhaka");
        try {
            employeeService.persist(emp);
        } catch (Exception ex) {
            Logger.getLogger(AnothertestUsingChain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
