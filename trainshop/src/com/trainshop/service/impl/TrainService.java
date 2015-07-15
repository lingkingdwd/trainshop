package com.trainshop.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IOrgDao;
import com.trainshop.dao.ITrainDao;
import com.trainshop.model.Org;
import com.trainshop.model.Train;
import com.trainshop.service.IOrgService;
import com.trainshop.service.ITrainService;
import com.trainshop.service.common.AbstractService;

@Service("trainService")
public class TrainService extends AbstractService<Train> implements ITrainService {

    @Resource(name="trainDao")
    private ITrainDao trainDao;
    
    public TrainService() {
        super();
    }

    @Override
    protected IOperations<Train> getDao() {
        return this.trainDao;
    }
}