package com.trainshop.service;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.Users;

public interface IUsersService extends IOperations<Users> {

	List<Users> findOne(String userName, String password);
	
	List<Users> findOne(String userName);
}