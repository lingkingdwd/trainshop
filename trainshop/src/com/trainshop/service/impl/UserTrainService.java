package com.trainshop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IUserTrainDao;
import com.trainshop.model.UserTrain;
import com.trainshop.service.IUserTrainService;
import com.trainshop.service.common.AbstractService;

@Service("userTrainService")
public class UserTrainService extends AbstractService<UserTrain> implements IUserTrainService {

    @Resource(name="userTrainDao")
    private IUserTrainDao userTrainDao;
    
    public UserTrainService() {
        super();
    }

    @Override
    protected IOperations<UserTrain> getDao() {
        return this.userTrainDao;
    }
}