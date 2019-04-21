package com.coderbd.service;

import com.coderbd.entity.Student;
import java.util.List;

public interface StudentService {

    void saveStudent(Student student);
     void updateStudent(Student student);

    List<Student> getAllStudents();
}
