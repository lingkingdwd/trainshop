package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IAdminUserDao;
import com.trainshop.dao.IUsersDao;
import com.trainshop.model.AdminUser;
import com.trainshop.model.Users;
import com.trainshop.service.IAdminUserService;
import com.trainshop.service.IUsersService;
import com.trainshop.service.common.AbstractService;

@Service("adminUserService")
public class AdminUserService extends AbstractService<AdminUser> implements IAdminUserService {

    @Resource(name="adminUserDao")
    private IAdminUserDao adminUserDao;
    
    public AdminUserService() {
        super();
    }

    @Override
    protected IOperations<AdminUser> getDao() {
        return this.adminUserDao;
    }
    
    public List<AdminUser> findOne(String userName, String password){
    	return adminUserDao.findOne(userName, password);
    }
}