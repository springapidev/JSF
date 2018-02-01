package com.coderbd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.dto.MarksInputDto;
import com.coderbd.entity.MarksInput;
import com.coderbd.entity.Student;
import com.coderbd.entity.StudentClass;
import com.coderbd.entity.StudentSubsMarks;
import com.coderbd.entity.Subject;
import com.coderbd.service.MarksInputService;
import com.coderbd.service.StudentClassService;
import com.coderbd.service.StudentService;
import com.coderbd.service.StudentSubsMarksService;
import com.coderbd.service.SubjectService;

@SessionScoped
@ManagedBean(name = "marksInputController")
public class MarksInputController {

	final static Logger logger = Logger.getLogger(MarksInputController.class);
	private StudentService studentService;
	private Student student;
	private List<Student> students;

	private SubjectService subjectService;
	private List<Subject> subjects;

	private StudentSubsMarksService studentSubsMarksService;
	private List<StudentSubsMarks> studentSubsMarksList;
	private List<StudentSubsMarks> studentSubsMarksListByStudentID;

	private MarksInputService marksInputService;
	private MarksInput marksInput;
	private List<MarksInput> marksInputs;

	private MarksInputDto marksInputDto;
	private List<MarksInputDto> marksInputDtos;

	private StudentClassService studentClassService;

	private List<StudentClass> studentClasses;

	private String renJunior = "true";

	private String renHigh = "false";

	private int classID;

	public String saveOrMergeMarks() {
		try {
			marksInputService = new MarksInputService();
			if (classID != 0) {
				StudentClass sc = studentClassService.findById(classID);
				if (sc.getClassName().equals("Six") || sc.getClassName().equals("Seven")
						|| sc.getClassName().equals("Eight")) {

					for (Student student : students) {
						for (StudentSubsMarks sub : getStudentSubsListByStudentID(student.getId())) {
							marksInput.setStudent(student);
							marksInput = new MarksInput();

							if (sub.getSubject().getSubjectCode().equals("e1")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubE1());
							} else if (sub.getSubject().getSubjectCode().equals("e2")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubE2());
							} else if (sub.getSubject().getSubjectCode().equals("b1")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubB1());
							}  else if (sub.getSubject().getSubjectCode().equals("b2")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubB2());
							}  else if (sub.getSubject().getSubjectCode().equals("math")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubmath());
							}  else if (sub.getSubject().getSubjectCode().equals("reli")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubreligion());
							} else if (sub.getSubject().getSubjectCode().equals("sc")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubScience());
							} else if (sub.getSubject().getSubjectCode().equals("ss")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubsocialScience());
							}
							marksInputService.persist(marksInput);

						}

					}
				} else {

					for (Student student : students) {
						for (StudentSubsMarks sub : getStudentSubsListByStudentID(student.getId())) {
							marksInput.setStudent(student);
							marksInput = new MarksInput();

							if (sub.getSubject().getSubjectCode().equals("e1")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubE1());
							} else if (sub.getSubject().getSubjectCode().equals("e2")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubE2());
							} else if (sub.getSubject().getSubjectCode().equals("b1")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubB1());
							} else if (sub.getSubject().getSubjectCode().equals("b2")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubB2());
							}  else if (sub.getSubject().getSubjectCode().equals("math")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubmath());
							} else if (sub.getSubject().getSubjectCode().equals("reli")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubreligion());
							} else if (sub.getSubject().getSubjectCode().equals("sc")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubScience());
							} else if (sub.getSubject().getSubjectCode().equals("ss")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubsocialScience());
							} else if (sub.getSubject().getSubjectCode().equals("phy")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubPhysics());
							} else if (sub.getSubject().getSubjectCode().equals("camis")) {
								Subject subject = new Subject();
								subject.setId(sub.getId());
								marksInput.setSubject(subject);
								marksInput.setObtaintedMarks(marksInputDto.getSubCamisty());
							}

							marksInputService.persist(marksInput);

						}

					}

				}
			}

			notificationSuccess("Persist Success!");
		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;

	}

	public String displayPanel() {
		try {
			if (classID != 0) {
				StudentClass sc = studentClassService.findById(classID);
				if (sc.getClassName().equals("Six") || sc.getClassName().equals("Seven")
						|| sc.getClassName().equals("Eight")) {
					renJunior = "true";
					renHigh = "false";
				} else {
					renJunior = "false";
					renHigh = "true";

				}
			}

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
		if (student == null) {
			student = new Student();
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public MarksInput getMarksInput() {
		if (marksInput == null) {

			marksInput = new MarksInput();
		}
		return marksInput;
	}

	public void setMarksInput(MarksInput marksInput) {
		this.marksInput = marksInput;
	}

	public List<MarksInput> getMarksInputs() {
		return marksInputs;
	}

	public void setMarksInputs(List<MarksInput> marksInputs) {
		this.marksInputs = marksInputs;
	}

	public void loadDToAccordingToClassName() {

	}

	public List<MarksInputDto> getMarksInputDtos() {
		try {
			marksInputDtos = new ArrayList<>();

			for (Student std : getStudents()) {
				MarksInputDto dto = new MarksInputDto();
				dto.setStudentName(std.getStudentName());
				dto.setClassRoll(std.getRollNo());
				dto.setRegiNo(std.getRegiNo());
				marksInputDtos.add(dto);
			}
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return marksInputDtos;
	}

	public void setMarksInputDtos(List<MarksInputDto> marksInputDtos) {
		this.marksInputDtos = marksInputDtos;
	}

	public MarksInputDto getMarksInputDto() {
		if (marksInputDto == null) {
			marksInputDto = new MarksInputDto();
		}
		return marksInputDto;
	}

	public void setMarksInputDto(MarksInputDto marksInputDto) {
		this.marksInputDto = marksInputDto;
	}

	public List<Student> getStudents() {
		try {
			studentService = new StudentService();
			students = studentService.findAll();
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

	public String getRenJunior() {
		return renJunior;
	}

	public void setRenJunior(String renJunior) {
		this.renJunior = renJunior;
	}

	public String getRenHigh() {
		return renHigh;
	}

	public void setRenHigh(String renHigh) {
		this.renHigh = renHigh;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public List<StudentSubsMarks> getStudentSubsMarksListByStudentID() {

		return studentSubsMarksListByStudentID;
	}

	public void setStudentSubsMarksListByStudentID(List<StudentSubsMarks> studentSubsMarksListByStudentID) {
		this.studentSubsMarksListByStudentID = studentSubsMarksListByStudentID;
	}

	public List<StudentSubsMarks> getStudentSubsListByStudentID(int studentID) {
		List<StudentSubsMarks> list = new ArrayList<>();
		try {

			studentSubsMarksService = new StudentSubsMarksService();
			list = studentSubsMarksService.findByProperty("student", studentID);
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return list;
	}

}
