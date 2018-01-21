package com.coderbd.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher_assign_class_sub")
public class TeacherAsgnClassSubject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToMany
	@JoinColumn(name="teacher_id")
	private final List<Teacher> teachers;
	@ManyToMany
	@JoinColumn(name="sclass_id")
	private final List<StudentClass> studentClasses;
	@ManyToMany
	@JoinColumn(name="subject_id")
	private final List<Subject> subjects;
	public TeacherAsgnClassSubject(List<Teacher> teachers, List<StudentClass> studentClasses, List<Subject> subjects) {
		super();
		this.teachers = teachers;
		this.studentClasses = studentClasses;
		this.subjects = subjects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	
}
