package pers.zx.service;

import java.util.List;

import pers.zx.bean.Goods;

public interface GoodsService {
	public int add(Integer id,String name,float charge,Integer num);//添加
	public int del(Integer id);//删除
	public int change(Integer id,Integer num);//改变数量
	public List<Goods> show();
	public boolean isExist(Integer id);
}
