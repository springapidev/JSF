package com.coderbd.entity;

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
	private final Teacher teacher;
	@ManyToMany
	@JoinColumn(name="sclass_id")
	private final StudentClass studentClass;
	@ManyToMany
	@JoinColumn(name="subject_id")
	private final Subject subject;
	public TeacherAsgnClassSubject(Teacher teacher, StudentClass studentClass, Subject subject) {
		super();
		this.teacher = teacher;
		this.studentClass = studentClass;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public StudentClass getStudentClass() {
		return studentClass;
	}
	public Subject getSubject() {
		return subject;
	}
	
	
}
