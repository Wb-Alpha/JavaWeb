package com.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		double num1 = 0., num2 = 0.;
		String str = request.getParameter("num1");
		if (str != null)
			num1 = Double.parseDouble(str);
		str = request.getParameter("num2");
		if (str != null)
			num2 = Double.parseDouble(str);
		double result = num1 + num2;  // 
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/WEB-INF/jsp/arithmeticResult.jsp").forward(request, response);
    }
}