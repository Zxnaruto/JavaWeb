package pers.zx.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NinjaBasicalImpl {
	protected Connection connection;
    protected PreparedStatement pStatement;
    protected ResultSet rSet;
    
    public void close(){
        // �ر���Դ
        try {
            if (rSet!=null) {
                rSet.close();
            }
            if (pStatement!=null) {
                pStatement.close();
            }
            if (connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
