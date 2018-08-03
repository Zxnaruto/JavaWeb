package pers.zx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.dao.SqlConnection;

public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//打印流
		PrintWriter writer = response.getWriter();
		
		Connection conn=null;
	    conn=SqlConnection.Sqlconn();
	    String name=null;
	    String password=null;
	    Integer id=0;
	    String Rname = request.getParameter("admin");
	    String Rpassword = request.getParameter("psd");
		try {
			String SqlSelect="select * from login1";	 
			PreparedStatement ps=conn.prepareStatement(SqlSelect);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				id=rs.getInt("L_Id");
				name=rs.getString("L_Name");
			    password=rs.getString("L_Password");
			 /* System.out.println("123"+Rname);
			  System.out.println("1234"+Rpassword);*/
			  System.out.println(id);
			  System.out.println(name);
			  System.out.println(password);
			  
			if(name.equals(Rname)&&password.equals(Rpassword)) {
				/* System.out.println("23"+Rname);
				  System.out.println("234"+Rpassword);*/
			    	 if(id==1) {
				        	response.sendRedirect("admin.html");
				        	break;
				        }
				        	
			    	 response.sendRedirect("user.html");
				        	break;
				        
			    	 
			    }else {
			    	writer.println("<h1>该用户不存在，请注册！！！</h1>");
			    	writer.println("<a href='insert.html'>注册</a>"+"   ");
			    	writer.print("<a href='Login.html'>返回</a>");
			    	//break;
			    	
			    }
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败！！！");
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		writer.close();
	}

}
