package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.ICategoryDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.Category;

@Repository("categoryDao")
public class CategoryDao extends AbstractHibernateDao<Category> implements ICategoryDao {

	public CategoryDao() {
		super();

		setClazz(Category.class);
	}
}