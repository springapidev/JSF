package com.project.web.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseServiceBean {

    public final SessionFactory sessionFactory = new Configuration().configure()
            .buildSessionFactory();

    public DatabaseServiceBean() {
    }

}
