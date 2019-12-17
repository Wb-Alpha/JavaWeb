package Chapter04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取消息行信息的方法
 */
@WebServlet("/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取请求行的相关信息
		out.println("getMethod:" + request.getMethod() + "<br>");
		out.println("getRequestURI" + request.getRequestURI() + "<br>");
		out.println("getQueryString" + request.getQueryString() + "<br>");
		out.println("getProtocol" + request.getProtocol() + "<br>");
		out.println("getPathInfo" + request.getPathInfo() + "<br>");
		out.println("getContextPath" + request.getContextPath() + "<br>");
		out.println("getPathTranslated" + request.getPathTranslated() + "<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
