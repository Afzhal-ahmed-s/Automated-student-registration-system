package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.bean.Course;
import project.bean.Student;
import project.exceptions.CourseException;
import project.exceptions.StudentException;
import project.utility.DButil;

public class daoImpl implements dao{

	@Override
	public String registerStudent(Student student) throws StudentException, SQLException {
		
		String answer = "Student already exists!";
		String sEmail = student.getsEmail();
		String sPassword = student.getsPassword();
		String sName = student.getsName();
		
		try(Connection conn = DButil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into students values (?, ?, ?)");
			ps.setString(1, sEmail);
			ps.setString(2, sPassword);
			ps.setString(3, sName);
			
			int x = ps.executeUpdate();
			answer = x + " student statements inserted";
			
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
		return answer;
		
	}
	
	@Override
	public boolean checkForStudent(String sEmail, String sPassword) throws StudentException {
		boolean answer = false;

		try(Connection conn = DButil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from students where sEmail= ? AND sPassword = ?");
			ps.setString(1, sEmail);
			ps.setString(2, sPassword);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				answer = true;
			}
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return answer;
	}

	@Override
	public List<Course> getListOfCourses() throws SQLException, CourseException {
		
		List<Course> listOfCourses = new ArrayList<>();
		boolean isEmpty = true;
		
		try(Connection conn = DButil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from courses");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				isEmpty = false;
				int cId = rs.getInt("cId");
				String cName = rs.getString("cName");
				int fees = rs.getInt("fees");
				String cInfo = rs.getString("cInfo");
				
				Course c = new Course(cId, cName, fees, cInfo);
				listOfCourses.add(c);
			}
		}
		catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
		if(isEmpty)throw new CourseException("No course present");
		
		return listOfCourses;
		
		
		
	}


	@Override
	public boolean checkForCourse(String cName) throws SQLException, CourseException {
		boolean answer = false;

		try(Connection conn = DButil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select cName from courses where cName = ?");
			ps.setString(1, cName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())answer = true;
			
			
			
		}
		catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}
		System.out.println("answer: "+answer);
		return answer;
	}


	@Override
	public int getCourseId(String cName) throws SQLException, CourseException {
		
		int answer = 0;
		
		try(Connection conn = DButil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select cId from courses where cName = ?");
			ps.setString(1, cName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				answer = rs.getInt("cId");
			}
		}
		catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
		return answer;
		
	}

	@Override
	public void registerBatch(int cId, String cName, String sEmail) throws SQLException {
		int lbatchId;
		int ltotalSeats;
		int lseatsFilled;
		int fbatchId;
		try(Connection conn = DButil.getConnection()){

			PreparedStatement ps = conn.prepareStatement("select bId, totalSeats, seatsFilled from batchSeats where cId = ?");
			ps.setInt(1, cId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				lbatchId = rs.getInt("bId");
				ltotalSeats = rs.getInt("totalSeats");
				lseatsFilled = rs.getInt("seatsFilled");

				if(lseatsFilled < ltotalSeats) {
					System.out.println("once");
					fbatchId = lbatchId;
					PreparedStatement ps2 = conn.prepareStatement("insert into batch (batchNo, cId, sEmail) values (?, ?, ?)");
					ps2.setInt(1, fbatchId);
					ps2.setInt(2, cId);
					ps2.setString(3, sEmail);
					
					PreparedStatement ps3 = conn.prepareStatement("update batchSeats set seatsFilled = (seatsFilled + 1) where cId = ? ");
					ps3.setInt(1, cId);
					ps3.executeUpdate();
					System.out.println("1 seat updated in CourseId: "+ cId );
					int x = ps2.executeUpdate();
					System.out.println(x + " statements inserted");
				}
			}
			
		}
		catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}

		
	}



	


	
	
	
}
