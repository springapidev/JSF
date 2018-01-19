package com.coderbd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "teacher_name")
	private final String teacherName;
	@Column(name = "birth_date")
	private final Date birthDate;
	@Column(name = "joining_date")
	private final Date joiningDate;
	@Column(name = "mobile_no")
	private final String mobileNo;
	@Column(name = "note")
	private final String note;
	
	@ManyToMany
	@JoinColumn(name = "sclass_id")
	private final List<StudentClass> studentClasses;
	
	@OneToMany
	@JoinColumn(name = "subject_id")
	private final List<Subject> subjects;

	public Teacher(String teacherName, Date birthDate, Date joiningDate, String mobileNo, String note,
			List<StudentClass> studentClasses, List<Subject> subjects) {
		super();
		this.teacherName = teacherName;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.mobileNo = mobileNo;
		this.note = note;
		this.studentClasses= studentClasses;
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getNote() {
		return note;
	}

	

	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	
	
}