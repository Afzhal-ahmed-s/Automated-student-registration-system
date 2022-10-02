package project.useCase;

import java.util.Scanner;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminUpdateFeesOfCourse {
	public AdminUpdateFeesOfCourse() {
		Scanner sc = new Scanner(System.in);
		dao daoObj = new daoImpl();
		System.out.println("Enter Course name: ");
		String cName = sc.next();
		System.out.println("Enter fees to update:");
		int fees = sc.nextInt();
		daoObj.adminUpdateFeesOfCourse(cName, fees);
	}
}
