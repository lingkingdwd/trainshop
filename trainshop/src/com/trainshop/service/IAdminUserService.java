package com.trainshop.service;

import java.util.List;

import com.trainshop.dao.common.IOperations;
import com.trainshop.model.AdminUser;

public interface IAdminUserService extends IOperations<AdminUser> {

	List<AdminUser> findOne(String userName, String password);
}