package com.mcms.business.mobile.service;

import com.mcms.business.mobile.model.MobileUser;

import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
public interface MobileUserService {
    public List<MobileUser> list();
    public String add(MobileUser po);
}
