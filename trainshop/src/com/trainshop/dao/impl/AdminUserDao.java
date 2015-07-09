package com.trainshop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.trainshop.dao.IAdminUserDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.AdminUser;

@Repository("adminUserDao")
public class AdminUserDao extends AbstractHibernateDao<AdminUser> implements IAdminUserDao {

	public AdminUserDao() {
		super();

		setClazz(AdminUser.class);
	}

	public List<AdminUser> findOne(String userName, String password) {
		Session session = getCurrentSession();
		Criteria cri = session.createCriteria(AdminUser.class);
		cri.add(Restrictions.eq("userName", userName));
		cri.add(Restrictions.eq("password", password));
		List<AdminUser> list = cri.list();
		
		return list;
	}
}