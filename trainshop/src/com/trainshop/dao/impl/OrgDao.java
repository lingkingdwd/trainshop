package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IOrgDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.Org;

@Repository("orgDao")
public class OrgDao extends AbstractHibernateDao<Org> implements IOrgDao {

	public OrgDao() {
		super();

		setClazz(Org.class);
	}
}