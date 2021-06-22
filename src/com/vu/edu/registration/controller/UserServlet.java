package com.vu.edu.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import com.vu.edu.registration.dao.UserDao;
import com.vu.edu.registration.model.Faculty;
import com.vu.edu.registration.model.RegisteredStudent;
import com.vu.edu.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/homePage.jsp");
		//dispatcher.forward(request, response);
		System.out.println("UserServlet-doGet we r here!!"+ UUID.randomUUID().toString().length());
		String pathInfo = request.getPathInfo();
		request.getRequestDispatcher("/WEB-INF/views/UserRegister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean validUser = false;
		System.out.println("project saved on git");
		String role = request.getParameter("roles");
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("Role:"+ role);
		User aUser = new User();
		aUser.setId(id);
		aUser.setFirstName(firstName);
		aUser.setLastName(lastName);
		aUser.setPassword(password);
		aUser.setUserName(userName);
		aUser.setDob(request.getParameter("dob"));
		aUser.setRole(role);
		aUser.setVersion(0);
		
	
		try {
			validUser = isValidUser(aUser);
			if(validUser) {
				userDao.registerUser(aUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userDetails.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
			dispatcher.forward(request, response);
		}
		if(validUser == false) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/invalidUser.jsp");
			dispatcher.forward(request, response);
		}
	}

	public boolean isValidUser(User userToRegister)throws ClassNotFoundException {
		String userRole = userToRegister.getRole();
		if(userRole.equalsIgnoreCase("Faculty")){
			Faculty faculty = userDao.getFaculty(userToRegister);
			if(faculty ==null) {
				return false;
			}else {
				return true;
			}
		}else {
			RegisteredStudent student = userDao.getRegisteredStudent(userToRegister);
			if(student == null) {
				return false;
			}else {
				if(userRole.equalsIgnoreCase("Student")) {
					return true;
				}else {
					if(userToRegister.getFirstName().equalsIgnoreCase(student.getParentFirst()) &&
							userToRegister.getLastName().equalsIgnoreCase(student.getParentLast())) {
						return true;
					}else {
						return false;
					}
				}
			}
			
		}
	}
}
