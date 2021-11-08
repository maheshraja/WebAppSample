package com.yogesh.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author mahesh
 *
 */
@WebServlet("/")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		switch (action) {
		case "/user/create":
			createUser(req,resp);
			break;

		default:
			System.out.println("The path is"+ req.getServletPath());
			resp.getWriter().write("Inside"+req.getServletPath());
			break;
		}
	}

	private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Create User");
		resp.getWriter().write("Inside Create User");
		
	}
	
}
