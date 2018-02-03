package com.coderbd.service;

import java.util.List;

import com.coderbd.common.CommonService;
import com.coderbd.dao.StudentSubsMarksDao;
import com.coderbd.entity.MarksInput;
import com.coderbd.entity.StudentSubsMarks;

public class StudentSubsMarksService extends CommonService<StudentSubsMarks> implements StudentSubsMarksDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentSubsMarks> findAllMarksInputByObject(int id) throws Exception {
		return ((List<StudentSubsMarks>) getSession().createQuery("SELECT t from StudentSubsMarks t where student.id='"+id+"'").getResultList());
	}

	
}
