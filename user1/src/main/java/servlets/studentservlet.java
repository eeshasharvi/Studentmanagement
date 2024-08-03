package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.studentdb;
import models.student;
import service.studentservice;


@WebServlet("/register")
public class studentservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String name = req.getParameter("name");
		String branch = req.getParameter("branch");
		String email = req.getParameter("email");
		long phoneno  = Long.parseLong(req.getParameter("phoneno"));
		
		student st = new student(0,name,branch,email,phoneno);
		studentservice service = new studentservice(studentdb.getconnection());
		boolean f = service.addstudent(st);
		if(f) {
			resp.sendRedirect("welcome.jsp");
		}
		else {
			resp.sendRedirect("register.jsp");
		}
	}
}
