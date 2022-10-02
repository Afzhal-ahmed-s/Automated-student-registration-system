package project.clientSide;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import project.bean.Course;
import project.bean.Student;
import project.dao.dao;
import project.dao.daoImpl;
import project.useCase.AdminAddNewCourse;
import project.useCase.AdminAllocateStudentsInaBatchUnderaCourse;
import project.useCase.AdminCreatBatchunderaCourse;
import project.useCase.AdminDeleteCourse;
import project.useCase.AdminDisplayCourseInfo;
import project.useCase.AdminUpdateFeesOfCourse;
import project.useCase.AdminUpdateTotalSeatsOfaBatch;
import project.useCase.AdminViewStudentsOfEveryBatch;
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
					AdminAddNewCourse a = new AdminAddNewCourse();
					break;
				}
				case 2: {
					AdminUpdateFeesOfCourse a = new AdminUpdateFeesOfCourse();
					break;

				}
				case 3: {
					AdminDeleteCourse a = new AdminDeleteCourse();
					break;

				}
				case 4: {
					AdminDisplayCourseInfo a = new AdminDisplayCourseInfo();
					break;

				}
				case 5: {
					AdminCreatBatchunderaCourse a = new AdminCreatBatchunderaCourse();		
					break;
				}
				case 6: {
					AdminAllocateStudentsInaBatchUnderaCourse a = new AdminAllocateStudentsInaBatchUnderaCourse();
					break;
				}
				case 7: {
					AdminUpdateTotalSeatsOfaBatch a = new AdminUpdateTotalSeatsOfaBatch();
					break;
				}
				case 8: {
					AdminViewStudentsOfEveryBatch a = new AdminViewStudentsOfEveryBatch();
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

		else System.out.println("Please enter valid input 1, 2 or 3");
		
		}
		catch(InputMismatchException ime) {
			System.out.println("Please enter valid input");
		}
		
		
	}

}
