package project.useCase;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminViewStudentsOfEveryBatch {
	public AdminViewStudentsOfEveryBatch() {
		dao daoObj = new daoImpl();
		daoObj.adminViewStudentsOfEveryBatch();

	}
}
