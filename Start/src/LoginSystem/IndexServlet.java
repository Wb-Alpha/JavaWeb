package LoginSystem;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IndexServlet extends HttpServlet{
	
	public void doGet(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		//�������߻�ȡ�����û���Ϣ��Session����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.getWriter().print("����û�е�¼����<a href'/Start/login.html'>��¼</a>");
		}
		else {
			response.getWriter().print("���ѵ�¼����ӭ�㣬" + user.getUsename());
			response.getWriter().print("<a href='/Start/LogoutServlet'>�˳�</a>");
		}
		//����Cookie���Session�ı�ʶ��
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60);
		cookie.setPath("/Start");
		response.addCookie(cookie);
	}
	
	
	public void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException,ServletException{
		doGet(response,request);
	}
}
