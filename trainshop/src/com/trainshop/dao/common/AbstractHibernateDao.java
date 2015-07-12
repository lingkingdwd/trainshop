package com.trainshop.dao.common;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.google.common.base.Preconditions;
import com.trainshop.common.IOperations;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz;
    
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
    
    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    private HibernateTemplate hibernateTemplate;
	
	private final int defaultLimit = 15;
	
	private HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    @Override
    public final T findOne(final long id) {
        return (T)getCurrentSession().get(clazz, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
         Preconditions.checkNotNull(entity);
         // getCurrentSession().persist(entity);
         getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().update(entity);
        return entity;
        //return (T)getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
         Preconditions.checkNotNull(entity);
         getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
    
    /**
	 * 保存对象
	 * @param obj
	 */
	public void save(Object obj){
		getHibernateTemplate().save(obj);
	}
	
	/**
     * 批量保存一组对象
     * @param list 对象列表
     */
	public void saveList(final List<T> list){
    	getHibernateTemplate().executeWithNativeSession(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException {
				for (Iterator<T> it = list.iterator(); it.hasNext();) {
					session.save(it.next());
				}
				return null;
			}
		});
    }
    
    /**
	 * 
	 * TODO HQL更新
	 * 
	 * @param hql
	 *            更新语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @return Integer
	 */
	@Override
	public Integer updateByHql(final String hql, final Map<String, Object> parameters){
		HibernateTemplate ht = getHibernateTemplate();
		return (Integer) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (parameters != null) {
					Iterator iter = parameters.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						String key = (String) entry.getKey();
						Object val = entry.getValue();
						query.setParameter(key, val);
					}
				}
				return query.executeUpdate();
			}
		});
	}
	
	/**
	 * sql更新
	 * @param sql
	 * @param para
	 * @return
	 */
	@Override
	public Integer updateBySql(final String sql, final Object para[]) {
		Integer result = (Integer) hibernateTemplate
				.execute(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query q = session.createSQLQuery(sql);
						if (para != null) {
							for (int i = 0; i < para.length; i++) {
								q.setParameter(i, para[i]);
							}
						}
						return q.executeUpdate();
					}
				});
		return result;
	}
    
	/**
     * 批量修改一组对象
     * @param list 对象列表
     */
	public void updateList(final List<T> list){
    	getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				for (Iterator<T> it = list.iterator(); it.hasNext();) {
					session.update(it.next());
				}
				return null;
			}
		});
    }
	
	/**
	 * 保存或修改对象
	 * @param obj
	 */
	@Override
	public void saveOrUpdate(T obj)
	{
		getHibernateTemplate().saveOrUpdate(obj);
	}
	
	/**
     * 批量保存或修改一组对象
     * @param list 对象列表
     */
    @Override
	public void saveOrUpdateList(final List<T> list)
    {
    	//log.debug("update with list!");
		try
		{
			for(T t : list){
				getHibernateTemplate().saveOrUpdate(t);
			}
		} catch (RuntimeException re)
		{
			//log.error("update failed!", re);
			throw re;
		}
    }

    /**
	 * 根据ID得到对象
	 * 
	 * @param clazz
	 *            实体类
	 */
	@Override
	public T find(final long id)
	{
    	 return (T)getCurrentSession().get(clazz, id);
	}

    /**
	 * 由实体类名获取一组对象
	 * 
	 * @param clazz
	 * 			  实体类
	 */
	@Override
	public List<T> findObjects(Class<T> clazz)
	{
		return getHibernateTemplate().loadAll(clazz);
	}
	
    /**
	 * TODO 根据对象属性得到一组对象
	 * @param clazz 实体类
	 * @param propertyName 数据列名
	 * @param value 数据列值
	 * @return 
	 */
	@Override
	public List findObjectsByPerptey(final Class<T> clazz, String propertyName, Object value)
	{
		try
		{
			String queryString = "from " + clazz.getName()
					+ " as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			throw re;
		}
	}

    /**
	 * 根据ID删除对象
	 * 
	 * @param clazz实体类
	 */
	@Override
	public void delete(Class<T> clazz, long id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(clazz, id));
	}
	
	/**
     * 批量删除一组对象
     * @param list 对象列表
     */
    @Override
	public void deleteList(List<T> list)
    {
    	//log.debug("delete with a list.");
		try
		{
			getHibernateTemplate().deleteAll(list);
		} catch (RuntimeException re)
		{
			//log.error("delete failed!", re);
			throw re;
		}
    }
	
	/**
	 * 
	 * TODO HQL查询
	 * 
	 * @param hql
	 *            查询语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @return List
	 * @throws Exception
	 */
	@Override
	public List<T> searchByHql(final String hql, final Map<String, Object> parameters) {
		HibernateTemplate ht = getHibernateTemplate();
		return (List<T>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (parameters != null) {
					Iterator iter = parameters.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						String key = (String) entry.getKey();
						Object val = entry.getValue();
						query.setParameter(key, val);
					}
				}
				return query.list();
			}
		});
	}
	
	/**
	 * 
	 * TODO HQL分页查询
	 * 
	 * @param hql
	 *            查询语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @return List
	 * @throws Exception
	 */
	@Override
	public List searchByHql(final String hql,
			final Map<String, Object> parameters, final Integer start,
			final Integer limit) {
		HibernateTemplate ht = getHibernateTemplate();
		return (List) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (parameters != null) {
					Iterator iter = parameters.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						String key = (String) entry.getKey();
						Object val = entry.getValue();
						query.setParameter(key, val);
					}
				}
				setFirstResultAndMaxResults(query, start, limit);
				return query.list();
			}
		});
	}
	
	/**
	 * 根据hql获取总记录数
	 * @param dc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer getCountByHql(final String hql, final Map<String, Object> parameters){
		String str = hql;
		int index = str.toLowerCase().indexOf("order by");
		if (index != -1)
			str = hql.substring(0, index);
		String countHql = "select count(*) "
				+ str.substring(str.toLowerCase().indexOf("from"), str.length());
		List allNumList = searchByHql(countHql, parameters);
		Integer allNum = Integer.parseInt(allNumList.get(0).toString());
		return allNum;
	}
	
	/**
	 * sql查询
	 * @param sql
	 * @param para
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List searchBySql(final String sql, final Object para[]) {
		List resultList = (List) getHibernateTemplate()
				.execute(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query q = session.createSQLQuery(sql);
						if (para != null) {
							for (int i = 0; i < para.length; i++) {
								q.setParameter(i, para[i]);
							}
						}
						return q.list();
					}
				});
		return resultList;
	}

	/**
	 * sql分页查询
	 * @param sql
	 * @param para
	 * @param start
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List searchBySql(final String sql, final Object para[], final Integer start, final Integer limit) {
		List resultList = (List) getHibernateTemplate()
				.execute(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query q = session.createSQLQuery(sql);
						setFirstResultAndMaxResults(q, start, limit);
						if (para != null) {
							for (int i = 0; i < para.length; i++) {
								q.setParameter(i, para[i]);
							}
						}
						return q.list();
					}
				});
		return resultList;
	}
	
	/**
	 * 根据sql获取总记录数
	 * @param dc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer getCountBySql(final String sql, final Object para[]){
		String str = sql;
		int index = str.toLowerCase().indexOf("order by");
		if (index != -1)
			str = sql.substring(0, index);
		String countHql = "select count(*) "
				+ str.substring(str.toLowerCase().indexOf("from"), str.length());
		List allNumList = searchBySql(countHql, para);
		Integer allNum = Integer.parseInt(allNumList.get(0).toString());
		return allNum;
	}
	
	/**
	 * DetachedCriteria分页查询
	 * @param dc
	 * @return
	 */
	@Override
	public List<T> searchByDetachedCriteria(final DetachedCriteria dc, final Integer start, final Integer limit) {
		List<T> allList = (List<T>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = dc.getExecutableCriteria(session);
						setFirstResultAndMaxResults(criteria, start, limit);
						List<T> list = criteria.list();
						criteria.setFirstResult(0);
						return list;
					}
				});
		return allList;

	}
	
	/**
	 * DetachedCriteria查询
	 * @param dc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List searchByDetachedCriteria(final DetachedCriteria dc) {
		List allList = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = dc.getExecutableCriteria(session);
						List list = criteria.list();
						return list;
					}
				});
		return allList;

	}
	
	/**
	 * 根据DetachedCriteria获取总记录数
	 * @param dc
	 * @return
	 */
	@Override
	public Integer getCountByDetachedCriteria(final DetachedCriteria dc){
		Integer count = (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = dc.getExecutableCriteria(session);
						criteria.setProjection(Projections.rowCount());
						Integer count = (Integer) criteria.uniqueResult();
						criteria.setProjection(null);
						return count;
					}
				});
		return count;
	}
	
	private void setFirstResultAndMaxResults(Query query, Integer start, Integer limit){
		if(start == null || start < 0){
			start = 0;
		}
		if(limit == null){
			limit = defaultLimit;
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);
	}
	
	private void setFirstResultAndMaxResults(Criteria criteria, Integer start, Integer limit){
		if(start == null || start < 0){
			start = 0;
		}
		if(limit == null){
			limit = defaultLimit;
		}
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
	}
	
	 @Override
    public final void save(final T entity) {
         Preconditions.checkNotNull(entity);
         // getCurrentSession().persist(entity);
         getCurrentSession().saveOrUpdate(entity);
    }
}
