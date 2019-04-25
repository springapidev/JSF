package com.coderbd.controller;

import com.coderbd.pojo.Student;
import javax.faces.bean.ManagedBean;


public class StudentController {

    private Student student;

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
