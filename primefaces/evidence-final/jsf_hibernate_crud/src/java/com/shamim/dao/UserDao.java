package com.shamim.dao;

import com.shamim.entity.User;
import com.shamim.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class UserDao {

    public List<User> allUsers() {

        List<User> daoAllUsers;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        daoAllUsers = session.createCriteria(User.class).list();

        session.getTransaction().commit();
        session.close();

        return daoAllUsers;
    }

    public void add(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
    
    
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(user);

        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }
}
