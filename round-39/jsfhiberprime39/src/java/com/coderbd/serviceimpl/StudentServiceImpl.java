package com.coderbd.serviceimpl;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import com.coderbd.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentServiceImpl implements StudentService {

    @Override
    public void saveStudent(Student student) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.save(student);
        tr.commit();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr=session.beginTransaction();
        list = session.createCriteria(Student.class).list();
        tr.commit();
        return list;
    }

}
