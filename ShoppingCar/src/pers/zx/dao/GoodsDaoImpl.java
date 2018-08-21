package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.zx.bean.Goods;
import pers.zx.utils.JdbcClose;
import pers.zx.utils.JdbcConnection;

public class GoodsDaoImpl implements GoodsDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public GoodsDaoImpl(Connection conn) {
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int add(Integer id,String name,float charge,Integer num) {
		// TODO Auto-generated method stub
		int flag=0;
		System.out.println("dao1231");
		String sql="INSERT INTO goods(g_id,g_name,g_charge,g_num) values(?,?,?,?)";
		try {
			//conn=JdbcConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setFloat(3, charge);
			ps.setInt(4,num);
			System.out.println("dao");
			flag=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}
	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		int flag=0;
		String sql="delete from goods where g_id='"+id+"'";
		try {
			ps=conn.prepareStatement(sql);
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public int change(Integer id,Integer num) {
		// TODO Auto-generated method stub
		int flag=0;
		String sql="update goods set g_num='"+num+"' where g_id='"+id+"'";
		try {
			ps=conn.prepareStatement(sql);
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public List<Goods> show() {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<Goods>();
		String sql="select * from goods";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setG_id(rs.getInt("g_id"));
				goods.setG_name(rs.getString("g_name"));
				goods.setG_charge(rs.getFloat("g_charge"));
				goods.setG_num(rs.getInt("g_num"));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return list;
	}
	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		String sql="select * from goods where g_id='"+id+"'";
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				
					flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	
	


}
