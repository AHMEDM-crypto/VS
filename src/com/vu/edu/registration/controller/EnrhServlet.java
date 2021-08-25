package com.vu.edu.registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vu.edu.registration.dao.CourseDao;
import com.vu.edu.registration.model.Course;
import com.vu.edu.registration.model.Faculty;
import com.vu.edu.registration.model.User;


@WebServlet("/EnrhServlet")
public class EnrhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao = new CourseDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		try {
			List<Course> list = new ArrayList<Course>();
			list = courseDao.getCourses("ENRICHMENT");
			request.setAttribute("courses", list);
			System.out.println("EnrhServlet-doGet we r here!!");
			String pathInfo = request.getPathInfo();
			request.getRequestDispatcher("/WEB-INF/views/Enrichment.jsp").forward(request, response);
		}catch(ClassNotFoundException cnfe) {}
   	}
   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		System.out.println("EnrhServlet-doPost we r here!!:"+this.getServletContext().getContextPath());
   		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response); 		
  
   	}

}
