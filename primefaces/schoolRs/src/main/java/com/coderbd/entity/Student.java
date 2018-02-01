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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "student_name")
	private  String studentName;
	@Column(name = "father_name")
	private  String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "regi_no")
	private  int regiNo;
	@Column(name = "roll_no")
	private  int rollNo;
	@Column(name = "email")
	private  String email;
	@ManyToOne
	@JoinColumn(name = "sclass_id",referencedColumnName="id")
	private StudentClass studentClass;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private  Date birthDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "admission_date")
	private  Date admissionDate;
	@Column(name = "mobile_no")
	private  String mobileNo;
	@Column(name = "note")
	private  String note;


	

	public Student(String studentName, String fatherName, String motherName, int regiNo, int rollNo, String email,
			StudentClass studentClass, Date birthDate, Date admissionDate, String mobileNo, String note) {
		super();
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.regiNo = regiNo;
		this.rollNo = rollNo;
		this.email = email;
		this.studentClass = studentClass;
		this.birthDate = birthDate;
		this.admissionDate = admissionDate;
		this.mobileNo = mobileNo;
		this.note = note;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void setRegiNo(int regiNo) {
		this.regiNo = regiNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", regiNo=" + regiNo + ", rollNo=" + rollNo + ", email=" + email + ", studentClass=" + studentClass
				+ ", birthDate=" + birthDate + ", admissionDate=" + admissionDate + ", mobileNo=" + mobileNo + ", note="
				+ note + "]";
	}



}
