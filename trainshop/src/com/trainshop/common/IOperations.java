package com.trainshop.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

/*
 * 通用的操作接口
 */
public interface IOperations<T extends Serializable> {

	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	// void delete(final T entity);

	void deleteById(final long entityId);

	/**
	 * 保存对象
	 * 
	 * @param obj
	 */
	public void save(final T entity);

	/**
	 * 批量保存一组对象
	 * 
	 * @param list
	 *            对象列表
	 */
	public void saveList(List<T> list);

	/**
	 * 
	 * HQL更新
	 * 
	 * @param hql
	 *            更新语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @return Integer
	 */
	public Integer updateByHql(final String hql,
			final Map<String, Object> parameters);

	/**
	 * sql更新
	 * 
	 * @param sql
	 * @param para
	 * @return
	 */
	public Integer updateBySql(final String sql, final Object para[]);

	/**
	 * 修改对象
	 * 
	 * @param obj
	 */
	public T update(final T entity);

	/**
	 * 批量修改一组对象
	 * 
	 * @param list
	 *            对象列表
	 */
	public void updateList(final List<T> list);

	/**
	 * 保存或修改对象
	 * 
	 * @param obj
	 */
	public void saveOrUpdate(final T entity);

	/**
	 * 批量保存或修改一组对象
	 * 
	 * @param list
	 *            对象列表
	 */
	public void saveOrUpdateList(final List<T> list);

	/**
	 * 根据ID得到对象
	 * 
	 * @param clazz
	 *            实体类
	 */
	public T find(final long id);

	/**
	 * 由实体类名获取一组对象
	 * 
	 * @param clazz
	 *            实体类
	 */
	public List<T> findObjects(Class<T> clazz);

	/**
	 * 根据对象属性得到一组对象
	 * 
	 * @param clazz
	 *            实体类
	 * @param propertyName
	 *            数据列名
	 * @param value
	 *            数据列值
	 * @return
	 */
	public List<T> findObjectsByPerptey(final Class<T> clazz,
			String propertyName, Object value);

	/**
	 * 根据ID删除对象
	 * 
	 * @param clazz实体类
	 */
	public void delete(Class<T> clazz, long id);

	/**
	 * 删除对象
	 * 
	 * @param obj
	 */
	public void delete(final T entity);

	/**
	 * 批量删除一组对象
	 * 
	 * @param list
	 *            对象列表
	 */
	public void deleteList(final List<T> list);

	/**
	 * 
	 * HQL查询
	 * 
	 * @param hql
	 *            查询语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @return List
	 * @throws Exception
	 */
	public List<T> searchByHql(String hql, Map<String, Object> parameters);

	/**
	 * 
	 * HQL分页查询
	 * 
	 * @param hql
	 *            查询语句
	 * @param parameters
	 *            HashMap类型的查询条件集合<参数名称, 值>
	 * @param start
	 * @param limit
	 * @return List
	 * @throws Exception
	 */
	public List<T> searchByHql(String hql, Map<String, Object> parameters,
			Integer start, Integer limit);

	/**
	 * 根据hql获取总记录数
	 * 
	 * @param dc
	 * @return
	 */
	public Integer getCountByHql(String hql, Map<String, Object> parameters);

	/**
	 * sql查询
	 * 
	 * @param sql
	 * @param para
	 * @return
	 */
	public List<T> searchBySql(String sql, Object para[]);

	/**
	 * sql分页查询
	 * 
	 * @param sql
	 * @param para
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<T> searchBySql(String sql, Object para[], Integer start,
			Integer limit);

	/**
	 * 根据sql获取总记录数
	 * 
	 * @param dc
	 * @return
	 */
	public Integer getCountBySql(String sql, Object para[]);

	/**
	 * DetachedCriteria分页查询
	 * 
	 * @param dc
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<T> searchByDetachedCriteria(DetachedCriteria dc, Integer start,
			Integer limit);

	/**
	 * DetachedCriteria查询
	 * 
	 * @param dc
	 * @return
	 */
	public List<T> searchByDetachedCriteria(DetachedCriteria dc);

	/**
	 * 根据DetachedCriteria获取总记录数
	 * 
	 * @param dc
	 * @return
	 */
	public Integer getCountByDetachedCriteria(DetachedCriteria dc);
}