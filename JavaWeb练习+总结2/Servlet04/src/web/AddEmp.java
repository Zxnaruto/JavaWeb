package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author zx
 * 通过Servlet实现数据库添加信息
 */
@SuppressWarnings("serial")
public class AddEmp extends HttpServlet {

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
	/*  String salary = request.getParameter("salary");
		String age = request.getParameter("age");*/
		//包装类转换
		Double salary = Double.valueOf(request.getParameter("salary"));
		Integer age = Integer.valueOf(request.getParameter("age"));
		//写出
		/*writer.println("<h1>"+name+"</h1>");
		writer.println("<h1>"+salary+"</h1>");
		writer.println("<h1>"+age+"</h1>");*/
		
		/*
		数据库
		try {
			String URL="jdbc:mysql://localhost:3306/day05?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			Connection conn=DriverManager.getConnection(URL, "root", "19960213zx");//建立连接
			String sql="insert into t_emp(emp_name,emp_age,emp_salary) values(?,?,?)";
			java.sql.PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,age);
			ps.setDouble(3, salary);
            int count=ps.executeUpdate();
		    if(count==1) {
		    	System.out.println("插入成功！！！");
		    }
		    conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			writer.close();
		}
		*/
		Connection  connection =null;
		PreparedStatement ps=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接
			 connection = DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");//   ///表示了localhost
			//向数据库传递sql语句
			 ps = connection.prepareStatement("insert into t_emp01(name,salary,age) values(?,?,?)");
			//放入值 
			 ps.setString(1, name);
			 ps.setDouble(2, salary);
			 ps.setInt(3, age);
			 //执行sql语句
			 int count=ps.executeUpdate();
			 if(count==1) {
				 writer.println("<h1>添加成功</h1>");
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		writer.close();
	}

}
