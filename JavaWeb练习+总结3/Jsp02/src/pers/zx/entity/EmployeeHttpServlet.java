package pers.zx.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.dao.DBUtil;

public class EmployeeHttpServlet extends HttpServlet {
	 
	 private Employee list;
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<Employee> emps=new ArrayList<Employee>();
			 Employee emp1=null;
			//ArrayList<Employee> emps=new ArrayList<Employee>();
			try {
				conn=DBUtil.getConnection();
				ps=conn.prepareStatement("select * from t_emp");
				rs=ps.executeQuery();
				while(rs.next()) {
				/*	Employee emp1=new Employee();//封装到emp对象中
					emp1.setEmp_id(rs.getInt("emp_id"));
					emp1.setEmp_name(rs.getString("emp_name"));
					emp1.setEmp_age(rs.getInt("emp_age"));
					emp1.setEmp_salary(rs.getDouble("emp_salary"));
					list.add(emp1);//添加到集合中	
*/					Employee emp=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_age"),rs.getDouble("emp_salary"));//封装到emp对象中
                    emps.add(emp);//添加到集合中
				}
				for(int i=0;i<emps.size();i++){
					 emp1= emps.get(i);
					 }
			
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}
			
			try {
				DBUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//断开链接
		
			//request.setAttribute("emp1",emp1);
			list=emp1;
			response.sendRedirect("list1.jsp");
		}
	public Employee getList() {
		return list;
	}
	public void setList(Employee list) {
		this.list = list;
	}
	
}
