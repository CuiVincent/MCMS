package com.mcms.sfw.common.log.service.impl;

import com.mcms.sfw.base.service.BaseService;
import com.mcms.sfw.common.log.model.SysLogLogin;
import com.mcms.sfw.common.log.model.SysLogOperate;
import com.mcms.sfw.common.log.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/4/20.
 */
@Service
public class SysLogServiceImpl extends BaseService implements SysLogService {

    @Override
    public boolean insertLoginLog(final SysLogLogin model) {
        final boolean[] r = {false};
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   r[0] =  getDao().add("SysLog.insertLoginLog", model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return r[0];
    }

    @Override
    public boolean updateLoginLogById(final SysLogLogin model) {
        final boolean[] r = {false};
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r[0] =  getDao().update("SysLog.updateLoginLogById", model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return r[0];
    }

    @Override
    public boolean insertOperateLog(final SysLogOperate model) {
        final boolean[] r = {false};
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r[0] =  getDao().add("SysLog.insertOperateLog", model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return r[0];
    }
}
