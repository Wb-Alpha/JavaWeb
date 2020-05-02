package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="arithmetic",urlPatterns={"/arithmetic"})
public class ArithmeticServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, java.io.IOException
	{
		double num1 = 0., num2 = 0.;
		String str = request.getParameter("num1");
		if (str != null)
			num1 = Double.parseDouble(str);
		str = request.getParameter("num2");
		if (str != null)
			num2 = Double.parseDouble(str);
		double result = num1 + num2;
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);		
	}
}