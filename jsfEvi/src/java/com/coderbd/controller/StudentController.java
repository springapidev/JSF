package com.coderbd.controller;

import com.coderbd.dao.StudentDao;
import com.coderbd.entity.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rajaul Islam
 */
@ViewScoped
@ManagedBean(name = "stuCon", eager = true)
public class StudentController implements Serializable {

    private Student student;
   

    private StudentDao studentDao;

    public StudentController() {
     
    }

    public void saveStudent() {
        try {
            studentDao = new StudentDao();
            studentDao.save(student);
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   
}
