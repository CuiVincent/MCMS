package com.mcms.sfw.common.log;


import com.mcms.sfw.common.log.model.SysLogLogin;
import com.mcms.sfw.common.log.model.SysLogOperate;
import com.mcms.sfw.common.log.service.SysLogService;
import com.mcms.sfw.common.log.service.impl.SysLogServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class Log {
    @Autowired
    public  SysLogService service = new SysLogServiceImpl();
    public  Logger loger = Logger.getLogger(Log.class);

    public  boolean insertLoginLog(SysLogLogin model){
        return service.insertLoginLog(model);
    }
    public  boolean updateLoginLogById(SysLogLogin model){
        return service.updateLoginLogById(model);
    }
    public  boolean insertOperateLog(SysLogOperate model){
        return service.insertOperateLog(model);
    }

}