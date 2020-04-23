package com.umitcelebi.dao;

import com.umitcelebi.model.User;

public interface UserDao {
	boolean register(User user);
	User login(String userName,String pasw);
	User searchByUsername(User user);
}
