package pers.zx.dao;

import java.util.List;

import pers.zx.bean.Ninja;

public interface NinjaDao {

	//����ÿһҳ������ �õ���ҳ��
	public int pages(int rows);
	//������Ҫ��ѯ����������ʵ��,��start��ʼ�飬��size��
	public List<Ninja> ninja(int start,int size);
}
