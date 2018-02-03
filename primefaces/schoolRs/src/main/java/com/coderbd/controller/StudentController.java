package com.coderbd.controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.Student;
import com.coderbd.entity.StudentClass;
import com.coderbd.service.StudentClassService;
import com.coderbd.service.StudentService;

@SessionScoped
@ManagedBean(name = "studentController")
public class StudentController {
	

	final static Logger logger = Logger.getLogger(StudentController.class);

	
	private StudentClassService studentClassService;
	private StudentClass studentClass;
	private List<StudentClass> studentClasses;
	
	private StudentService studentService;
	private Student student;
	private Student selectedStudent;
	private List<Student> students;
	private List<Student> studentsSelected;

	public String saveStudent() {
		try {
			System.out.println("sami========================= "+student.getStudentName());
			System.out.println(student.toString());
			student.setStudentClass(studentClass);
			studentService = new StudentService();
			studentService.persist(student);
			student =null;
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			e.printStackTrace();
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;

	}

	public void update() {
		try {
			student.setStudentClass(studentClass);
			studentService = new StudentService();
			studentService.merge(student);
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
			
			studentService = new StudentService();
			studentService.remove(student);
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

	}

	

	public Student getStudent() {
		if (student == null) {
			student = new Student();
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getSelectedStudent() {
		if (selectedStudent == null) {
			selectedStudent = new Student();
		}
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<Student> getStudents() {
		try {
			studentService = new StudentService();
			students = new ArrayList<>();
			students = studentService.findAll();
			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}

		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudentsSelected() {
		return studentsSelected;
	}

	public void setStudentsSelected(List<Student> studentsSelected) {
		this.studentsSelected = studentsSelected;
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

	public StudentClassService getStudentClassService() {
		return studentClassService;
	}

	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}

	public StudentClass getStudentClass() {
		if(studentClass == null ){
			studentClass=new StudentClass();
		}
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
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

}
