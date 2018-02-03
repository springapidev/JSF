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
@Table(name = "marks_input",uniqueConstraints={@UniqueConstraint(columnNames = {"std_id","sub_id"})})
public class MarksInput {
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
	
	@Column(name = "obtainted_marks")
	private double obtaintedMarks;
	
	@Column(name = "pass_mark")
	private double passMark;

	public MarksInput(Student student, Subject subject, double obtaintedMarks, double passMark) {
		super();
		this.student = student;
		this.subject = subject;
		this.obtaintedMarks = obtaintedMarks;
		this.passMark = passMark;
	}

	public MarksInput() {
		super();
	}

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

	public double getObtaintedMarks() {
		return obtaintedMarks;
	}

	public void setObtaintedMarks(double obtaintedMarks) {
		this.obtaintedMarks = obtaintedMarks;
	}

	public double getPassMark() {
		return passMark;
	}

	public void setPassMark(double passMark) {
		this.passMark = passMark;
	}

	@Override
	public String toString() {
		return "MarksInput [id=" + id + ", student=" + student + ", subject=" + subject + ", obtaintedMarks="
				+ obtaintedMarks + ", passMark=" + passMark + "]";
	}
	
	
	
}
