package com.trainshop.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IGoodsDao;
import com.trainshop.model.Goods;
import com.trainshop.service.IGoodsService;
import com.trainshop.service.common.AbstractService;

@Service("goodsService")
public class GoodsService extends AbstractService<Goods> implements IGoodsService {

    @Resource(name="goodsDao")
    private IGoodsDao goodsDao;
    
    public GoodsService() {
        super();
    }

    @Override
    protected IOperations<Goods> getDao() {
        return this.goodsDao;
    }
}