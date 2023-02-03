package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeletebyId {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Jazz");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, 2);

		if (student != null) {

			System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress());
            
			List<Course> courses = student.getCourses();
			entityTransaction.begin();
			entityManager.remove(student);
			for (Course course : courses) {
				entityManager.remove(course);
				
				System.out.println(course.getId() + " " + course.getName() + " " + course.getDuration());
			}
			entityTransaction.commit();
		}

	}
}
