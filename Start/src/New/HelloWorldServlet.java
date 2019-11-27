package New;
import java.io.*;
import javax.servlet.*;

public class HelloWorldServlet extends GenericServlet{
	public void init(ServletConfig config) throws ServletException{
		System.out.println("init method is called");
	}
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
	
	public void destroy() {
		System.out.println("destroy method is called");
	}
}