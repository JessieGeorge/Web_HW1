package cs5220stu14.hw1;

import java.util.regex.*;
import java.util.List;
import java.util.Scanner;

public class GroupHandler {
	
	private static Scanner sc = new Scanner(System.in);
	private static String choice;
	
	private static List<StudentGroup> studentGroups;
	private static int numGroups;
	private static StudentGroup pickedGroup;
	
	private static List<Student> grouplessStudents;
	private static int numGrouplessStudents;
	
	static void printMenu() {
		studentGroups = ArtSchoolDataHandler
				.getStudentGroups();
		numGroups = studentGroups.size();
		
		System.out.println("Valley Art School Management System - Groups\n");
		
		for(int i = 0; i < numGroups; i++) {
			System.out.println("\t" + (i+1) + ") " + studentGroups.get(i));
		}
		System.out.println();
		
		System.out.println("b) Back to Main Menu");
		System.out.println("n) New Group");
		System.out.println("x) Exit");
		System.out.print("Please enter your choice:");
		choice = sc.next();
		processChoice();
	}
	
	static void processChoice() {
		if (choice.equals("b") || choice.equals("B")) {
			Menu.printMenu();
		} else if (choice.equals("n") || choice.equals("N")) {
			newGroupHandler();
			printMenu();
		} else if (choice.equals("x") || choice.equals("X")) {
			Menu.exitHandler();
		} else if (Pattern.compile("[0-9]+").matcher(choice).matches()) {
			int choiceNum = Integer.parseInt(choice);
			if (choiceNum > 0 && choiceNum <= numGroups) {
				// because the User starts counting from 1
				pickedGroup = studentGroups.get(choiceNum-1);
				printGroupDetailsMenu();
			} else {
				System.err.println("Invalid choice. Please choose from menu.");
				printMenu();
			}
			
		} else {
			System.err.println("Invalid choice. Please choose from menu.");
			printMenu();
		}
	}
	
	static void newGroupHandler() {
		System.out.print("Enter group name:");
		String name = sc.next();
		
		StudentGroup g = new StudentGroup();
		g.setName(name);
		ArtSchoolDataHandler.insertStudentGroup(g);
	}
	
	
	static void printGroupDetailsMenu() {
		List<Student> enrolledStudents = pickedGroup.getStudents();
		int numEnrolledStudents = enrolledStudents.size();
		
		System.out.println("Valley Art School Management System - "
				+ pickedGroup.getName() + " \n");
		
		for(int i = 0; i < numEnrolledStudents; i++) {
			System.out.println("\t" + enrolledStudents.get(i));
		}
		System.out.println();
		
		System.out.println("b) Back to Groups");
		System.out.println("a) Add student to this group");
		System.out.println("x) Exit");
		System.out.print("Please enter your choice:");
		choice = sc.next();
		processGroupDetailsChoice();
	}
	
	static void processGroupDetailsChoice() {
		if (choice.equals("b") || choice.equals("B")) {
			printMenu();
		} else if (choice.equals("a") || choice.equals("A")) {
			printEnrollMenu();
		} else if (choice.equals("x") || choice.equals("X")) {
			Menu.exitHandler();
		} else {
			System.err.println("Invalid choice. Please choose from menu.");
			printGroupDetailsMenu();
		}
	}
	
	
	static void printEnrollMenu() {
		grouplessStudents = ArtSchoolDataHandler
				.getGrouplessStudents();
		numGrouplessStudents = grouplessStudents.size();
		
		System.out.println("Valley Art School Management System - "
				+ "Add to " + pickedGroup.getName() + " \n");
		
		if (numGrouplessStudents == 0) {
			System.out.println("No available students to add.");
		} else {
			for(int i = 0; i < numGrouplessStudents; i++) {
				System.out.println("\t" + (i+1) + ") " 
						+ grouplessStudents.get(i));
			}
		}
		
		System.out.println();
		
		System.out.println("b) Back to " + pickedGroup.getName());
		System.out.println("x) Exit");
		System.out.print("Please enter your choice:");
		choice = sc.next();
		processEnrollChoice();
	}
	
	static void processEnrollChoice() {
		if (choice.equals("b") || choice.equals("B")) {
			printGroupDetailsMenu();
		} else if (choice.equals("x") || choice.equals("X")) {
			Menu.exitHandler();
		} else if (Pattern.compile("[0-9]+").matcher(choice).matches()) {
			int choiceNum = Integer.parseInt(choice);
			if (choiceNum > 0 && choiceNum <= numGrouplessStudents) {
				// because the User starts counting from 1
				Student pickedStudent = grouplessStudents.get(choiceNum-1);
				enroll(pickedStudent);
				printGroupDetailsMenu();
			} else {
				System.err.println("Invalid choice. Please choose from menu.");
				printEnrollMenu();
			}
			
		} else {
			System.err.println("Invalid choice. Please choose from menu.");
			printEnrollMenu();
		}
	}
	
	static void enroll(Student s) {
		System.out.println("Adding " + s.getName()
				+ " to " + pickedGroup.getName() + "... \n");
		pickedGroup.addStudent(s);
		ArtSchoolDataHandler.enrollStudent(s, pickedGroup);
	}
}
