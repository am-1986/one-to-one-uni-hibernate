package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.StandardSessionFactoryServiceInitiators;

import com.luv2code.hibernate.demo.entity.DateUtils;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// get instructor by primary key/id
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found instructor " + instructor);
			
			// delete the instructor
			if(instructor != null) {
				
				System.out.println("Deleting instructor " + instructor);
				
				// Note: will also delete associated detail object
				// becoz of CascadeType.ALL
				session.delete(instructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}
		

	}

}
