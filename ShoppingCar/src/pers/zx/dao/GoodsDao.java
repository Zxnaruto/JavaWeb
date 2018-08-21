package pers.zx.dao;

import java.util.List;

import pers.zx.bean.Goods;

public interface GoodsDao {

	public int add(Integer id,String name,float charge,Integer num);//添加
	public int del(Integer id);//删除
	public int change(Integer id,Integer num);//改变数量
	public List<Goods> show();//查询
    public boolean isExist(Integer id);//判断id是否存在
}
