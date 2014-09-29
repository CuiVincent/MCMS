package com.mcms.sfw.sys.service.impl;

import com.mcms.sfw.base.service.BaseService;
import com.mcms.sfw.sys.model.SysPri;
import com.mcms.sfw.sys.model.SysUser;
import com.mcms.sfw.sys.service.SysLoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
@Service
public class SysLoginServiceImpl extends BaseService implements SysLoginService {

    @Override
    public SysUser findByCode(String usercode) {
        try {
            return getDao().find("SysLogin.findByCode",usercode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysPri> findPriByUserId(String userId) {
        try {
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("user_id",userId);
            map.put("parent_id","****");
            return getDao().findList("SysLogin.findPriByUserId",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
