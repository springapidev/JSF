/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.entity.Student;
import com.coderbd.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author rajaul
 */
public class StudentDao {

    public static void save(Student s) {
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.save(s);
        tr.commit();
        System.out.println("Successfully inserted");
        sessFact.close();
    }

    
}
