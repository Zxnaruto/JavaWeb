package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//�������֤�� �û��޸�����
public class UserChangePassword {

	public int userChangePassword(String password,String idcard) {
		int temp=0;//�������ݲ�������
		Connection conn=null;
	    conn=SqlConnection.Sqlconn();
	    
		try {
			String SqlPasswordUpDate="UPDATE login1 SET L_Password='"+password+"' WHERE L_Id=(select P_Id from person1 where P_IdCard='"+idcard+"')";	 
			PreparedStatement ps=conn.prepareStatement(SqlPasswordUpDate);
			temp=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�����޸�ʧ�ܣ�����");
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
