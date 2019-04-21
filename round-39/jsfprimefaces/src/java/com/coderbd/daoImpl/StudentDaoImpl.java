package com.coderbd.daoImpl;

import com.coderbd.dao.StudentDao;
import com.coderbd.model.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    List<Student> list = new ArrayList<>();

    public StudentDaoImpl() {
        list.add(new Student(1, "Mr. Bangladesh", "f", "Round-39", new Date(), true, new String[]{"HTML", "Java", "Swing"}, "Ok"));
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> getStdents() {
        return list;
    }

}
