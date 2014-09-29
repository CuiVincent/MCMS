package com.mcms.sfw.common.log.service;

import com.mcms.sfw.common.log.model.SysLogLogin;
import com.mcms.sfw.common.log.model.SysLogOperate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/4/20.
 */
public interface SysLogService {
    public boolean insertLoginLog(SysLogLogin model);
    public boolean updateLoginLogById(SysLogLogin model);
    public boolean insertOperateLog(SysLogOperate model);
}
