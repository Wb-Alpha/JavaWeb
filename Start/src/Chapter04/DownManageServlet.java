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
 * ����Referer��ֹ����
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
		//��ȡRefererͷ��ֵ
		String referer = request.getHeader("referer");
		//��ȡ���ʵ�ַ
		String sitePart = "http://" + request.getServerName();
		//�ж�refererͷ�Ƿ�Ϊ�գ��жϸõ�ַ�Ƿ�����sitePart��ʼ��
		if (referer != null && referer.startsWith(sitePart))
			//�����������ص�����
			out.println("dealing download........");
		else {
			//�Ƿ������������ת��download.htmlҳ��
			RequestDispatcher rd = request.getRequestDispatcher("/download.html");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
