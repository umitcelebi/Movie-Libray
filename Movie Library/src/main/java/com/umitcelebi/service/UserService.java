package com.umitcelebi.service;

import com.umitcelebi.model.User;

public interface UserService {
	boolean register(User user);
	User login(String userName,String pasw);
	User searchByUsername(User user);
}
