package project.useCase;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminAllocateStudentsInaBatchUnderaCourse {
	public AdminAllocateStudentsInaBatchUnderaCourse() {
		dao daoObj = new daoImpl();
		daoObj.adminAllocateStudentsInaBatchUnderaCourse();

	}
}
