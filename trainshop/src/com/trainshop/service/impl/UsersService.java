package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IUsersDao;
import com.trainshop.model.Users;
import com.trainshop.service.IUsersService;
import com.trainshop.service.common.AbstractService;

@Service("usersService")
public class UsersService extends AbstractService<Users> implements IUsersService {

    @Resource(name="usersDao")
    private IUsersDao usersDao;
    
    public UsersService() {
        super();
    }

    @Override
    protected IOperations<Users> getDao() {
        return this.usersDao;
    }
    
    public List<Users> findOne(String userName, String password){
    	return usersDao.findOne(userName, password);
    }
    
    public List<Users> findOne(String userName){
    	return usersDao.findOne(userName);
    }
}