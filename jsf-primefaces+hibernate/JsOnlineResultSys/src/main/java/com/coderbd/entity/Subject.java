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
	private final String subjectName;
	@Column(name = "subject_code")
	private final String subjectCode;
	@Column(name = "note")
	private final String note;
	public Subject(String subjectName, String subjectCode, String note) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.note = note;
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
	
}
