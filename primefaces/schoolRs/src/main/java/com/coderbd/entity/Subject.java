package com.coderbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "subject_code")
	private String subjectCode;
	@Column(name = "note")
	private String note;
	public Subject(String subjectName, String subjectCode, String note) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.note = note;
	}
	
	public Subject() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public String getNote() {
		return note;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
