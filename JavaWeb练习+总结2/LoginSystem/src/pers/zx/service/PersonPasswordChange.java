package pers.zx.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.dao.UserChangePassword;

public class PersonPasswordChange extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ӡ��
		PrintWriter writer = response.getWriter();
		//��ȡֵ
		String password = request.getParameter("psdc");
		String passwordc = request.getParameter("psdc1");
		String idcard=request.getParameter("idcard");
		UserChangePassword passwordChange=new UserChangePassword();
		if(password.equals(passwordc)) {
			int count= passwordChange.userChangePassword(password,idcard);
			if(count==1) {
			writer.println("<h1>�޸ĳɹ�<h1>");
			writer.println("<a href='Login.html'>����</a>");
			}
		}else {
			writer.println("<h1>�޸�ʧ�ܣ�����</h1>");
			writer.println("<a href='psdchange.html'>�����޸�</a>");
			writer.println("<a href='user.html'>����</a>");
		}
	}

	
}
