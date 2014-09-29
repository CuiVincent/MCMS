package com.mcms.sfw.sys.model;

import com.mcms.sfw.base.model.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2014/4/22.
 */
public class LoginUserInfo extends BaseModel{
    private SysUser user;
    private String loginId ;
    private String remoteIps;
    private List<SysPri> pris;
    public LoginUserInfo(SysUser user,String loginId,String remoteIps) {
        this.user=user;
        this.loginId=loginId;
        this.remoteIps=remoteIps;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getRemoteIps() {
        return remoteIps;
    }

    public void setRemoteIps(String remoteIps) {
        this.remoteIps = remoteIps;
    }

    public List<SysPri> getPris() {
        return pris;
    }

    public void setPris(List<SysPri> pris) {
        this.pris = pris;
    }
}
