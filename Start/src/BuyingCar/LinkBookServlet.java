package BuyingCar;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkBookServlet
 */
@WebServlet("/LinkBookServlet")
public class LinkBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Collection<Book> books = BookDB.getAll();
		out.print("本站提供的图书有：<br/>");
		for (Book book : books) {
			String url = "/Start/PurchaseServlet?id=" + book.getID();
			out.write(book.getName() + "<a href='" + url + "'>点击购买</a><br/>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
