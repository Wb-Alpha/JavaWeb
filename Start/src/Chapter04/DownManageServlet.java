package Chapter04;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownManageServlet
 * 利用Referer防止盗链
 */
@WebServlet("/DownManageServlet")
public class DownManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;setchar=utf-8");
		PrintWriter out = response.getWriter();
		//获取Referer头的值
		String referer = request.getHeader("referer");
		//获取访问地址
		String sitePart = "http://" + request.getServerName();
		//判断referer头是否为空，判断该地址是否是以sitePart开始的
		if (referer != null && referer.startsWith(sitePart))
			//处理正在下载的请求
			out.println("dealing download........");
		else {
			//非法下载请求就跳转到download.html页面
			RequestDispatcher rd = request.getRequestDispatcher("/download.html");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
