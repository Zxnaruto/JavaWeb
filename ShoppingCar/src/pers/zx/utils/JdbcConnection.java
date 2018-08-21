package pers.zx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	  // 获取数据库连接
    public static Connection getConnection() {
        String url="jdbc:mysql://localhost:3306/h5_sql?allowMultiQueries=true&useUnicode=true&amp;characterEncoding=utf8";
        String user="root";
        String password ="19960213zx";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            connection =  DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connection;
    }

}
