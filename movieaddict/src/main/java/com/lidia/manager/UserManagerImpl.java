package com.lidia.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lidia.User;
import com.lidia.dao.UserDao;



@Service("userManager")
@Transactional
public class UserManagerImpl implements UserManager {
//return userTO
	//in dao translate (persisaatace)
	@Autowired
	private UserDao dao;
	
	
	public void saveUser(User user){
		dao.saveUser(user);
	}

	public List<User> findAllUsers(){
		return dao.findAllUsers();
	}

	public void deleteUserByUsername(String username){
		dao.deleteUserByUsername(username);
	}

	public User findByUsername(String username){
		return dao.findByUsername(username);
	}

	public void updateUser(User user){
		dao.updateUser(user);
	}
	
}


