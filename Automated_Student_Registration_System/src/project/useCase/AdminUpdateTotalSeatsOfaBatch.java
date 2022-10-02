package project.useCase;

import project.dao.dao;
import project.dao.daoImpl;

public class AdminUpdateTotalSeatsOfaBatch {
	public AdminUpdateTotalSeatsOfaBatch() {
		dao daoObj = new daoImpl();
		daoObj.adminUpdateTotalSeatsOfaBatch();

	}
}
