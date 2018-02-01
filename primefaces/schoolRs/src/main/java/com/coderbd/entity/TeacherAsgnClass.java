package com.coderbd.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "teacher_assign_class",uniqueConstraints={@UniqueConstraint(columnNames = {"t_id","sc_id"})})
public class TeacherAsgnClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "t_id",referencedColumnName="id")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name = "sc_id",referencedColumnName="id")
	private StudentClass studentClass;
	
	
	
	public TeacherAsgnClass() {
		super();
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
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public StudentClass getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}
	public TeacherAsgnClass(Teacher teacher, StudentClass studentClass) {
		super();
		this.teacher = teacher;
		this.studentClass = studentClass;
	}
	@Override
	public String toString() {
		return "TeacherAsgnClass [id=" + id + ", teacher=" + teacher + ", studentClass=" + studentClass + "]";
	}
	
	
	
}
