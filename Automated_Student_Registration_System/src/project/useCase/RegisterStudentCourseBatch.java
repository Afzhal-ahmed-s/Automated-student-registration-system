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
				System.out.println("Student with e-mail "+ sEmail +" registstered successfully");
				
				System.out.println("Enter course name you want to join:");
				List<Course> listOfCourses = daoObj.getListOfCourses();
				
				System.out.println("List of courses available");
				listOfCourses.forEach(c -> {
					System.out.println(c.getcId() +" -> "+ c.getCname());
				});
				System.out.println("Enter the name of the course name you want to join:");

				String sDecision2 = sc.next();
				int cId = daoObj.getCourseId(sDecision2);
				
				if(daoObj.checkForCourse(sDecision2)) {
					daoObj.registerBatch(cId, sDecision2, sEmail);
				}
				else {
					System.out.println("such course doesn't exist");
				}
				
			}
			else System.out.println("student already exists");
		}
		catch(StudentException e){
			System.out.println(e.getMessage());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} catch (CourseException e1) {
			System.out.println(e1.getMessage());
		}
	}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}
