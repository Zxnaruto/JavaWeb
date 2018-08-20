package pers.zx.service;

import java.sql.Connection;
import java.sql.SQLException;

import pers.zx.dao.Dao;
import pers.zx.dao.DaoImp;
import pers.zx.util.Sqlconn;

public class PersonService {

	public boolean check(String name,String password) {
		Connection conn=null;
		boolean flag=false;
		try {
			conn=Sqlconn.openConnection();
			Dao dao=new DaoImp(conn);
			flag=dao.check(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sqlconn.closeConnection(conn);
		return flag;
	}
}
