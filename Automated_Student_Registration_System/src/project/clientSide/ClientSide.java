package project.clientSide;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.bean.Student;
import project.useCase.LoginStudent;
import project.useCase.RegisterStudentCourseBatch;

public class ClientSide {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose your profile by entering the number below-");
		System.out.println("1. Administrator");
		System.out.println("2. Register in a course as a student");
		System.out.println("3. Login as student");

		try {
			
		int profile = sc.nextInt(); 
		
		if(profile == 1){
			System.out.println("Login");
			System.out.println("Enter your User name:");
			String aName = sc.next();
			System.out.println("Enter your password: ");
			String aPassword = sc.next();
			
			if(aName.compareTo("a")==0 && aPassword.compareTo("s")==0 ) {
				System.out.println("Welcome Admin!");
				System.out.println();
				System.out.println("Enter number to perform actions:");
				System.out.println();
				System.out.println("1. Add a new Courses");
				System.out.println("2. Update Fees of course.");	
				System.out.println("3. Delete  a course from any Training session.");
				System.out.println("4. Search information about a course.");
				System.out.println("5. Create Batch under a course.");
				System.out.println("6. Allocate students in a Batch under a course.");
				System.out.println("7. Update total seats of a batch.");
				System.out.println("8. View the students of every batch.");
				
			}
			else System.out.println("Please enter correct ID and Password!");
			
		}
		
		else if(profile == 2) {
			RegisterStudentCourseBatch rscb = new RegisterStudentCourseBatch();
		}
		else if(profile == 3) {
			LoginStudent ls = new LoginStudent();
		}

		else System.out.println("Please enter valid input 1 (or) 2");
		
		}
		catch(InputMismatchException ime) {
			System.out.println("Please enter valid input 1 (or) 2 ec");
		}
		
		
	}

}
