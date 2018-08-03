package service;

import org.springframework.stereotype.Service;

import pojo.UserInfo;

@Service
public interface UserService {

	void addUser(UserInfo user);

	UserInfo login(UserInfo user);

}
