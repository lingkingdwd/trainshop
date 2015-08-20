package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IUserRankDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.UserRank;

@Repository("userRankDao")
public class UserRankDao extends AbstractHibernateDao<UserRank> implements IUserRankDao {

	public UserRankDao() {
		super();

		setClazz(UserRank.class);
	}
}