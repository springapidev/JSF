package com.coderbd.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.primefaces.push.annotation.Singleton;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name ="student_name", nullable = false)
    private String studentName;
    private String gender;
    private String round;
    private Date courseStartDate;
    private boolean courseStatus;
    private String[] completedCourse;
    private String note;

    public Student() {
    }

    public Student(int id, String studentName, String gender, String round, Date courseStartDate, boolean courseStatus, String[] completedCourse, String note) {
        this.id = id;
        this.studentName = studentName;
        this.gender = gender;
        this.round = round;
        this.courseStartDate = courseStartDate;
        this.courseStatus = courseStatus;
        this.completedCourse = completedCourse;
        this.note = note;
    }

    public Student(String studentName, String gender, String round, Date courseStartDate, boolean courseStatus, String[] completedCourse, String note) {
        this.studentName = studentName;
        this.gender = gender;
        this.round = round;
        this.courseStartDate = courseStartDate;
        this.courseStatus = courseStatus;
        this.completedCourse = completedCourse;
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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public boolean isCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(boolean courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String[] getCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(String[] completedCourse) {
        this.completedCourse = completedCourse;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentName=" + studentName + ", gender=" + gender + ", round=" + round + ", courseStartDate=" + courseStartDate + ", courseStatus=" + courseStatus + ", completedCourse=" + completedCourse + ", note=" + note + '}';
    }

}
