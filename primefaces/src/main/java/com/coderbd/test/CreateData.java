package com.coderbd.test;

import com.coderbd.entity.Employee;
import com.coderbd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CreateData {
	public static void main(String[] args) throws Exception {


		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpName("Sami");
		emp.setEmpMobileNos("01686239145");
		emp.setEmpAddress("Dhaka");
		session.save(emp);
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}