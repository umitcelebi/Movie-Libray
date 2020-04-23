package com.umitcelebi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.UserDao;
import com.umitcelebi.model.User;
import com.umitcelebi.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public boolean register(User user) {
		
		return userDao.register(user);
	}

	@Override
	public User login(String userName, String pasw) {
		
		return userDao.login(userName, pasw);
	}

	@Override
	public User searchByUsername(User user) {
		
		return userDao.searchByUsername(user);
	}
}
