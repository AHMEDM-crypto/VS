package com.vu.edu.registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vu.edu.registration.dao.UserDao;
import com.vu.edu.registration.model.Tuition;
import com.vu.edu.registration.model.User;

@WebServlet("/FeeServlet")
public class FeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Tuition> list = new ArrayList<Tuition>();
			list = userDao.getAllGradeTuition();
			request.setAttribute("tuitions", list);
			System.out.println("FeeServlet-doGet we r here!!");
			String pathInfo = request.getPathInfo();
			request.getRequestDispatcher("/WEB-INF/views/accounts/tutionAndFees.jsp").forward(request, response);
		}catch(ClassNotFoundException cnfe) {}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FacultyServlet-doPost we r here!!");
	}

}
