package com.vu.edu.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import com.vu.edu.registration.model.Faculty;
import com.vu.edu.registration.model.Parent;
import com.vu.edu.registration.model.RegisteredStudent;
import com.vu.edu.registration.model.User;

public class UserDao {
	
	public int registerUser(User user)throws ClassNotFoundException{
		int result =0;
		String INSERT_USERS_SQL = "INSERT INTO USER " + 
		" (ID, STATUS, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME,DOB, ROLE, VERSION) VALUES " +
	    "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualschool?useSSL=false", "AHMEDM", "Initial1");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setInt(2, user.getStatus());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getFirstName());
			preparedStatement.setString(6, user.getLastName());
			preparedStatement.setString(7, user.getDob());
			preparedStatement.setString(8, user.getRole());
			preparedStatement.setInt(9, user.getVersion());
			System.out.println("Executing query:" + preparedStatement);
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return result;
	}
	
	public ArrayList <User> getAllUsers()throws ClassNotFoundException{
		ArrayList<User> users = new ArrayList<User>();
		String GET_USERS_SQL = "Select * from User ";		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualschool?useSSL=false", "AHMEDM", "Initial1");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_USERS_SQL);
			while(rs.next()) {
				User currentUser = new User();
				currentUser.setId(rs.getString("ID"));
				currentUser.setStatus(rs.getInt("STATUS"));
				currentUser.setUserName(rs.getString("USERNAME"));
				currentUser.setPassword(rs.getString("PASSWORD"));
				currentUser.setFirstName(rs.getString("FIRST_NAME"));
				currentUser.setLastName(rs.getString("LAST_NAME"));
				currentUser.setDob(rs.getString("DOB"));
				currentUser.setRole(rs.getString("ROLE"));
				currentUser.setVersion(rs.getInt("VERSION"));
				users.add(currentUser);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return users;
	}
	
	public RegisteredStudent getRegisteredStudent(User user)throws ClassNotFoundException{
		RegisteredStudent currentUser = null;
		String GET_USER_SQL = "Select * from registeredstudent where STUDENTID = ?";
		
				
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualschool?useSSL=false", "AHMEDM", "Initial1");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			System.out.println("UserId:"+ user.getId());
			preparedStatement.setString(1, user.getId());
			System.out.println("Execuing Query from getRegisteredStudent:"+ preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				currentUser = new RegisteredStudent();
				currentUser.setStudentId(rs.getString("STUDENTID"));
				currentUser.setFirstName(rs.getString("FIRST_NAME"));
				currentUser.setLastName(rs.getString("LAST_NAME"));
				currentUser.setDob(rs.getString("DOB"));
				currentUser.setParentFirst(rs.getString("PARENT_FIRST"));
				currentUser.setParentLast(rs.getString("PARENT_LAST"));
				currentUser.setStatus(rs.getString("STATUS"));
				currentUser.setVersion(rs.getInt("VERSION"));
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return currentUser;
	}

	public Faculty getFaculty(User user)throws ClassNotFoundException{
		String GET_USER_SQL = "Select * from faculty where EMPLOYEEID = ?";	
		Faculty currentUser = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualschool?useSSL=false", "AHMEDM", "Initial1");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			preparedStatement.setString(1, user.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				currentUser = new Faculty();
				currentUser.setEmployeeId(rs.getString("EMPLOYEEID"));
				currentUser.setFirstName(rs.getString("FIRST_NAME"));
				currentUser.setLastName(rs.getString("LAST_NAME"));
				currentUser.setDob(rs.getString("DOB"));
				currentUser.setStatus(rs.getString("STATUS"));
				currentUser.setVersion(rs.getInt("VERSION"));
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return currentUser;
	}
	
	public Parent getStudentParent(User user)throws ClassNotFoundException{
		Parent currentUser = null;
		String GET_USER_SQL = "Select * from parent where PARENTID = ?";
		
				
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualschool?useSSL=false", "AHMEDM", "Initial1");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			System.out.println("UserId:"+ user.getId());
			preparedStatement.setString(1, user.getId());
			System.out.println("Execuing Query from getRegisteredStudent:"+ preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				currentUser = new Parent();
				currentUser.setParentId(rs.getString("PARENTID"));
				currentUser.setStudentId(rs.getString("STUDENTID"));
				currentUser.setFirstName(rs.getString("FIRST_NAME"));
				currentUser.setLastName(rs.getString("LAST_NAME"));
				currentUser.setDob(rs.getString("DOB"));
				currentUser.setStatus(rs.getString("STATUS"));
				currentUser.setVersion(rs.getInt("VERSION"));
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return currentUser;
	}

}
