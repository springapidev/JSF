package com.coderbd.service;

import java.util.List;

import com.coderbd.common.CommonService;
import com.coderbd.dao.MarksInputDao;
import com.coderbd.entity.MarksInput;
import com.coderbd.entity.StudentSubsMarks;

public class MarksInputService extends CommonService<MarksInput> implements MarksInputDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MarksInput> findAllMarksInputByClass(int classID) throws Exception {
		return ((List<MarksInput>) getSession().createQuery("SELECT t from MarksInput t where student.studentClass.id='"+classID+"'").getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MarksInput> findAllMarksInputByStudent(int studentID) throws Exception {
		return ((List<MarksInput>) getSession().createQuery("SELECT t from MarksInput t where student.id='"+studentID+"'").getResultList());
	}
	
}
