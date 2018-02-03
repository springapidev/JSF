package com.coderbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.User;
import com.coderbd.service.UserService;

@ManagedBean
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);

	private UserService userService;
	private User user;

	private List<User> users;

	public String save() {
		try {

			userService = new UserService();
			userService.persist(user);

			notificationSuccess("Persist Success!");
			user = null;

		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;

	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public User getUser() {
		if( user == null ){
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		try {

			userService = new UserService();
			users = userService.findAll();

		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

}
