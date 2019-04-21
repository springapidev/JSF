package com.coderbd.controller;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import com.coderbd.serviceimpl.StudentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentController {

    private Student student;
    private List<Student> students;
    private StudentService service;

    public void save() {
        service = new StudentServiceImpl();
        service.saveStudent(student);
        System.out.println("Successfully Save!!!");
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

    public List<Student> getStudents() {
        students = new ArrayList<>();
        service = new StudentServiceImpl();
        students = service.getAllStudents();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
