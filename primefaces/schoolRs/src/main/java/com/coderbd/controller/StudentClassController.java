package com.coderbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.StudentClass;
import com.coderbd.service.StudentClassService;

@RequestScoped
@ManagedBean(name = "studentClassController")
public class StudentClassController {
	final static Logger logger = Logger.getLogger(StudentClassController.class);
	private StudentClassService studentClassService;
	private StudentClass studentClass;
	private StudentClass studentClassSelected;
	private List<StudentClass> studentClasses;

	public String save() {
		try {
			System.out.println(studentClass.toString());
			studentClassService = new StudentClassService();
			studentClassService.persist(studentClass);
			studentClass = null;
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;
	}

	public void update() {
		try {
			studentClassService = new StudentClassService();
			studentClassService.merge(studentClass);
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

	}

	public void delete() {
		try {
			studentClassService = new StudentClassService();
			studentClassService.remove(studentClass);
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

	}

	public StudentClassService getStudentClassService() {
		return studentClassService;
	}

	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
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

	public StudentClass getStudentClassSelected() {
		if (studentClassSelected == null) {
			studentClassSelected = new StudentClass();
		}
		return studentClassSelected;
	}

	public void setStudentClassSelected(StudentClass studentClassSelected) {
		this.studentClassSelected = studentClassSelected;
	}

	public List<StudentClass> getStudentClasses() {
		try {
			studentClassService = new StudentClassService();
			studentClasses = studentClassService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
