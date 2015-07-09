package com.trainshop.dao;

import java.util.List;

import com.trainshop.dao.common.IOperations;
import com.trainshop.model.Users;

public interface IUsersDao extends IOperations<Users>{
	
	List<Users> findOne(String userName, String password);
}
