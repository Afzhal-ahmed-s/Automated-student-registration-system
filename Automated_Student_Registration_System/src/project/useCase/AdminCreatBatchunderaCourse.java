package project.useCase;

import java.util.Scanner;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminCreatBatchunderaCourse {
	public AdminCreatBatchunderaCourse() {
		Scanner sc = new Scanner(System.in);
		dao daoObj = new daoImpl();
		System.out.println("Enter Course name:");
		String cName = sc.next().toUpperCase();
		System.out.println("Enter Batch no:");
		int bId = sc.nextInt();
		System.out.println("Enter total seats in this batch: ");
		int totalSeats = sc.nextInt();
		daoObj.adminCreatBatchunderaCourse(cName, bId, totalSeats);

	}
}
