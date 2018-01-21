package com.coderbd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import com.coderbd.entity.Teacher;
import com.coderbd.service.TeacherService;



@ViewScoped
@ManagedBean(name = "teacherMB")
public class TeacherMB implements Serializable {

	private static final long serialVersionUID = 1L;


	private TeacherService teacherService;

	private Teacher bean;
	private Teacher beanSelected;
	private List<Teacher> list;
	private List<Teacher> listSelected;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.bean = new Teacher();
		this.beanSelected = new Teacher();
		this.list = new ArrayList<Teacher>();
		this.listSelected = new ArrayList<Teacher>();
		try {
			teacherService=new TeacherService();
			
			this.list.addAll(teacherService.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void save() {
		try {
			teacherService=new TeacherService();
			teacherService.persist(this.bean);
			refreshList();
			notificationSuccess("persist item");
		} catch (Exception e) {
			notificationError(e,"persist item");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			teacherService=new TeacherService();
			teacherService.merge(this.beanSelected);
			refreshList();
			notificationSuccess("update item");
		} catch (Exception e) {
			notificationError(e,"update item");
		}
	}

	public void delete() {
		try {
			teacherService=new TeacherService();
			teacherService.remove(this.beanSelected.getId());
			refreshList();
			notificationSuccess("delete item");
		} catch (Exception e) {
			notificationError(e,"delete item");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	
	public void reset() {
		refreshList();
        RequestContext.getCurrentInstance().reset("form1:panel");  
	}

	
	public void notificationSuccess(String operation) {
		
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success"); 
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
	
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}

	

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getBean() {
		return bean;
	}

	public void setBean(Teacher bean) {
		this.bean = bean;
	}

	public Teacher getBeanSelected() {
		return beanSelected;
	}

	public void setBeanSelected(Teacher beanSelected) {
		this.beanSelected = beanSelected;
	}

	public List<Teacher> getList() {
		return list;
	}

	public void setList(List<Teacher> list) {
		this.list = list;
	}

	public List<Teacher> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Teacher> listSelected) {
		this.listSelected = listSelected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
