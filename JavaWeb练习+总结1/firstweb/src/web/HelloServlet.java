package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
/*shift+alt+sѡ��implement�Զ���Ӵ���*/
	@Override//��д
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//alt+shift+l ��ݼ� �Զ����ɷ���
		PrintWriter out = response.getWriter();
		out.println("<h1>���Hello Servlet</h1>");
		
		out.close();
		
	}

}
