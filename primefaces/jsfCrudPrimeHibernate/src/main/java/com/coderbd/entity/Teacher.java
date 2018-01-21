package com.coderbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="teacher", schema="student")
@SecondaryTables({
    @SecondaryTable(name="t_address"),
    @SecondaryTable(name="t_phone"),
    @SecondaryTable(name="t_details")
})
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	
	@Column(table="t_address")
	private String houseNo;
	@Column(table="t_address")
	private String roadNo;
	@Column(table="t_address")
	private String blockNo;
	@Column(table="t_address")
	private String city;
	
	@Column(table="t_phone")
	private String phoneNo;
	@Column(table="t_phone")
	private String mobileNo;
	
	@Column(table="t_details")
	private String bloodGroup;
	@Column(table="t_details")
	private String religion;
	@Column(table="t_details")
	private String nationality;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getRoadNo() {
		return roadNo;
	}
	public void setRoadNo(String roadNo) {
		this.roadNo = roadNo;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
