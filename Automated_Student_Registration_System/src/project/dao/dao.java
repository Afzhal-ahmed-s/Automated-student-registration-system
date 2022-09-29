package project.dao;

import java.sql.SQLException;
import java.util.List;

import project.bean.Course;
import project.bean.Student;
import project.exceptions.CourseException;
import project.exceptions.StudentException;

public interface dao {

	public String registerStudent (Student student) throws StudentException, SQLException;
	public void registerBatch (int cId, String cName, String sEmail) throws SQLException;
	public boolean checkForStudent (String sEmail, String Password) throws StudentException;
	public List<Course> getListOfCourses () throws SQLException, CourseException; 
	public boolean checkForCourse (String cName) throws SQLException, CourseException;
	public int getCourseId (String cName) throws SQLException, CourseException; 
}
