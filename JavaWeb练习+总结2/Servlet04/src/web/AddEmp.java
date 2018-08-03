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
 * ͨ��Servletʵ�����ݿ������Ϣ
 */
@SuppressWarnings("serial")
public class AddEmp extends HttpServlet {

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
	/*  String salary = request.getParameter("salary");
		String age = request.getParameter("age");*/
		//��װ��ת��
		Double salary = Double.valueOf(request.getParameter("salary"));
		Integer age = Integer.valueOf(request.getParameter("age"));
		//д��
		/*writer.println("<h1>"+name+"</h1>");
		writer.println("<h1>"+salary+"</h1>");
		writer.println("<h1>"+age+"</h1>");*/
		
		/*
		���ݿ�
		try {
			String URL="jdbc:mysql://localhost:3306/day05?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");//��������
			Connection conn=DriverManager.getConnection(URL, "root", "19960213zx");//��������
			String sql="insert into t_emp(emp_name,emp_age,emp_salary) values(?,?,?)";
			java.sql.PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,age);
			ps.setDouble(3, salary);
            int count=ps.executeUpdate();
		    if(count==1) {
		    	System.out.println("����ɹ�������");
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
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			 connection = DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");//   ///��ʾ��localhost
			//�����ݿ⴫��sql���
			 ps = connection.prepareStatement("insert into t_emp01(name,salary,age) values(?,?,?)");
			//����ֵ 
			 ps.setString(1, name);
			 ps.setDouble(2, salary);
			 ps.setInt(3, age);
			 //ִ��sql���
			 int count=ps.executeUpdate();
			 if(count==1) {
				 writer.println("<h1>��ӳɹ�</h1>");
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
