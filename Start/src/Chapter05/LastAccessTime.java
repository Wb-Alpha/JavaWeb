package Chapter05;

import java.io.IOException;
import java.text.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessTime
 */
@WebServlet("/LastAccessTime")
public class LastAccessTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastAccessTime() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String lastAccessTime = null;
		//获取所有的cookies，并且将这些cookies存放在数组中
		Cookie[] cookies = request.getCookies();
		//遍历cookies数组
		for (int i=0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				//如果cookie的名称叫做lastAccess,就获取该cookie的值
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		
		if (lastAccessTime == null) {
			response.getWriter().print("您是首次访问本站!!!");
		}
		else {
			response.getWriter().print("您上次访问的时间是："+lastAccessTime);
			
		}
		
		//创建cookie,并且将当前时间当做cookie的值发送给客户端
		String currentTime = new SimpleDateFormat("yyyy-mm-dd_hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastAccess",currentTime);
		cookie.setMaxAge(60*60);
		//发动cookie
		response.addCookie(cookie);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
