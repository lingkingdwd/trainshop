package com.trainshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.trainshop.dao.IUsersDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.Users;

@Repository("usersDao")
public class UsersDao extends AbstractHibernateDao<Users> implements IUsersDao {

	public UsersDao() {
		super();

		setClazz(Users.class);
	}

	public List<Users> findOne(String userName, String password) {
		Session session = getCurrentSession();
		Criteria cri = session.createCriteria(Users.class);
		cri.add(Restrictions.eq("userName", userName));
		cri.add(Restrictions.eq("password", password));
		List<Users> list = cri.list();
		
		return list;
	}
	
	public List<Users> findOne(String userName) {
		Session session = getCurrentSession();
		Criteria cri = session.createCriteria(Users.class);
		cri.add(Restrictions.eq("userName", userName));
		List<Users> list = cri.list();
		
		return list;
	}
}