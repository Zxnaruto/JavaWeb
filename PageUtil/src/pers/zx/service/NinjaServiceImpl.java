package pers.zx.service;

import java.util.List;

import pers.zx.dao.NinjaDao;
import pers.zx.dao.NinjaDaoImpl;
import pers.zx.entity.Ninja;
import pers.zx.utils.Page;

public class NinjaServiceImpl implements NinjaService{
	private NinjaDao ninjaDao;
    // 通过代码块加载实现类
    {
        ninjaDao = new NinjaDaoImpl();
    }
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return ninjaDao.getAmount();

	}

	@Override
	public List<Ninja> getNinjaInfo(Page page) {
		// TODO Auto-generated method stub
		  return ninjaDao.getNinjaInfo(page);

	}

}
