package com.coderbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "p_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private int id;
	@Column(name = "p_name")
    private String name;
	@Column(name = "email")
    private String email;
	@Column(name = "mobile")
    private String mobile;
	@Column(name = "username")
    private String username;
	@Column(name = "password")
    private String password;
	@Column(name = "user_type")
    private String userType;
  
    public User() {
    }

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", username="
				+ username + ", password=" + password + ", userType=" + userType + "]";
	}

    
}
