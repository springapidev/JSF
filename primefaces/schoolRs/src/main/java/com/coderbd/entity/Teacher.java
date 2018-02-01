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
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "teacher_id")
	private long teacherID;
	@Column(name = "teacher_name")
	private String teacherName;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "joining_date")
	private Date joiningDate;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="subject_id", referencedColumnName="id")
	private Subject subject;
	
	
	public Teacher() {
		super();
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
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}
	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + ", birthDate=" + birthDate
				+ ", joiningDate=" + joiningDate + ", mobileNo=" + mobileNo + ", note=" + note + ", subject=" + subject
				+ "]";
	}
	
	
	
	
}