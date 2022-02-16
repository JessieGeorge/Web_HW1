package cs5220stu14.hw1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtSchoolDataHandler {
	
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("art-school");
	private static EntityManager entityManager = entityManagerFactory
			.createEntityManager();
	
	static void insertStudent(Student s) {
		entityManager.getTransaction().begin();
		s = entityManager.merge(s);
		entityManager.getTransaction().commit();
	}
	
	static void insertStudentGroup(StudentGroup g) {
		entityManager.getTransaction().begin();
		g = entityManager.merge(g);
		entityManager.getTransaction().commit();
	}
	
	static void enrollStudent(Student s, StudentGroup g) {
		entityManager.getTransaction().begin();
		s.setStudentGroup(g);
		entityManager.getTransaction().commit();
	}
	
	static List<Student> getStudents() {
        List<Student> students = entityManager
            .createQuery("FROM Student", Student.class)
            .getResultList();
            
        return students;
	}
	
	static List<StudentGroup> getStudentGroups() {
        List<StudentGroup> studentGroups = entityManager
            .createQuery("FROM StudentGroup", StudentGroup.class)
            .getResultList();
            
        return studentGroups;
	}
	
	static List<Student> getGrouplessStudents() {
        List<Student> grouplessStudents = entityManager
            .createQuery("FROM Student "
            		+ "WHERE studentGroup IS NULL", Student.class)
            .getResultList();
            
        return grouplessStudents;
	}
	
	static void clean() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
