package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import pers.zx.entity.Employee;

public class EmployeeDao {
    //查询雇员表的所有记录
	//使用static 则方法可以不用new 直接用类名调用
	
	//数组放对象，集合放引用
	public  List<Employee> findALL() throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Employee> emps=new ArrayList<Employee>();
		
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("select * from t_emp");
		rs=ps.executeQuery();//获取结果集
	
		while(rs.next()) {
			Employee emp=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_age"),rs.getDouble("emp_salary"));//封装到emp对象中
			emps.add(emp);//添加到集合中
			
			
		}
		DBUtil.close(conn);//断开链接
		return emps;
	}
	
	//添加员工信息
	
	
	
	
	
}
