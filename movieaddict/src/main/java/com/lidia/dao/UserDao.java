package com.lidia.dao;

import java.util.List;

import com.lidia.User;
import com.lidia.entity.UserEntity;



public interface UserDao {

	void saveUser(User user);
	
	List<User> findAllUsers();
	
	void deleteUserByUsername(String username);
	
	User findByUsername(String username);
	
	void updateUser(User user);
	
	UserEntity getEntityById(int id);
}
