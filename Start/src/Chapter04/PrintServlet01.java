package Chapter04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��PrintServlet������Ӧ��Ϣͷ
 */
@WebServlet("/PrintServlet01")
public class PrintServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String data = "���ѿ���";
		//��ȡ�ַ����������
		PrintWriter print = response.getWriter();
		print.write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
