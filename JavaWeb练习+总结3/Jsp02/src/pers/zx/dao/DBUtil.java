package pers.zx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

//链接数据库
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection connection =DriverManager.getConnection("jdbc:mysql:///day05", "root","19960213zx");
	    return connection;
	}
	//关闭链接
	public static void close(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	/*//测试
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DBUtil.getConnection());
	}*/
}
