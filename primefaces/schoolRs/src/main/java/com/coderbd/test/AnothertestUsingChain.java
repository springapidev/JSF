/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

import com.coderbd.entity.Student;
import com.coderbd.entity.StudentClass;
import com.coderbd.service.StudentService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajaul Islam
 */
public class AnothertestUsingChain {

    private static StudentService studentService=new StudentService();

    public static void main(String[] args) {
     Student stn = new Student();
      stn.setStudentName("AAAAAAAAAAAAAA");
      stn.setMobileNo("01366542476");
      stn.setMotherName("A");
      stn.setMotherName("Mrs. BBB");
      StudentClass sc=new StudentClass();
      sc.setId(1);
      stn.setStudentClass(sc);
      stn.setBirthDate(new Date());
      stn.setNote("Ok");
        try {
         studentService.persist(stn);
        } catch (Exception ex) {
            Logger.getLogger(AnothertestUsingChain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
