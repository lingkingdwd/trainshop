package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IUserRankDao;
import com.trainshop.model.UserRank;
import com.trainshop.service.IUserRankService;
import com.trainshop.service.common.AbstractService;

@Service("userRankService")
public class UserRankService extends AbstractService<UserRank> implements IUserRankService {

    @Resource(name="userRankDao")
    private IUserRankDao userRankDao;
    
    public UserRankService() {
        super();
    }

    @Override
    protected IOperations<UserRank> getDao() {
        return this.userRankDao;
    }
}