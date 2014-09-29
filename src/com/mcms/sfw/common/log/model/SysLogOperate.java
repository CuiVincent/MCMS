package com.mcms.sfw.common.log.model;

import com.mcms.sfw.base.model.BaseModel;

import java.util.Date;

/**
 * Created by Administrator on 2014/4/24.
 */
public class SysLogOperate extends BaseModel {
    private String USER_ID;
    private String IP;
    private String OPERATE;
    private String URL;
    private Date STARTTIME;
    private Date ENDTIME;
    private String MODULE;
    private String DES;
    private String MAC;

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

    public String getOPERATE() {
        return OPERATE;
    }

    public void setOPERATE(String OPERATE) {
        this.OPERATE = OPERATE;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Date getSTARTTIME() {
        return STARTTIME;
    }

    public void setSTARTTIME(Date STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    public Date getENDTIME() {
        return ENDTIME;
    }

    public void setENDTIME(Date ENDTIME) {
        this.ENDTIME = ENDTIME;
    }

    public String getMODULE() {
        return MODULE;
    }

    public void setMODULE(String MODULE) {
        this.MODULE = MODULE;
    }

    public String getDES() {
        return DES;
    }

    public void setDES(String DES) {
        this.DES = DES;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }
}

