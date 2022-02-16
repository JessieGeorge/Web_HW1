package cs5220stu14.hw1;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	private static char choice;
	
	static void printMenu() {
		System.out.println("Valley Art School Management System\n");
		System.out.println("s) List Students");
		System.out.println("g) List Groups");
		System.out.println("x) Exit");
		System.out.print("Please enter your choice:");
		choice = sc.next().charAt(0);
		processChoice();
	}
	
	static void processChoice() {
		if (choice == 's' || choice == 'S') {
			StudentHandler.printMenu();
		} else if (choice == 'g' || choice == 'G') {
			GroupHandler.printMenu();
		} else if (choice == 'x' || choice == 'X') {
			exitHandler();
		} else {
			System.err.println("Invalid choice. Please choose from menu.");
			printMenu();
		}
	}
	
	static void exitHandler() {
		ArtSchoolDataHandler.clean();
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	public static void main(String args[]) {
		printMenu();
	}
}
