package pers.zx.dao;

import java.util.List;

import pers.zx.bean.Goods;

public interface GoodsDao {

	public int add(Integer id,String name,float charge,Integer num);//���
	public int del(Integer id);//ɾ��
	public int change(Integer id,Integer num);//�ı�����
	public List<Goods> show();//��ѯ
    public boolean isExist(Integer id);//�ж�id�Ƿ����
}
