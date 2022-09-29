package project.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.dao.dao;
import project.dao.daoImpl;
import project.exceptions.StudentException;

public class LoginStudent {

	public LoginStudent() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your e-mail:");
		String sEmail = sc.next();
		System.out.println("Enter your password:");
		String sPassword = sc.next();
		
		dao daoObj = new daoImpl();
		
		try {
			boolean isStudentPresent = daoObj.checkForStudent(sEmail, sPassword);
			
			if(isStudentPresent) {
				System.out.println("Please select-");
				System.out.println("1. Update my details");
				System.out.println("2. View all available courses and seat availability");
				int opt = sc.nextInt();
				
				if(opt == 1) {
					
				}
				
			}
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
