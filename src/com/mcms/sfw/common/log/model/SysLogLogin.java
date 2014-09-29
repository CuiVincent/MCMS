package com.mcms.sfw.common.log.model;

import com.mcms.sfw.base.model.BaseModel;
import com.mcms.sfw.common.util.StringUtil;
import com.mcms.sfw.sys.model.*;

import java.util.Date;

/**
 * Created by Administrator on 2014/4/22.
 */
public class SysLogLogin extends BaseModel {
    private String USER_ID;
    private String IP;
    private String MAC;
    private Date LOGINTIME;
    private Date LOGOUTTIME;
    private String LOGONFLAG;
    private String LOGFAILEDREASON;
    private String SESSION_ID;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public Date getLOGINTIME() {
        return LOGINTIME;
    }

    public void setLOGINTIME(Date LOGINTIME) {
        this.LOGINTIME = LOGINTIME;
    }

    public Date getLOGOUTTIME() {
        return LOGOUTTIME;
    }

    public void setLOGOUTTIME(Date LOGOUTTIME) {
        this.LOGOUTTIME = LOGOUTTIME;
    }

    public String getLOGONFLAG() {
        return StringUtil.isNullString(getLOGFAILEDREASON())?"1":"0";
    }

    public void setLOGONFLAG(String LOGONFLAG) {
        this.LOGONFLAG = LOGONFLAG;
    }

    public String getLOGFAILEDREASON() {
        return LOGFAILEDREASON;
    }

    public void setLOGFAILEDREASON(String LOGFAILEDREASON) {
        this.LOGFAILEDREASON = LOGFAILEDREASON;
    }

    public String getSESSION_ID() {
        return SESSION_ID;
    }

    public void setSESSION_ID(String SESSION_ID) {
        this.SESSION_ID = SESSION_ID;
    }
}
