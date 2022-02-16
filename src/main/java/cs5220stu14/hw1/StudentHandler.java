package cs5220stu14.hw1;

import java.util.List;

import java.util.Scanner;

public class StudentHandler {
	
	private static Scanner sc = new Scanner(System.in);
	private static char choice;
	
	static void printMenu() {
				
		List<Student> students = ArtSchoolDataHandler.getStudents();
		
		System.out.println("Valley Art School Management System - Students\n");
		
		for(Student s: students) {
			System.out.println("\t" + s);
		}
		System.out.println();
		
		System.out.println("b) Back to Main Menu");
		System.out.println("n) New Student");
		System.out.println("x) Exit");
		System.out.print("Please enter your choice:");
		choice = sc.next().charAt(0);
		processChoice();
	}
	
	static void processChoice() {
		if (choice == 'b' || choice == 'B') {
			Menu.printMenu();
		} else if (choice == 'n' || choice == 'N') {
			newStudentHandler();
			printMenu();
		} else if (choice == 'x' || choice == 'X') {
			Menu.exitHandler();
		} else {
			System.err.println("Invalid choice. Please choose from menu.");
			printMenu();
		}
	}
	
	static void newStudentHandler() {
		System.out.print("Enter name:");
		String name = sc.next();
		System.out.print("Enter birth year:");
		Integer birthYr = Integer.parseInt(sc.next());
		
		Student s = new Student();
		s.setName(name);
		s.setBirthYr(birthYr);
		ArtSchoolDataHandler.insertStudent(s);
	}
	
}
