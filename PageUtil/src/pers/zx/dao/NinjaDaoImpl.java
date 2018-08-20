package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.zx.entity.Ninja;
import pers.zx.utils.JdbcConnection;
import pers.zx.utils.NinjaBasicalImpl;
import pers.zx.utils.Page;

public class NinjaDaoImpl extends NinjaBasicalImpl implements NinjaDao{
	
	
	protected Connection connection;
    protected PreparedStatement pStatement;
    protected ResultSet rSet;
    
	/**
     * 获取总数
     */
    @Override
	public int getAmount() {
		// TODO Auto-generated method stub
		    connection = JdbcConnection.getConnection();
	        String sql = "SELECT COUNT(*) FROM Ninja";
	        int count = 0;
	        try {
	            pStatement = connection.prepareStatement(sql);
	            rSet = pStatement.executeQuery();
	            if(rSet.next()){
	                count = rSet.getInt(1);//获得总数
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            // 调用父类方法关闭资源
	            super.close();
	        }
	        return count;
	}
    /**
     * 获取当前页的数据
     * @param page 
     * @return 返回前页的数据
     */

	@Override
	public List<Ninja> getNinjaInfo(Page page) {
		// TODO Auto-generated method stub
		 connection = JdbcConnection.getConnection();
	        //基于MySQL的函数的分页
	        String sql = "SELECT NinjaId,NinjaName,NinjaAge,NinjaSex,NinjaLevel FROM ninja LIMIT ?,?";
	        // 创建集合
	        List<Ninja> list = new ArrayList<Ninja>();
	        try {
	            pStatement = connection.prepareStatement(sql);
	            //设置相关参数,在数据库中从start开始取size个
	            pStatement.setInt(1, page.getStart());
	            pStatement.setInt(2, page.getSize());
	            rSet = pStatement.executeQuery();
	            while(rSet.next()){
	               Ninja ninja = new Ninja();
	               ninja.setNinjaId(rSet.getInt("NinjaId"));
	               ninja.setNinjaName(rSet.getString("NinjaName"));
	               ninja.setNinjaAge(rSet.getInt("NinjaAge"));
	               ninja.setNinjaSex(rSet.getString("NinjaSex"));
	               ninja.setNinjaLevel(rSet.getString("NinjaLevel"));
	                list.add(ninja);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            // 调用父类方法关闭资源
	            super.close();
	        }
	        return list;
	    }

	}


