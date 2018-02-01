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
@Table(name = "std_sub_marks",uniqueConstraints={@UniqueConstraint(columnNames = {"std_id","sub_id"})})
public class StudentSubsMarks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "std_id",referencedColumnName="id")
	private Student student;
	@ManyToOne
	@JoinColumn(name = "sub_id",referencedColumnName="id")
	private Subject subject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "StudentSubsMarks [id=" + id + ", student=" + student + ", subject=" + subject + "]";
	}
	
	
	
	
	
	
}
