package com.coderbd.dao;

import java.util.List;

import com.coderbd.common.CommonDao;
import com.coderbd.entity.MarksInput;
import com.coderbd.entity.StudentSubsMarks;

public interface StudentSubsMarksDao extends CommonDao<StudentSubsMarks> {

	public List<StudentSubsMarks> findAllMarksInputByObject(int id) throws Exception;
}
