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
	//删除员工
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DBUtil.getConnection();
		//ps=conn.prepareStatement("delete from t_emp where id=?");
		ps=conn.prepareStatement("delete from t_emp where emp_id='"+id+"'");
		//ps.setInt(1, id);//设置删除的id
		ps.executeUpdate();
		DBUtil.close(conn);
	}
	//添加员工信息
	public void add(Employee emp) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("insert into t_emp(emp_name,emp_age,emp_salary) values(?,?,?)");
		
		ps.setString(1, emp.getEmp_name());
		ps.setInt(2, emp.getEmp_age());
		ps.setDouble(3, emp.getEmp_salary());
		
		ps.executeUpdate();
		DBUtil.close(conn);
	}
	//查询
    public Employee find(Integer id) throws ClassNotFoundException, SQLException {
    	Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee emp=null;
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("select * from t_emp where emp_id=?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()) {
		 emp=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_age"),rs.getDouble("emp_salary"));//把查询到的值放到emp对象
		}
		DBUtil.close(conn);
		
		return emp;
    }
    //修改
    public void modify(Employee emp) throws ClassNotFoundException, SQLException {
    	Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("update t_emp set emp_id=?,emp_name=?,emp_age=?,emp_salary=? where emp_id=?");
	    ps.setInt(1, emp.getEmp_id());
	    ps.setString(2, emp.getEmp_name());
	    ps.setInt(3, emp.getEmp_age());
	    ps.setDouble(4, emp.getEmp_salary());
	    
	    ps.executeUpdate();
		DBUtil.close(conn);
		
    }
	
	
	
}
