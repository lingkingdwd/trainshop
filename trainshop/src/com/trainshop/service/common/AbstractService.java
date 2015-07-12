package com.trainshop.service.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.trainshop.common.IOperations;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    
    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);
    }

	@Override
	public void save(T entity) {
		getDao().save(entity);
	}

	@Override
	public void saveList(List<T> list) {
		getDao().saveList(list);
	}

	@Override
	public Integer updateByHql(String hql, Map<String, Object> parameters) {
		return getDao().updateByHql(hql, parameters);
	}

	@Override
	public Integer updateBySql(String sql, Object[] para) {
		return getDao().updateBySql(sql, para);
	}

	@Override
	public void updateList(List<T> list) {
		getDao().updateList(list);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getDao().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateList(List<T> list) {
		getDao().saveOrUpdateList(list);
	}

	@Override
	public T find(long id) {
		return getDao().find(id);
	}

	@Override
	public List<T> findObjects(Class<T> clazz) {
		return getDao().findObjects(clazz);
	}

	@Override
	public List findObjectsByPerptey(Class<T> clazz, String propertyName,
			Object value) {
		return getDao().findObjectsByPerptey(clazz, propertyName, value);
	}

	@Override
	public void delete(Class<T> clazz, long id) {
		getDao().delete(clazz, id);
	}

	@Override
	public void deleteList(List<T> list) {
		getDao().deleteList(list);
	}

	@Override
	public List<T> searchByHql(String hql, Map<String, Object> parameters) {
		return getDao().searchByHql(hql, parameters);
	}

	@Override
	public List<T> searchByHql(String hql, Map<String, Object> parameters,
			Integer start, Integer limit) {
		return getDao().searchByHql(hql, parameters, start, limit);
	}

	@Override
	public Integer getCountByHql(String hql, Map<String, Object> parameters) {
		return getDao().getCountByHql(hql, parameters);
	}

	@Override
	public List<T> searchBySql(String sql, Object[] para) {
		return getDao().searchBySql(sql, para);
	}

	@Override
	public List<T> searchBySql(String sql, Object[] para, Integer start,
			Integer limit) {
		return getDao().searchBySql(sql, para, start, limit);
	}

	@Override
	public Integer getCountBySql(String sql, Object[] para) {
		return getDao().getCountBySql(sql, para);
	}

	@Override
	public List<T> searchByDetachedCriteria(DetachedCriteria dc, Integer start,
			Integer limit) {
		return getDao().searchByDetachedCriteria(dc, start, limit);
	}

	@Override
	public List<T> searchByDetachedCriteria(DetachedCriteria dc) {
		return getDao().searchByDetachedCriteria(dc);
	}

	@Override
	public Integer getCountByDetachedCriteria(DetachedCriteria dc) {
		return getDao().getCountByDetachedCriteria(dc);
	}

}