package com.coderbd.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.StudentClass;
import com.coderbd.entity.Teacher;
import com.coderbd.entity.TeacherAsgnClass;
import com.coderbd.service.StudentClassService;
import com.coderbd.service.TeacherAsgnClassService;
import com.coderbd.service.TeacherService;

@SessionScoped
@ManagedBean(name = "assignClassController")
public class AssignClassController {

	final static Logger logger = Logger.getLogger(AssignClassController.class);

	private StudentClassService studentClassService;

	private List<StudentClass> studentClasses;

	private int teacherID;
	private int[] classIDs;
	private TeacherService teacherService;
	private Teacher teacher;

	private TeacherAsgnClassService teacherAsgnClassService;
	private TeacherAsgnClass teacherAsgnClass;
	private List<TeacherAsgnClass> teacherAsgnClasses;

	private String renPanel = "false";

	public String displayForm() {
		try {
			teacherService = new TeacherService();
			if (teacherID != 0) {
				teacher = new Teacher();
				teacher = teacherService.findById(teacherID);
				if (teacher != null) {
					renPanel = "true";
				} else {
					renPanel = "false";
				}
			}
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

		return null;
	}

	public String saveDynamicList() {
		try {
		
			for (int i = 0; i < classIDs.length; i++) {
				teacherAsgnClass = new TeacherAsgnClass();
				Teacher teacher = new Teacher();
				System.out.println("sami========== teacher id: " + teacherID);
				teacher.setId(teacherID);
				teacherAsgnClass.setTeacher(teacher);
				StudentClass sc = new StudentClass();
				sc.setId(classIDs[i]);
				teacherAsgnClass.setStudentClass(sc);
				System.out.println(teacherAsgnClass.toString());

				teacherAsgnClassService = new TeacherAsgnClassService();
				teacherAsgnClassService.persist(teacherAsgnClass);

			}
			
			notificationSuccess("Persist Success!");
			teacherAsgnClass = null;
			classIDs =null;
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

	/****** student class *********/

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

	public Teacher getTeacher() {
		if (teacher == null) {
			teacher = new Teacher();
		}

		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherAsgnClass getTeacherAsgnClassSubject() {
		if (teacherAsgnClass == null) {

			teacherAsgnClass = new TeacherAsgnClass();
		}
		return teacherAsgnClass;
	}

	public void setTeacherAsgnClassSubject(TeacherAsgnClass teacherAsgnClass) {
		this.teacherAsgnClass = teacherAsgnClass;
	}

	public List<TeacherAsgnClass> getTeacherAsgnClasses() {
		try {
			teacherAsgnClassService = new TeacherAsgnClassService();
			teacherAsgnClasses = teacherAsgnClassService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return teacherAsgnClasses;
	}

	public void setTeacherAsgnClass(List<TeacherAsgnClass> teacherAsgnClasses) {
		this.teacherAsgnClasses = teacherAsgnClasses;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getRenPanel() {
		return renPanel;
	}

	public void setRenPanel(String renPanel) {
		this.renPanel = renPanel;
	}

	public int[] getClassIDs() {
		return classIDs;
	}

	public void setClassIDs(int[] classIDs) {
		this.classIDs = classIDs;
	}

}
