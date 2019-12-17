package Chapter04;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��forward()����������ת��������һ��ҳ��
 */
@WebServlet("/RequestForwardServlet")
public class RequestForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("company", "Apple.Inc");
		//�����ݴ��浽request������
		RequestDispatcher rd = request.getRequestDispatcher("/ResultServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
