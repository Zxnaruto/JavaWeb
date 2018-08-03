package mapper;

import pojo.UserInfo;

public interface UserMapper {

	void addUser(UserInfo user);

	UserInfo login(UserInfo user);

}
