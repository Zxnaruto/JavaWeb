package pers.zx.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.dao.Insert;

@SuppressWarnings("serial")
public class PersonInsert extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ӡ��
		PrintWriter writer = response.getWriter();
		//��ȡֵ
		String name = request.getParameter("name");
		 String sex = request.getParameter("sex");
		 Integer age = Integer.valueOf(request.getParameter("age"));
		 String idcard=request.getParameter("idcard");
		 String tel=request.getParameter("tel");
		 String loginname=request.getParameter("loginname");
		 String password=request.getParameter("psd");
		 String password1=request.getParameter("psd_c");
	    //���ò��뺯��
		 Insert insert=new Insert();
		 int[] count=new int[2];
		 if(password.equals(password1)) {
		 count=insert.Ins(name, sex, age, idcard, tel,password,loginname);
		 if(count[0]==1&&count[1]==1) {
			 writer.println("<h1>��ӳɹ�</h1>");
		 }
		 }else {
			 writer.println("<h1>���ʧ��</h1>");
			 writer.println("<a href='Login.html'>����</a>");
		 }
		
		 writer.println("<a href='Login.html'>����</a>");
		/* response.sendRedirect("Login.html");*/ //�ض���
		 
		 writer.close();
	}

}
