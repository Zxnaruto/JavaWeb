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
		
	    //��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ӡ��
		PrintWriter writer = response.getWriter();
	
		Connection  connection =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int id=0;
		String name=null;
		double salary=0;
		int age=0;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			 connection = DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");//   ///��ʾ��localhost
			//�����ݿ⴫��sql���
			 ps = connection.prepareStatement("select * from t_emp01");
		     //ִ��sql��ȡ�����
			 rs = ps.executeQuery();
			 //���
			 writer.println("<table border='1'>");
			 writer.println("Ա����Ϣ�б�");
			 writer.println("<tr><th>ID</th><th>����</th><th>нˮ</th><th>����</th></tr>");
			 while(rs.next()) {
				  id = rs.getInt("id");
				  name = rs.getString("name");
				  salary = rs.getDouble("salary");
				  age= rs.getInt("age");
				 
				 writer.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+salary+"</td><td>"+age+"</td></tr>");
			 }
			 writer.println("<a href='addEmp.html'>���Ա��</a>");
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
