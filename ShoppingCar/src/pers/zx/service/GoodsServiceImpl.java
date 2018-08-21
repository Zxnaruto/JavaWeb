package pers.zx.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import pers.zx.bean.Goods;
import pers.zx.dao.GoodsDao;
import pers.zx.dao.GoodsDaoImpl;
import pers.zx.utils.JdbcClose;
import pers.zx.utils.JdbcConnection;

public class GoodsServiceImpl extends JdbcClose implements GoodsService{

	private Connection conn;
	private PreparedStatement ps;
	@Override
	public int add(Integer id,String name, float charge, Integer num) {
		// TODO Auto-generated method stub
		int flag=0;
		conn=JdbcConnection.getConnection();//�����ݿ�����
		
		GoodsDao goods=new GoodsDaoImpl(conn);
		flag=goods.add(id,name, charge, num);
		System.out.println("service");
		super.close();//�ر����ݿ�����
		return flag;
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		int flag=0;
		conn=JdbcConnection.getConnection();//�����ݿ�����
		GoodsDao goods=new GoodsDaoImpl(conn);
		flag=goods.del(id);
		super.close();//�ر����ݿ�����
		return flag;
	}

	@Override
	public int change(Integer id, Integer num) {
		// TODO Auto-generated method stub
		int flag=0;
		conn=JdbcConnection.getConnection();//�����ݿ�����
		GoodsDao goods=new GoodsDaoImpl(conn);
		flag=goods.change(id, num);
		super.close();//�ر����ݿ�����
		return flag;
	}

	@Override
	public List<Goods> show() {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<Goods>();
		conn=JdbcConnection.getConnection();//�����ݿ�����
		GoodsDao goods=new GoodsDaoImpl(conn);
		list=goods.show();
		super.close();//�ر����ݿ�����
		return list;
	}

	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		conn=JdbcConnection.getConnection();//�����ݿ�����
		GoodsDao goods=new GoodsDaoImpl(conn);
		flag=goods.isExist(id);
		super.close();//�ر����ݿ�����
		return flag;
	}


}
