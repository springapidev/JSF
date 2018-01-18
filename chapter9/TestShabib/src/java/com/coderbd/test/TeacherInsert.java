package com.coderbd.test;

import com.coderbd.entity.Department;
import com.coderbd.entity.Teacher;
import com.coderbd.service.TeacherService;

/**
 *
 * @author J2EE-33
 */
public class TeacherInsert {
    static TeacherService teacherService=new TeacherService();
    public static void main(String[] args) {
        try {
            Teacher teacher=new Teacher();
            teacher.setTeacherName("Mr. C");
            teacher.setEmail("c@gmail.com");
            teacher.setAge(999);
            
            Department department=new Department();
            department.setId(1);
            
            teacher.setDepartment(department);
            teacherService.persist(teacher);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}
