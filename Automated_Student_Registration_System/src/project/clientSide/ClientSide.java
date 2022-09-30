package project.clientSide;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.bean.Student;
import project.dao.dao;
import project.dao.daoImpl;
import project.useCase.LoginStudent;
import project.useCase.RegisterStudentCourseBatch;

public class ClientSide {

	public static void main(String[] args) throws Exception {
		System.out.println();
		System.out.println("     						Welcome to Automated Student registration system!");
		dao daoObj = new daoImpl();

		Scanner sc = new Scanner(System.in);
		
		daoObj.displayHomePageOptionToUser();

		try {
			
		int profile = sc.nextInt(); 
		
		if(profile == 1){
			
			if(daoObj.checkForAdmin()) {
				daoObj.displayOptionsForAdmin();
				
				int aOpt = sc.nextInt();
				
				switch (aOpt) {
				case 1: {
					daoObj.adminAddNewCourse();
					break;
				}
				case 2: {
					System.out.println("Enter Course name: ");
					String cName = sc.next();
					System.out.println("Enter fees to update:");
					int fees = sc.nextInt();
					daoObj.adminUpdateFeesOfCourse(cName, fees);
					break;

				}
				case 3: {
					System.out.println("Enter course to delete:");
					String cName = sc.next();
					daoObj.adminDeleteCourse(cName);
					break;

				}
				case 4: {
					System.out.println("Enter course name to get it's information");
					String cName = sc.next();
					daoObj.adminDisplayCourseInfo(cName);
					break;

				}
				case 5: {
					System.out.println("Enter Course name:");
					String cName = sc.next().toUpperCase();
					System.out.println("Enter Batch no:");
					int bId = sc.nextInt();
					System.out.println("Enter total seats in this batch: ");
					int totalSeats = sc.nextInt();
					daoObj.adminCreatBatchunderaCourse(cName, bId, totalSeats);
					break;
				}
				case 6: {
					daoObj.adminAllocateStudentsInaBatchUnderaCourse();
					break;
				}
				case 7: {
					daoObj.adminUpdateTotalSeatsOfaBatch();
					break;
				}
				case 8: {
					daoObj.adminViewStudentsOfEveryBatch();
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + aOpt+ " enter valid options please.");
				}
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
			System.out.println("Please enter valid input 1 (or) 2");
		}
		
		
	}

}
