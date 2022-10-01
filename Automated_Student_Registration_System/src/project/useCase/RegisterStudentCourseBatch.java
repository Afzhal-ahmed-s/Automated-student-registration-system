package project.useCase;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import project.bean.Course;
import project.bean.Student;
import project.dao.dao;
import project.dao.daoImpl;
import project.exceptions.CourseException;
import project.exceptions.StudentException;

public class RegisterStudentCourseBatch {

	public RegisterStudentCourseBatch() {
		
		Scanner sc  = new Scanner(System.in);
		Student s = null;
		String cName = null;
		
		try{	
		System.out.println("Enter your e-mail:");
		String sEmail = sc.next();
		System.out.println("Enter your Password:");
		String sPassword = sc.next();
		System.out.println("Enter your Name:");
		String sName = sc.next();				
		
		s = new Student(sEmail, sPassword, sName);
		
		dao daoObj = new daoImpl();
		
		try {
			Boolean ans = daoObj.checkForStudent(sEmail, sPassword);
			if(!ans) {
				daoObj.registerStudent(s);
				System.out.println();
				System.out.println("Student "+ sName +" with e-mail "+ sEmail +" registstered successfully");
				System.out.println();
								
				System.out.println("Enter yes to join a course. ");
				System.out.println("Enter no to quit");
				String opt = sc.next();
				
				if(opt.equalsIgnoreCase("yes")) {
					System.out.println("List of courses available:");
					daoObj.displayCourseAvailableWithOrWithoutSeats("includeslno");

					System.out.println("Enter the name of the course name you want to join:");

					String sDecision2 = sc.next().toUpperCase();
					int cId = daoObj.getCourseId(sDecision2);
					
					if(daoObj.checkForCourse(sDecision2)) {
						daoObj.registerBatch(cId, sDecision2, sEmail);
					}
					else {
						System.out.println("Such course "+ sDecision2 +" doesn't exist");
						
					}
				}
				else throw new CourseException("Have a nice day " +sName +" .");
				
			}
			else System.out.println("student already exists");
		}
		catch(StudentException e){
			System.out.println(e.getMessage());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} catch (CourseException e1) {
			System.out.println(e1.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}
