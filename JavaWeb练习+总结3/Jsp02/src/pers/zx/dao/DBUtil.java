package pers.zx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

//�������ݿ�
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection connection =DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");
	    return connection;
	}
	//�ر�����
	public static void close(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	/*//����
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DBUtil.getConnection());
	}*/
}
