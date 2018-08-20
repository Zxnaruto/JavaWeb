package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageServletTest
 */
@WebServlet("/PageServletTest")
public class PageServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  List<User> list = new ArrayList<User>();
	        // �������Ҳ����������ݿ��������������ݽ��в���Ч����С�������������ݿ��ѯ��֮�󷵻�һ��list
	        for (int i = 1; i < 7; i++) {
	            User user1 = new User();
	            user1.setUsername("��" + i + "���û���");
	            user1.setPassword("��" + i + "����");
	            list.add(user1);
	        }
	        HttpSession session = request.getSession();
	        // �����ݴ浽session���Ա�����ǰ̨��ȡ
	        session.setAttribute("userList", list);
	        //��ȡ��ǰҳ��ҳ����תΪint����,���ս����ݴ浽session��
	        int pageNos;
	        if (request.getParameter("pageNos") == null
	                || Integer.parseInt(request.getParameter("pageNos")) < 1) {
	            pageNos = 1;
	        } else {
	            pageNos = Integer.parseInt(request.getParameter("pageNos"));
	        }
	        session.setAttribute("pageNos", pageNos);
	        // ������ҳ�����浽session��
	        int countPage = 3;
	        // ��ʵ�ʿ��������ǵ���ҳ�����Ը���sql���õ���ѯ������������Ȼ������������ÿҳ�������õ���ҳ��
	        session.setAttribute("countPage", countPage);
	        request.getRequestDispatcher("page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
