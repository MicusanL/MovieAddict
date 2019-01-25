package com.lidia.manager;

import java.util.List;

import com.lidia.User;

public interface UserManager {

	void saveUser(User user);

	List<User> findAllUsers();

	void deleteUserByUsername(String username);

	User findByUsername(String username);

	void updateUser(User user);
	
}

