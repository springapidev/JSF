package com.onlinetutorialspoint.service;

import com.onlinetutorialspoint.dao.StudentDAO;
import com.onlinetutorialspoint.pojo.Student;
import java.util.List;

public class DbOperations {

    StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        DbOperations dbOperations = new DbOperations();
        Student createStudent = dbOperations.createStudent();

        List<Student> studentList = dbOperations.getStudentList();
        if (studentList != null) {
            for (Student student : studentList) {
                System.out.println("Student Name : " + student.getName());
            }
        }
        dbOperations.updateStudent(createStudent.getId());
        Student student = dbOperations.getStudent(createStudent.getId());
        if (student != null) {
            System.out.println("Student Details After Updation : " + student.getName());
        }

        dbOperations.deleteStudent(createStudent.getId());

    }

    public Student createStudent() {
        Student s = new Student();
        s.setGender(new Byte("1"));
        s.setName("John");
        s.setClass_("12");
        s.setRollnumber(007);
        studentDAO.addStudent(s);
        return s;
    }

    public void updateStudent(Integer id) {
        Student student = studentDAO.findStudentById(id);
        student.setName("online tutorials point");
        studentDAO.updateStudent(student);
        System.out.println("Student Updated Success");
    }

    public void deleteStudent(Integer id) {
        studentDAO.deleteStudent(id);
        System.out.println("Student Deleted Success");
    }

    public List<Student> getStudentList() {
        return studentDAO.listStudent();
    }

    public Student getStudent(Integer id) {
        return studentDAO.findStudentById(id);
    }

}
