package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IUserAccountDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.UserAccount;

@Repository("userAccountDao")
public class UserAccountDao extends AbstractHibernateDao<UserAccount> implements IUserAccountDao {

    public UserAccountDao() {
        super();
        
        setClazz(UserAccount.class);
    }
}