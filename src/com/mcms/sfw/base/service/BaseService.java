package com.mcms.sfw.base.service;

import com.mcms.sfw.common.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2014/4/22.
 */
public class BaseService {
    @Autowired
    private CommonDao dao;

    public CommonDao getDao() {
        return dao;
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }
}
