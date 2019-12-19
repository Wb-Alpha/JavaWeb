package LoginSystem;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IndexServlet extends HttpServlet{
	
	public void doGet(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		//创建或者获取保存用户信息的Session对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.getWriter().print("您还没有登录，请<a href'/Start/login.html'>登录</a>");
		}
		else {
			response.getWriter().print("您已登录，欢迎你，" + user.getUsename());
			response.getWriter().print("<a href='/Start/LogoutServlet'>退出</a>");
		}
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60);
		cookie.setPath("/Start");
		response.addCookie(cookie);
	}
	
	
	public void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException,ServletException{
		doGet(response,request);
	}
}
