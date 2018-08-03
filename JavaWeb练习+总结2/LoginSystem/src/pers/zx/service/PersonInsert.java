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
		//防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//打印流
		PrintWriter writer = response.getWriter();
		//获取值
		String name = request.getParameter("name");
		 String sex = request.getParameter("sex");
		 Integer age = Integer.valueOf(request.getParameter("age"));
		 String idcard=request.getParameter("idcard");
		 String tel=request.getParameter("tel");
		 String loginname=request.getParameter("loginname");
		 String password=request.getParameter("psd");
		 String password1=request.getParameter("psd_c");
	    //调用插入函数
		 Insert insert=new Insert();
		 int[] count=new int[2];
		 if(password.equals(password1)) {
		 count=insert.Ins(name, sex, age, idcard, tel,password,loginname);
		 if(count[0]==1&&count[1]==1) {
			 writer.println("<h1>添加成功</h1>");
		 }
		 }else {
			 writer.println("<h1>添加失败</h1>");
			 writer.println("<a href='Login.html'>返回</a>");
		 }
		
		 writer.println("<a href='Login.html'>返回</a>");
		/* response.sendRedirect("Login.html");*/ //重定向
		 
		 writer.close();
	}

}
