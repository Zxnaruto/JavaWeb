package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import pers.zx.entity.Employee;

public class EmployeeDao {
    //��ѯ��Ա������м�¼
	//ʹ��static �򷽷����Բ���new ֱ������������
	
	//����Ŷ��󣬼��Ϸ�����
	public  List<Employee> findALL() throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Employee> emps=new ArrayList<Employee>();
		
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("select * from t_emp");
		rs=ps.executeQuery();//��ȡ�����
	
		while(rs.next()) {
			Employee emp=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_age"),rs.getDouble("emp_salary"));//��װ��emp������
			emps.add(emp);//��ӵ�������
			
			
		}
		DBUtil.close(conn);//�Ͽ�����
		return emps;
	}
	
	//���Ա����Ϣ
	
	
	
	
	
}
