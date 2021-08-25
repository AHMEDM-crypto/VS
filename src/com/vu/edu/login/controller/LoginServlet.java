package com.vu.edu.login.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vu.edu.registration.dao.UserDao;
import com.vu.edu.registration.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("LoginServlet-doGet !!");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}catch(Exception cnfe) {}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doPost we r here!!");
		User user = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		try {
			user = userDao.getUserByNameNPassword(userName, password);
			//user = userDao.getUserByUserName(userName);
			if(user != null && user.getPassword().equals(password)) {
				String userRole = user.getRole();
				
				if(userRole.equalsIgnoreCase("Student")) {
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/studentPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Parent")) {
				    dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/parentPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Faculty")) {
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/facultyPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Employee")) {
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/adminPage.jsp");					
				}else {
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");					
				}
			}else {
				dispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");				
			}
			dispatcher.forward(request, response);
			
		}catch(Exception ignore4now) {}
	}

}
