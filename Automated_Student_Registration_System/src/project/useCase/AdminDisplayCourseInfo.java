package project.useCase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import project.bean.Course;
import project.dao.dao;
import project.dao.daoImpl;
import project.exceptions.CourseException;

public class AdminDisplayCourseInfo {

	public AdminDisplayCourseInfo() throws SQLException, CourseException {
		Scanner sc = new Scanner(System.in);
		dao daoObj = new daoImpl();
		List<Course> lisOfCourses = daoObj.getListOfCourses();
		System.out.println("List of courses-");
		lisOfCourses.forEach(c ->{
			System.out.println(c.getCname());
		});
		System.out.println("Enter course name to get it's information");
		String cName = sc.next();
		daoObj.adminDisplayCourseInfo(cName);
}
}
