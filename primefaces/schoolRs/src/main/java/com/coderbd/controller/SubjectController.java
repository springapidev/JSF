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
import com.coderbd.entity.Subject;
import com.coderbd.service.StudentClassService;
import com.coderbd.service.SubjectService;

@RequestScoped
@ManagedBean(name = "subjectController")
public class SubjectController {
	final static Logger logger = Logger.getLogger(SubjectController.class);
	private SubjectService subjectService;
	private Subject subject;
	private Subject subjectSelected;
	private List<Subject> subjects;

	public String save() {
		try {
			System.out.println(subject.toString());
			subjectService = new SubjectService();
			subjectService.persist(subject);
			notificationSuccess("Persist Success!");
			subject = null;
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
			subjectService = new SubjectService();
			subjectService.merge(subject);
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
			subjectService = new SubjectService();
			subjectService.remove(subject);
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public Subject getSubject() {
		if (subject == null) {
			subject = new Subject();
		}
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subject getSubjectSelected() {
		if (subjectSelected == null) {
			subjectSelected = new Subject();
		}
		return subjectSelected;
	}

	public void setSubjectSelected(Subject subjectSelected) {
		this.subjectSelected = subjectSelected;
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
