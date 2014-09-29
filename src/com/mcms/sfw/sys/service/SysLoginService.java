package com.mcms.sfw.sys.service;

import com.mcms.sfw.sys.model.SysPri;
import com.mcms.sfw.sys.model.SysUser;

import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
public interface SysLoginService {
    public SysUser findByCode(String usercode);
    public List<SysPri> findPriByUserId(String userId);
}
