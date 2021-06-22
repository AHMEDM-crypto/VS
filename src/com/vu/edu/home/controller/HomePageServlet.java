package com.vu.edu.home.controller;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vu.edu.registration.dao.UserDao;
import com.vu.edu.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
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
		System.out.println("HomePageServlet-do-Get");
		String pathInfo = request.getRequestURI();
		System.out.println("HomePageServlet-doGet:"+ pathInfo);
		if(pathInfo.contains("UserServlet")) {
			System.out.println("HomePageServlet-requestURL contains UserServlet");
		request.getRequestDispatcher("/WEB-INF/views/UserRegister.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/homePage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomePageServlet-doPost:"+ request.getRequestURI());
		/*
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User aUser = new User();
		aUser.setFirstName(firstName);
		aUser.setLastName(lastName);
		aUser.setPassword(password);
		aUser.setUserName(userName);
		aUser.setId(UUID.randomUUID().toString());
		aUser.setVersion(0);
		aUser.setStatus(0);
		try {
			userDao.registerUser(aUser);
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userDetails.jsp");
		dispatcher.forward(request, response);
		*/
		
	}

}
