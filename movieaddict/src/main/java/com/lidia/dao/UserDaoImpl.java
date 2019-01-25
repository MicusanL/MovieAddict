package com.lidia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lidia.User;
import com.lidia.entity.UserEntity;


@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void saveUser(User user) {
		
		UserEntity userEntity = new UserEntity();
		userEntity = getEntityById(user.getUser_id());
		persist(userEntity);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		return (List<User>) criteria.list();
	}

	public void deleteUserByUsername(String username) {
		Query query = getSession().createSQLQuery(
				"delete from user where username = :username");
		query.setString("username", username);
		query.executeUpdate();
	}

	public User findByUsername(String username) {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}
	
//get entity by id (cu userTO) => entity
	public void updateUser(User user) {
		
		UserEntity userEntity = new UserEntity();
		userEntity = getEntityById(user.getUser_id());
		getSession().update(userEntity);
	}
	
	public UserEntity getEntityById(int id) {
		
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("user_id", id));
		return (UserEntity) criteria.uniqueResult();
	}
	
	

}