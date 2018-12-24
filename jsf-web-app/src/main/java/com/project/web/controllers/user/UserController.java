package com.project.web.controllers.user;

import com.project.web.controllers.DatabaseServiceBean;
import com.project.web.entities.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class UserController extends DatabaseServiceBean implements Serializable {

    private Session session = sessionFactory.openSession();

    private User entity = null;

    public UserController() {
    }

    @PostConstruct
    public void init() {
        entity = new User();
    }

    public String save() {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return "userlist";
    }

    public void delete(Long id) {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete User where id=:id").setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    public List<User> getUserList() {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        List<User> result = session.createQuery("from User order by id asc").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public User getEntity() {
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

}
