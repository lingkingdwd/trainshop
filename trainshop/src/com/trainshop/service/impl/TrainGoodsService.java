package com.trainshop.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.ITrainGoodsDao;
import com.trainshop.model.TrainGoods;
import com.trainshop.service.ITrainGoodsService;
import com.trainshop.service.common.AbstractService;

@Service("trainGoodsService")
public class TrainGoodsService extends AbstractService<TrainGoods> implements ITrainGoodsService {

    @Resource(name="trainGoodsDao")
    private ITrainGoodsDao trainGoodsDao;
    
    public TrainGoodsService() {
        super();
    }

    @Override
    protected IOperations<TrainGoods> getDao() {
        return this.trainGoodsDao;
    }
    
    public List<TrainGoods>  findTrainGoods()
    {
    	return trainGoodsDao.findAll();
    }
    

    public void  deleteTrainGoods(long id)
    {
    	trainGoodsDao.deleteById(id);
    }
}