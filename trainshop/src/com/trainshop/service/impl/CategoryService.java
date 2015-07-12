package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.ICategoryDao;
import com.trainshop.model.Category;
import com.trainshop.service.ICategoryService;
import com.trainshop.service.common.AbstractService;

@Service("categoryService")
public class CategoryService extends AbstractService<Category> implements ICategoryService {

    @Resource(name="categoryDao")
    private ICategoryDao categoryrDao;
    
    public CategoryService() {
        super();
    }

    @Override
    protected IOperations<Category> getDao() {
        return this.categoryrDao;
    }
}