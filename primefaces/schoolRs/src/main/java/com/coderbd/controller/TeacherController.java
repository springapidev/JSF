package com.coderbd.controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.Subject;
import com.coderbd.entity.Teacher;
import com.coderbd.service.SubjectService;
import com.coderbd.service.TeacherService;

@SessionScoped
@ManagedBean(name = "teacherController")
public class TeacherController {
	

	final static Logger logger = Logger.getLogger(TeacherController.class);
	private SubjectService subjectService;
	private List<Subject> subjects;
	private Subject subject;
	
	
	private TeacherService teacherService;
	private Teacher teacher;
	private Teacher selectedTeacher;
	private List<Teacher> teachers;
	private List<Teacher> teacherSelected;

	public String save() {
		try {
		
			System.out.println(teacher.toString());
			teacher.setSubject(subject);
			teacherService = new TeacherService();
			teacherService.persist(teacher);
			teacher = null;
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;

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
	
	/****** student class*********/

	


	public Teacher getTeacher() {
		if(teacher==null){
			teacher=new Teacher();
		}
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public Teacher getSelectedTeacher() {
		if(selectedTeacher==null){
			selectedTeacher=new Teacher();
		}
		return selectedTeacher;
	}


	public void setSelectedTeacher(Teacher selectedTeacher) {
		this.selectedTeacher = selectedTeacher;
	}


	public List<Teacher> getTeachers() {
		try {
			teacherService = new TeacherService();
			teachers = teacherService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return teachers;
	}


	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public List<Teacher> getTeacherSelected() {
		return teacherSelected;
	}


	public void setTeacherSelected(List<Teacher> teacherSelected) {
		this.teacherSelected = teacherSelected;
	}
	
	public List<Subject> getSubjects() {
		try {
			subjectService = new SubjectService();
			subjects = subjectService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Subject getSubject() {
		if(subject == null ){
			subject=new Subject();
		}
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	

}
