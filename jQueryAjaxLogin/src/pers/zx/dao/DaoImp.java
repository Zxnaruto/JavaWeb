package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import pers.zx.bean.Person;

public class DaoImp implements Dao{

	protected PreparedStatement ps;
	protected Connection conn;
	protected ResultSet rs;
	
	public DaoImp(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn=conn;
	}

	
	@Override
	public boolean check(String Lname, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int temp=0;
        String sql="select * from person where Lname='"+Lname+"'and password='"+password+"'";
         try {
        	 System.out.print("daoimp");
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

	@Override
	public boolean delect(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Person per) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person per) {
		// TODO Auto-generated method stub
		return false;
	}

}
