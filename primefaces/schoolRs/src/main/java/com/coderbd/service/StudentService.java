package com.coderbd.service;

import com.coderbd.common.CommonService;
import com.coderbd.dao.StudentDao;
import com.coderbd.entity.Student;
import com.coderbd.entity.StudentSubsMarks;

import java.io.Serializable;
import java.util.List;
;

public class StudentService extends CommonService<Student> implements StudentDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudentByClass(int id) throws Exception {
		return ((List<Student>) getSession().createQuery("SELECT t from Student t where studentClass.id='"+id+"'").getResultList());
	}

}
