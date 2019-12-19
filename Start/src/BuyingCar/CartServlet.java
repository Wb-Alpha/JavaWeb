package BuyingCar;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet{
	public void doGet(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//变量cart引用用户购物车
		List<Book> cart = null;
		//变量purFlag标记用户是否购买过商品
		boolean purFlag = true;
		//获取用户的session
		HttpSession session = request.getSession(false);
		//如果session为null,purFlag置为false
		if (session == null) {
			purFlag = false;
		}
		else {
			//获取用户的购物车
			cart = (List)session.getAttribute("cart");
			//如果用的购物车为null，purFlag置为false
			if (cart == null) {
				purFlag = false;
			}
		}
		
		//如果purFlag为false，表明用户没有购买图书，重新定向到ListServlet
		if (!purFlag) {
			out.write("对不起！您还没有将任何商品添加到购物车");
		}
		else {
			//否则显示用户添加到购物车中的图书信息
			out.write("您将要购买的图书有：<br/>");
			double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br/>");
			}
		}
	}
	
	public void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		
	}
}
