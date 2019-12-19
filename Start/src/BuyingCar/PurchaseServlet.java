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
			//���idΪ�գ����ض���ListBookServletҳ��
			String url = "/Start/ListBookServlet";
			response.sendRedirect(url);
			return;
		}
		
		Book book = BookDB.getBook(id);
		//�������߻�ȡ�û���Session����
		HttpSession session = request.getSession();
		//��Session�����л�ȡ�û����ﳵ
		List<Book> cart = (List) session.getAttribute("cart");
		if (cart == null) {
			//�״ι���Ϊ�û�����һ�����ﳵ(List����ģ�⹺�ﳵ)
			cart = new ArrayList<Book>();
			//�����ﳵ����Session����
			session.setAttribute("cart", cart);
		}
		
		//����Ʒ���빺�ﳵ
		cart.add(book);
		//����Cookie���Session�ı�ʶ��
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60);
		cookie.setPath("/Start");
		response.addCookie(cookie);
		//�ض��򵽹��ﳵҳ��
		String url = "/Start/CartServlet";
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
