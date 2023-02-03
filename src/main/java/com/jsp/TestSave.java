package com.jsp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Jazz");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student s1 = new Student();
		s1.setName("Tom");
		s1.setAddress("USA");

		Student s2 = new Student();
		s2.setName("Jerry");
		s2.setAddress("UK");

		Course c1 = new Course();
		c1.setName("Manual Testing");
		c1.setDuration("5 Months");

		Course c2 = new Course();
		c2.setName("Core Java");
		c2.setDuration("2.5 Months");

		Course c3 = new Course();
		c3.setName("SQL");
		c3.setDuration("1 Months");

		Course c4 = new Course();
		c4.setName("Advance Java");
		c4.setDuration("2 Months");

		Course c5 = new Course();
		c5.setName("Web Technology");
		c5.setDuration("2 Months");

		Course c6 = new Course();
		c6.setName("Selenium");
		c6.setDuration("1.5 Months");

		List<Course> testing = new ArrayList();
		testing.add(c1);
		testing.add(c2);
		testing.add(c3);
		testing.add(c6);

		List<Course> development = new ArrayList();
		development.add(c2);
		development.add(c3);
		development.add(c4);
		development.add(c5);

		// relation
		s1.setCourses(testing);
		s2.setCourses(development);

		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityTransaction.commit();
	}

}
