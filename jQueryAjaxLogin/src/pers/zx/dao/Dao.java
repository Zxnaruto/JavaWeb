package pers.zx.dao;

import pers.zx.bean.Person;

public interface Dao {

	public boolean check(String Lname,String password);
	public boolean delect(Integer id);
	public boolean add(Person per);
	public boolean update(Person per);

}
