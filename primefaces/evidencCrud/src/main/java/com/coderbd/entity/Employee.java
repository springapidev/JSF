package com.coderbd.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id")
	private int id;	

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_address")
	private String empAddress;	  

	@Column(name="emp_mobile_nos")
	private String empMobileNos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMobileNos() {
		return empMobileNos;
	}

	public void setEmpMobileNos(String empMobileNos) {
		this.empMobileNos = empMobileNos;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empAddress=" + empAddress + ", empMobileNos="
				+ empMobileNos + "]";
	}

}
