package pers.zx.dao;

import java.util.List;

import pers.zx.entity.Ninja;
import pers.zx.utils.Page;

public interface NinjaDao {

	 /**
     * ��ȡ������
     * @return ��������
     */
    int getAmount();

    /**
     * ��ȡ��ǰҳ������
     * @param page 
     * @return ����ǰҳ������
     */
    List<Ninja> getNinjaInfo(Page page);


}
