package com.project.web.controllers.user;

import com.project.web.controllers.DatabaseServiceBean;
import com.project.web.entities.User;
import com.project.web.util.ParamUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class UpdateUserBean extends DatabaseServiceBean implements Serializable {

    private Session session = sessionFactory.openSession();

    private User entity = null;
    private Long userId;
    private FacesContext context = null;
    private ExternalContext externalContext = null;

    public UpdateUserBean() {
    }

    @PostConstruct
    public void init() {
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        entity = new User();
        userId = ParamUtil.longValue((this.getRequestParameter("userId")));
        if (userId != null) {
            entity = this.getUserById(userId);
        }

    }

    public String update() {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return "userlist";
    }

    public User getUserById(Long id) {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }

        session.beginTransaction();
        User user = (User) session.createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    private String getRequestParameter(String paramName) {
        String returnValue = null;
        if (externalContext.getRequestParameterMap().containsKey(paramName)) {
            returnValue = (externalContext.getRequestParameterMap().get(paramName));
        }
        return returnValue;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getEntity() {
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

}
