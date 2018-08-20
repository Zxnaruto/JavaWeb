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
	        // 获取当前页
	        String curpage = request.getParameter("curpage");
	        NinjaService ninjaService = new NinjaServiceImpl();
	        // 获取总数量
	        int count = ninjaService.getAmount();
	        //字符串转成整型
	        int currentpage = super.currentPage(curpage);
	        // 创建page对象
	        Page page = new Page(count, currentpage, pagesize);
	        // 获取当前页的数据
	        List<Ninja> ninjas = ninjaService.getNinjaInfo(page);
	        //将相关数据存储起来
	        request.setAttribute("page", page);
	        request.setAttribute("ninjas", ninjas);//页面显示
	        
	        System.out.println(count);
	        System.out.println(ninjas);
	        //转发
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
