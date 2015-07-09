package com.trainshop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.dao.IUserAccountDao;
import com.trainshop.dao.common.IOperations;
import com.trainshop.model.UserAccount;
import com.trainshop.service.IUserAccountService;
import com.trainshop.service.common.AbstractService;

@Service("userAccountService")
public class UserAccountService extends AbstractService<UserAccount> implements IUserAccountService {

    @Resource(name="userAccountDao")
    private IUserAccountDao userAccountDao;
    
    public UserAccountService() {
        super();
    }

    @Override
    protected IOperations<UserAccount> getDao() {
        return this.userAccountDao;
    }
}