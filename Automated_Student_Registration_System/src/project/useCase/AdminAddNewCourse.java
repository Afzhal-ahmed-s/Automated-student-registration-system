package project.useCase;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminAddNewCourse {

	public AdminAddNewCourse() {
		dao daoObj = new daoImpl();
		daoObj.adminAddNewCourse();
	}
	
}
