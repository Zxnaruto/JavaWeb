package pers.zx.service;

import java.util.List;

import pers.zx.bean.Goods;

public interface GoodsService {
	public int add(Integer id,String name,float charge,Integer num);//���
	public int del(Integer id);//ɾ��
	public int change(Integer id,Integer num);//�ı�����
	public List<Goods> show();
	public boolean isExist(Integer id);
}
