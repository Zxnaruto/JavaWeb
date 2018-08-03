package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.UserInfo;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
	@Override
	public void addUser(UserInfo user) {
		userMapper.addUser(user);
	}
	@Override
	public UserInfo login(UserInfo user) {
		return userMapper.login(user);
	}

}
