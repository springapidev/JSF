package com.coderbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.Student;
import com.coderbd.entity.StudentSubsMarks;
import com.coderbd.entity.Subject;
import com.coderbd.service.StudentClassService;
import com.coderbd.service.StudentService;
import com.coderbd.service.StudentSubsMarksService;
import com.coderbd.service.SubjectService;

@SessionScoped
@ManagedBean(name = "subMarksController")
public class SubMarksController {

	final static Logger logger = Logger.getLogger(SubMarksController.class);
	private StudentService studentService;
	private Student student;
	private SubjectService subjectService;
	private List<Subject> subjects;

	private int studentID;
	private int[] subIDs;

	private StudentSubsMarksService studentSubsMarksService;
	private StudentSubsMarks studentSubsMarks;
	private List<StudentSubsMarks> studentSubsMarksList;

	private String renPanel = "false";

	public String displayForm() {
		try {
			studentService = new StudentService();
			if (studentID != 0) {
				student = new Student();
				student = studentService.findById(studentID);
				if (student != null) {
					renPanel = "true";
					
				}else{
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
			
			for (int i = 0; i < subIDs.length; i++) {
				studentSubsMarks = new StudentSubsMarks();
				Student student = new Student();
				System.out.println("sami========== student id: " + studentID);
				student.setId(studentID);
				studentSubsMarks.setStudent(student);
				Subject sub = new Subject();
				sub.setId(subIDs[i]);
				studentSubsMarks.setSubject(sub);
				System.out.println(studentSubsMarks.toString());

				studentSubsMarksService = new StudentSubsMarksService();
				studentSubsMarksService.persist(studentSubsMarks);
				
			}

			notificationSuccess("Persist Success!");
			subIDs = null;
			studentSubsMarks = null;
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

	public Student getStudent() {
		if(student == null ){
			student  = new Student();
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int[] getSubIDs() {
		return subIDs;
	}

	public void setSubIDs(int[] subIDs) {
		this.subIDs = subIDs;
	}

	public StudentSubsMarks getStudentSubsMarks() {
		if(studentSubsMarks == null ){
			
			studentSubsMarks = new StudentSubsMarks();
		}
		return studentSubsMarks;
	}

	public void setStudentSubsMarks(StudentSubsMarks studentSubsMarks) {
		this.studentSubsMarks = studentSubsMarks;
	}

	public List<StudentSubsMarks> getStudentSubsMarksList() {
		try {
			studentSubsMarksService = new StudentSubsMarksService();
			studentSubsMarksList = studentSubsMarksService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return studentSubsMarksList;
	}

	public void setStudentSubsMarksList(List<StudentSubsMarks> studentSubsMarksList) {
		this.studentSubsMarksList = studentSubsMarksList;
	}

	public String getRenPanel() {
		return renPanel;
	}

	public void setRenPanel(String renPanel) {
		this.renPanel = renPanel;
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



}
