package BuyingCar;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet{
	public void doGet(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//����cart�����û����ﳵ
		List<Book> cart = null;
		//����purFlag����û��Ƿ������Ʒ
		boolean purFlag = true;
		//��ȡ�û���session
		HttpSession session = request.getSession(false);
		//���sessionΪnull,purFlag��Ϊfalse
		if (session == null) {
			purFlag = false;
		}
		else {
			//��ȡ�û��Ĺ��ﳵ
			cart = (List)session.getAttribute("cart");
			//����õĹ��ﳵΪnull��purFlag��Ϊfalse
			if (cart == null) {
				purFlag = false;
			}
		}
		
		//���purFlagΪfalse�������û�û�й���ͼ�飬���¶���ListServlet
		if (!purFlag) {
			out.write("�Բ�������û�н��κ���Ʒ��ӵ����ﳵ");
		}
		else {
			//������ʾ�û���ӵ����ﳵ�е�ͼ����Ϣ
			out.write("����Ҫ�����ͼ���У�<br/>");
			double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br/>");
			}
		}
	}
	
	public void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		
	}
}
