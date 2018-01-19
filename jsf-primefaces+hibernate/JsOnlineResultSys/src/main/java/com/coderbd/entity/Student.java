package com.coderbd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "student_name")
	private final String studentName;
	@Column(name = "father_name")
	private final String fatherName;
	@Column(name = "mother_name")
	private final String motherName;
	@Column(name = "regi_no")
	private final int regiNo;
	@Column(name = "roll_no")
	private final int rollNo;
	@ManyToOne
	@JoinColumn(name = "sclass_id")
	private final StudentClass studentClass;
	@Column(name = "birth_date")
	private final Date birthDate;
	@Column(name = "admission_date")
	private final Date admissionDate;
	@Column(name = "mobile_no")
	private final String mobileNo;
	@Column(name = "note")
	private final String note;


	public Student(String studentName, String fatherName, String motherName, int regiNo, int rollNo,
			StudentClass studentClass, Date birthDate, Date admissionDate, String mobileNo, String note) {
		super();
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.regiNo = regiNo;
		this.rollNo = rollNo;
		this.studentClass = studentClass;
		this.birthDate = birthDate;
		this.admissionDate = admissionDate;
		this.mobileNo = mobileNo;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public int getRegiNo() {
		return regiNo;
	}

	public int getRollNo() {
		return rollNo;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getNote() {
		return note;
	}

}
