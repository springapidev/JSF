/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.coderbd.entity.StudentClass;
import com.coderbd.service.StudentClassService;

/**
 *
 * @author Rajaul Islam
 */
@ViewScoped
@ManagedBean(name = "studentClassController", eager = true)
public class StudentClassController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentClass studentClass;
	private List<StudentClass> studentClasses;

	private StudentClassService studentClassService;

	public StudentClassController() {
	}

	public void saveStudentClass() {
		// FacesContext context = FacesContext.getCurrentInstance();
		try {
			studentClassService = new StudentClassService();
			System.out.println(studentClass.toString());
			studentClassService.persist(studentClass);
			// context.addMessage(null, new FacesMessage("Successfully Saved"));
		} catch (Exception ex) {
			Logger.getLogger(StudentClassController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public StudentClass getStudentClass() {
		if (studentClass == null) {
			studentClass = new StudentClass();

		}
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public List<StudentClass> getStudentClasses() {
		studentClasses = new ArrayList<>();
		try {
			studentClassService = new StudentClassService();
			studentClasses = studentClassService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}

	public StudentClassService getStudentClassService() {
		if (studentClassService == null) {

			studentClassService = new StudentClassService();
		}
		return studentClassService;
	}

	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}

}
