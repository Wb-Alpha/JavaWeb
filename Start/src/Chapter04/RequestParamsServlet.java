package Chapter04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ�û��ύ�ı�����
 */
@WebServlet("/RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("�û���:"+name);
		System.out.println("����"+password);
		//��ȡ������Ϊhobbys��ֵ
		String[] hobbys = request.getParameterValues("hobby");
		System.out.println("���ã�");
		System.out.println(hobbys.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
