package pers.zx.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.entity.Ninja;
import pers.zx.service.NinjaService;
import pers.zx.service.NinjaServiceImpl;
import pers.zx.utils.BaseServlet;
import pers.zx.utils.Page;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends BaseServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        // ��ȡ��ǰҳ
	        String curpage = request.getParameter("curpage");
	        NinjaService ninjaService = new NinjaServiceImpl();
	        // ��ȡ������
	        int count = ninjaService.getAmount();
	        //�ַ���ת������
	        int currentpage = super.currentPage(curpage);
	        // ����page����
	        Page page = new Page(count, currentpage, pagesize);
	        // ��ȡ��ǰҳ������
	        List<Ninja> ninjas = ninjaService.getNinjaInfo(page);
	        //��������ݴ洢����
	        request.setAttribute("page", page);
	        request.setAttribute("ninjas", ninjas);//ҳ����ʾ
	        
	        System.out.println(count);
	        System.out.println(ninjas);
	        //ת��
	        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);

	        
	        
	    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
