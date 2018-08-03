package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello2Servlet
 * 注解形式，不用配xml,只需action名称与@WebServlet("/Hello2Servlet")相同就好
 */
@WebServlet("/Hello2Servlet")
public class Hello2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();//服务器响应--打印流
		//request是包含用户的所有请求信息
		String name = request.getParameter("name");//请求name,的到客户端表单中输入的name，name与html中的name相同
		writer.println("<h1>hello"+name+"</h1>");//input name="name"  ，输出name的value
		writer.close();
	}



}
