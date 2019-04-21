package com.coderbd.controller;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import com.coderbd.serviceimpl.StudentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class StudentController {

    private Student student;
    private List<Student> students;
    private StudentService service;
    private String message;
    
    public void save() {
        service = new StudentServiceImpl();
        service.saveStudent(student);
      FacesContext.getCurrentInstance().addMessage("MessageId", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Successfull!", "You did something!")); 
       
        System.out.println("Successfully Save!!!");
    }
public void update() {
        service = new StudentServiceImpl();
        service.updateStudent(student);
      FacesContext.getCurrentInstance().addMessage("MessageIdUp", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Update Successfull!", "You did something!")); 
       
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
