package com.shamim.controller;

import com.shamim.dao.UserDao;
import com.shamim.entity.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Shamim
 */
@ManagedBean
@ViewScoped
public class UserBean {
    User user = new User();
    UserDao userDao = new UserDao();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getUsers(){
        List<User> userList = userDao.allUsers();
        return userList;
    }
    
    public void addUser(){
        userDao.add(user);
    }
    
    public String updateUser(User user){
        userDao.update(user);
        return "display.xhtml?faces-redirect=true";
    }
    
    public String deleteUser(User user){
        userDao.delete(user);
        return "display.xhtml?faces-redirect=true";
    }
    
    public void changeUser(User user){
        this.user = user;
    }
}
