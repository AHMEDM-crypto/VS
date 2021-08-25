package com.vu.edu.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SHBookServlet")
public class SHBookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public SHBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		try {
   			
   			String pathInfo = request.getPathInfo();
   			request.getRequestDispatcher("/WEB-INF/views/StudentHandBook.jsp").forward(request, response);
   		}catch(Exception cnfe) {}
   	}
   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		System.out.println("FacultyServlet-doPost we r here!!");
   	}


}
