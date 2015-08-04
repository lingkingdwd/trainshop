package com.trainshop.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IGoodsActivityDao;
import com.trainshop.dao.IGoodsDao;
import com.trainshop.model.Goods;
import com.trainshop.model.GoodsActivity;
import com.trainshop.service.IGoodsActivityService;
import com.trainshop.service.IGoodsService;
import com.trainshop.service.common.AbstractService;

@Service("goodsActivityService")
public class GoodsActivityService extends AbstractService<GoodsActivity> implements IGoodsActivityService {

    @Resource(name="goodsActivityDao")
    private IGoodsActivityDao goodsActivityDao;
    
    public GoodsActivityService() {
        super();
    }

    @Override
    protected IOperations<GoodsActivity> getDao() {
        return this.goodsActivityDao;
    }
    
    public List<GoodsActivity> findGoods()
    {
    	return goodsActivityDao.findAll();
    }
    

    public void  deleteGood(long id)
    {
    	goodsActivityDao.deleteById(id);
    }
}