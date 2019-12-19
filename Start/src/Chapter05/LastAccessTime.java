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
		//��ȡ���е�cookies�����ҽ���Щcookies�����������
		Cookie[] cookies = request.getCookies();
		//����cookies����
		for (int i=0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				//���cookie�����ƽ���lastAccess,�ͻ�ȡ��cookie��ֵ
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		
		if (lastAccessTime == null) {
			response.getWriter().print("�����״η��ʱ�վ!!!");
		}
		else {
			response.getWriter().print("���ϴη��ʵ�ʱ���ǣ�"+lastAccessTime);
			
		}
		
		//����cookie,���ҽ���ǰʱ�䵱��cookie��ֵ���͸��ͻ���
		String currentTime = new SimpleDateFormat("yyyy-mm-dd_hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastAccess",currentTime);
		cookie.setMaxAge(60*60);
		//����cookie
		response.addCookie(cookie);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
