package com.coderbd.dao;

import java.util.List;

import com.coderbd.common.CommonDao;
import com.coderbd.entity.Student;
import com.coderbd.entity.StudentSubsMarks;

public interface StudentDao extends CommonDao<Student>{
	public List<Student> findAllStudentByClass(int id) throws Exception;
}
