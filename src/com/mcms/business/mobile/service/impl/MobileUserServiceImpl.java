package com.mcms.business.mobile.service.impl;

import com.mcms.business.mobile.model.MobileUser;
import com.mcms.sfw.base.service.BaseService;
import com.mcms.business.mobile.service.MobileUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
@Service
public class MobileUserServiceImpl extends BaseService implements MobileUserService {

    @Override
    public List<MobileUser> list() {
        try {
            return getDao().findList("MobileUser.findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<MobileUser>();
    }

    @Override
    public String add(MobileUser po) {
        try {
            if( getDao().add("MobileUser.add", po))
            return "保存成功！";else{
                return "保存失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！"+e.getMessage();
        }
    }
}
