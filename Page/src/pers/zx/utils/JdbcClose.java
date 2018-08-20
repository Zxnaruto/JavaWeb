package pers.zx.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcClose {
	protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;
    
    public void close(){
        // ¹Ø±Õ×ÊÔ´
        try {
            if (rs!=null) {
                rs.close();
            }
            if (ps!=null) {
                ps.close();
            }
            if (conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

