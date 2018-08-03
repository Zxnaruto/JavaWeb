package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
/*shift+alt+s选择implement自动添加代码*/
	@Override//重写
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//alt+shift+l 快捷键 自动生成方法
		PrintWriter out = response.getWriter();
		out.println("<h1>你好Hello Servlet</h1>");
		
		out.close();
		
	}

}
