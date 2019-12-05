package New;

import java.io.IOException;
import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet06
 */

//获取Web应用下的资源文件
@WebServlet("/TestServlet06")
public class TestServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet06() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = this.getServletContext();
		PrintWriter out = response.getWriter();
		//获取相对路径中的输入流对象
		InputStream in = context.getResourceAsStream("/WEB-INF/Resource/resourece01");
		Properties pros = new Properties();
		pros.load(in);
		out.println("Company="+ pros.getProperty("Company") + "</br>");
		out.println("Dept="+ pros.getProperty("Dept") + "</br>");
		out.println("Fee="+ pros.getProperty("Fee") + "</br>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
