package com.coderbd.dao;

import java.util.List;

import com.coderbd.common.CommonDao;
import com.coderbd.entity.MarksInput;
import com.coderbd.entity.StudentSubsMarks;

public interface MarksInputDao extends CommonDao<MarksInput> {
	public List<MarksInput> findAllMarksInputByClass(int classID) throws Exception;
	public List<MarksInput> findAllMarksInputByStudent(int studentID) throws Exception;
}
