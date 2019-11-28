package New;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet03
 *
@WebServlet(
		urlPatterns = { "/TestServlet03" }, 
		initParams = { 
				@WebInitParam(name = "companyName", value = "Apple.Inc"), 
				@WebInitParam(name = "address", value = "GuangZhou")
		})*/
public class TestServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServlet03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//得到ServletContext对象
		ServletContext context = this.getServletContext();
		//得到包含所有初始化参数名的Enumeration对象
		Enumeration<String> paramName = context.getInitParameterNames();
		out.println("all the paramNames and paramValue are following:");
		//遍历所有初始化参数名，得到相应的参数值并且打印
		while( paramName.hasMoreElements()) {
			String name = paramName.nextElement();
			String value = context.getInitParameter(name);
			out.println(name+":"+value);
			out.println("</br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
