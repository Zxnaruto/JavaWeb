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
		//防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//打印流
		PrintWriter writer = response.getWriter();
		//获取值
		String password = request.getParameter("psdc");
		String passwordc = request.getParameter("psdc1");
		String idcard=request.getParameter("idcard");
		UserChangePassword passwordChange=new UserChangePassword();
		if(password.equals(passwordc)) {
			int count= passwordChange.userChangePassword(password,idcard);
			if(count==1) {
			writer.println("<h1>修改成功<h1>");
			writer.println("<a href='Login.html'>返回</a>");
			}
		}else {
			writer.println("<h1>修改失败！！！</h1>");
			writer.println("<a href='psdchange.html'>重新修改</a>");
			writer.println("<a href='user.html'>返回</a>");
		}
	}

	
}
