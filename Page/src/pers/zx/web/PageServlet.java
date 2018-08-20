package pers.zx.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.zx.dao.NinjaDao;
import pers.zx.dao.NinjaDaoImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rows=5;//һҳ��ʾ����Ϣ
		int pageNos;//ҳ��
		int countPage;
		NinjaDao list=new NinjaDaoImpl();
		countPage=list.pages(rows);//��ҳ��
		
		HttpSession session = request.getSession(); // �����ݴ浽session���Ա�����ǰ̨��ȡ
		
        session.setAttribute("countPage", countPage);
	    if (request.getParameter("pageNos") == null|| Integer.parseInt(request.getParameter("pageNos"))<1) {
	    	pageNos = 1;
           session.setAttribute("NinjaList", list.ninja(0, rows));
           //��ǰҳ��
           session.setAttribute("pageNos", pageNos);
        } else {
        	pageNos = Integer.parseInt(request.getParameter("pageNos"));
            session.setAttribute("NinjaList",list.ninja((pageNos-1)*rows, rows));
            //��ǰҳ��
            session.setAttribute("pageNos", pageNos);
        }
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
