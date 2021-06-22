package com.vu.edu.registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vu.edu.registration.dao.UserDao;
import com.vu.edu.registration.model.User;

@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<User> list = new ArrayList<User>();
			list = userDao.getAllUsers();
			request.setAttribute("users", list);
			System.out.println("FacultyServlet-doGet we r here!!");
			String pathInfo = request.getPathInfo();
			request.getRequestDispatcher("/WEB-INF/views/UserFaculty.jsp").forward(request, response);
		}catch(ClassNotFoundException cnfe) {}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FacultyServlet-doPost we r here!!");
	}

}
