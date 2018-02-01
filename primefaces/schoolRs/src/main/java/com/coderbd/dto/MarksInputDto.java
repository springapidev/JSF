package com.coderbd.dto;

public class MarksInputDto {
	private String studentName;
	private int classRoll;
	private int regiNo;
	private double subE1;
	private double subE2;
	private double subB1;
	private double subB2;
	private double submath;
	private double subreligion;
	private double subScience;
	private double subsocialScience;
	private double subPhysics;
	private double subCamisty;
	
	
	public MarksInputDto() {
		super();
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClassRoll() {
		return classRoll;
	}
	public void setClassRoll(int classRoll) {
		this.classRoll = classRoll;
	}
	public int getRegiNo() {
		return regiNo;
	}
	public void setRegiNo(int regiNo) {
		this.regiNo = regiNo;
	}
	public double getSubE1() {
		return subE1;
	}
	public void setSubE1(double subE1) {
		this.subE1 = subE1;
	}
	public double getSubE2() {
		return subE2;
	}
	public void setSubE2(double subE2) {
		this.subE2 = subE2;
	}
	public double getSubB1() {
		return subB1;
	}
	public void setSubB1(double subB1) {
		this.subB1 = subB1;
	}
	public double getSubB2() {
		return subB2;
	}
	public void setSubB2(double subB2) {
		this.subB2 = subB2;
	}
	public double getSubmath() {
		return submath;
	}
	public void setSubmath(double submath) {
		this.submath = submath;
	}
	public double getSubreligion() {
		return subreligion;
	}
	public void setSubreligion(double subreligion) {
		this.subreligion = subreligion;
	}
	public double getSubScience() {
		return subScience;
	}
	public void setSubScience(double subScience) {
		this.subScience = subScience;
	}
	public double getSubsocialScience() {
		return subsocialScience;
	}
	public void setSubsocialScience(double subsocialScience) {
		this.subsocialScience = subsocialScience;
	}
	public double getSubPhysics() {
		return subPhysics;
	}
	public void setSubPhysics(double subPhysics) {
		this.subPhysics = subPhysics;
	}
	public double getSubCamisty() {
		return subCamisty;
	}
	public void setSubCamisty(double subCamisty) {
		this.subCamisty = subCamisty;
	}
	public MarksInputDto(String studentName, int classRoll, int regiNo, double subE1, double subE2, double subB1,
			double subB2, double submath, double subreligion, double subScience, double subsocialScience,
			double subPhysics, double subCamisty) {
		super();
		this.studentName = studentName;
		this.classRoll = classRoll;
		this.regiNo = regiNo;
		this.subE1 = subE1;
		this.subE2 = subE2;
		this.subB1 = subB1;
		this.subB2 = subB2;
		this.submath = submath;
		this.subreligion = subreligion;
		this.subScience = subScience;
		this.subsocialScience = subsocialScience;
		this.subPhysics = subPhysics;
		this.subCamisty = subCamisty;
	}
	
}
