package pers.zx.dao;

import java.util.List;

import pers.zx.bean.Ninja;

public interface NinjaDao {

	//根据每一页的条数 得到总页数
	public int pages(int rows);
	//根据所要查询的条数返回实体,从start开始查，查size条
	public List<Ninja> ninja(int start,int size);
}
