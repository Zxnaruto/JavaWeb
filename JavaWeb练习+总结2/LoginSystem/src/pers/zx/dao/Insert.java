package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
	public int[] Ins(String name,String sex,Integer age,String idcard,String tel,String password,String loginname){
		
		int[] temp=new int[2];//�������ݲ�������
		Connection conn=null;
	    conn=SqlConnection.Sqlconn();
	    
		try {
			String SqlInsert="INSERT INTO person1(P_Name,P_Sex,P_Age,P_IdCard,P_Tel,P_Status) VALUES(?,?,?,?,?,?)";
			String SqlInsert1="INSERT INTO login1(L_Name,L_Password) VALUES(?,?)";
			PreparedStatement ps1=conn.prepareStatement(SqlInsert1);
			PreparedStatement ps=conn.prepareStatement(SqlInsert);
			
			//ResultSet rs=ps.executeQuery("select * from Ninja");
			//rs.last();//������Ƶ����һ��
			ps1.setString(1, loginname);
			ps1.setString(2, password);
			
			ps.setString(1, name);//��������values���ʺŵ�ֵ����ֵ����Ϊ��ײ�
			ps.setString(2, sex);
			ps.setInt(3, age);
			ps.setString(4,idcard);
			ps.setString(5, tel);
			ps.setString(6,"0");
			
			
			temp[0]=ps1.executeUpdate();
			temp[1]=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ�ܣ�����");
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
		return temp;
		}
}
