package com.coderbd.dao;

import com.coderbd.model.Student;
import java.util.List;

public interface StudentDao {

    void add(Student student);

    List<Student> getStdents();
}
