package BuyingCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id == null) {
			//如果id为空，则重定向到ListBookServlet页面
			String url = "/Start/ListBookServlet";
			response.sendRedirect(url);
			return;
		}
		
		Book book = BookDB.getBook(id);
		//创建或者获取用户的Session对象
		HttpSession session = request.getSession();
		//从Session对象中获取用户购物车
		List<Book> cart = (List) session.getAttribute("cart");
		if (cart == null) {
			//首次购买，为用户创建一个购物车(List集合模拟购物车)
			cart = new ArrayList<Book>();
			//将购物车存入Session对象
			session.setAttribute("cart", cart);
		}
		
		//将商品放入购物车
		cart.add(book);
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60);
		cookie.setPath("/Start");
		response.addCookie(cookie);
		//重定向到购物车页面
		String url = "/Start/CartServlet";
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
