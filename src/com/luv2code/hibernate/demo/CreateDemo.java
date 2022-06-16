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


public class CreateDemo {

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
			
			// create the objects
			/*Instructor instructor = new Instructor("Ashish", "Mohanty", "ashish@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.am.com", "Love to code");
			*/
			
			Instructor instructor = new Instructor("Priyanshi", "Pattanaik", "priyanshi@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.priyanshi.com", "Love playing PS4");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			
			// start transaction
			session.beginTransaction();
			
			// save the instructor
			// Note: this will also save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor : " + instructor);
			session.save(instructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}
		

	}

}
