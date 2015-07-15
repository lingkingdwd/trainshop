package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.ITrainDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.Train;

@Repository("trainDao")
public class TrainDao extends AbstractHibernateDao<Train> implements ITrainDao {

	public TrainDao() {
		super();

		setClazz(Train.class);
	}
}