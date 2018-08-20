package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.zx.bean.Ninja;
import pers.zx.utils.JdbcClose;
import pers.zx.utils.JdbcConnection;

public class NinjaDaoImpl extends JdbcClose implements NinjaDao {

	protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;
	@Override
	public int pages(int rows) {
		// TODO Auto-generated method stub
	  int num=0;
	  int page=0;//页数
	  conn=JdbcConnection.getConnection();
	  String sql="select COUNT(*) from ninja";
	  try {
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()) {
			num=rs.getInt(1);//获取总数
		}
		 if(num%rows==0) {
			  page=num/rows;
		  }else {
			  page=num/rows+1;
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		super.close();//关闭资源
	}
	  
		return page;
	}

	@Override
	public List<Ninja> ninja(int start, int size) {
		// TODO Auto-generated method stub
		List<Ninja> list=new ArrayList<Ninja>();//创建集合
		 conn=JdbcConnection.getConnection();
		  String sql = "SELECT NinjaId,NinjaName,NinjaAge,NinjaSex,NinjaLevel FROM ninja LIMIT ?,?";//limit限制从start开始取size
		  try {
			ps=conn.prepareStatement(sql);
			//设置相关参数,在数据库中从start开始取size个
            ps.setInt(1, start);
            ps.setInt(2,size);
            rs = ps.executeQuery();
            while(rs.next()){
               Ninja ninja = new Ninja();
               ninja.setNinjaId(rs.getInt("NinjaId"));
               ninja.setNinjaName(rs.getString("NinjaName"));
               ninja.setNinjaAge(rs.getInt("NinjaAge"));
               ninja.setNinjaSex(rs.getString("NinjaSex"));
               ninja.setNinjaLevel(rs.getString("NinjaLevel"));
               list.add(ninja);
            }
            

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.close();
		}
		return list;
	}

}
