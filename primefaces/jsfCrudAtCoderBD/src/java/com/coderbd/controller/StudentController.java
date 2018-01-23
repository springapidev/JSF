package com.coderbd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;

@ViewScoped
@ManagedBean(name = "studentController")
public class StudentController implements Serializable {

    private static final long serialVersionUID = 1L;

    private StudentService studentService;

    private Student student;
    private Student beanSelected;
    private List<Student> list;
    private List<Student> listSelected;
    List<String> hobies;
    String hobs = "";

    //@PostConstruct
    public StudentController() {
        refreshList();
    }

    public void refreshList() {
        this.student = new Student();
        this.beanSelected = new Student();
        this.list = new ArrayList<Student>();
        this.listSelected = new ArrayList<Student>();
        try {
            studentService = new StudentService();

            this.list.addAll(studentService.findAll());
            this.listSelected.addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save() {
        try {
          if (hobies != null) {
                for (String s : hobies) {
                    hobs += s + ", ";
                }
                student.setHobby(hobs);
            }
       

            //System.out.(student.toString());
            studentService = new StudentService();
            studentService.persist(this.student);
            refreshList();
            notificationSuccess("persist item");
            
          //    hobies = null;
           // hobies = Arrays.asList(beanSelected.getHobby().split(","));
        } catch (Exception e) {
            notificationError(e, "persist item");
            e.printStackTrace();
        }
    }

    public void update() {
        try {
          //  student.setHobby(hobs);
            studentService = new StudentService();
            studentService.merge(this.beanSelected);
            refreshList();
            notificationSuccess("update item");
        } catch (Exception e) {
            notificationError(e, "update item");
        }
    }

    public void delete() {
        try {
            studentService = new StudentService();
            studentService.remove(this.beanSelected.getId());
            refreshList();
            notificationSuccess("delete item");
        } catch (Exception e) {
            notificationError(e, "delete item");
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

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }

        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getBeanSelected() {
        if (beanSelected == null) {
            beanSelected = new Student();
        }
        return beanSelected;
    }

    public void setBeanSelected(Student beanSelected) {
        this.beanSelected = beanSelected;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public List<Student> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<Student> listSelected) {
        this.listSelected = listSelected;
    }

    public List<String> getHobies() {
        return hobies;
    }

    public void setHobies(List<String> hobies) {
        this.hobies = hobies;
    }

    public String getHobs() {

        return hobs;
    }

    public void setHobs(String hobs) {
        this.hobs = hobs;
    }

}
