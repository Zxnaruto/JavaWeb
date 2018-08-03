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
 * ע����ʽ��������xml,ֻ��action������@WebServlet("/Hello2Servlet")��ͬ�ͺ�
 */
@WebServlet("/Hello2Servlet")
public class Hello2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();//��������Ӧ--��ӡ��
		//request�ǰ����û�������������Ϣ
		String name = request.getParameter("name");//����name,�ĵ��ͻ��˱��������name��name��html�е�name��ͬ
		writer.println("<h1>hello"+name+"</h1>");//input name="name"  �����name��value
		writer.close();
	}



}
