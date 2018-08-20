package pers.zx.service;

import java.util.List;

import pers.zx.entity.Ninja;
import pers.zx.utils.Page;

public interface NinjaService {


    /**
     * 获取总数量
     * @return 返回总数
     */
    int getAmount();

    /**
     * 获取当前页的数据
     * @param page 
     * @return 返回前页的数据
     */
    List<Ninja> getNinjaInfo(Page page);

}
