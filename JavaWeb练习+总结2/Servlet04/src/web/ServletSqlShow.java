package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletSqlShow extends HttpServlet {

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    //防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//打印流
		PrintWriter writer = response.getWriter();
	
		Connection  connection =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int id=0;
		String name=null;
		double salary=0;
		int age=0;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接
			 connection = DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");//   ///表示了localhost
			//向数据库传递sql语句
			 ps = connection.prepareStatement("select * from t_emp01");
		     //执行sql获取结果集
			 rs = ps.executeQuery();
			 //输出
			 writer.println("<table border='1'>");
			 writer.println("员工信息列表");
			 writer.println("<tr><th>ID</th><th>姓名</th><th>薪水</th><th>年龄</th></tr>");
			 while(rs.next()) {
				  id = rs.getInt("id");
				  name = rs.getString("name");
				  salary = rs.getDouble("salary");
				  age= rs.getInt("age");
				 
				 writer.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+salary+"</td><td>"+age+"</td></tr>");
			 }
			 writer.println("<a href='addEmp.html'>添加员工</a>");
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
