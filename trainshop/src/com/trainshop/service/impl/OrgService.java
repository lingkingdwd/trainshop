package com.trainshop.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IOrgDao;
import com.trainshop.model.Org;
import com.trainshop.service.IOrgService;
import com.trainshop.service.common.AbstractService;

@Service("orgService")
public class OrgService extends AbstractService<Org> implements IOrgService {

    @Resource(name="orgDao")
    private IOrgDao orgDao;
    
    public OrgService() {
        super();
    }

    @Override
    protected IOperations<Org> getDao() {
        return this.orgDao;
    }
}