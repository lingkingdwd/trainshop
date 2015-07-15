package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IUserTrainDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.UserTrain;

@Repository("userTrainDao")
public class UserTrainDao extends AbstractHibernateDao<UserTrain> implements IUserTrainDao {

	public UserTrainDao() {
		super();

		setClazz(UserTrain.class);
	}
}