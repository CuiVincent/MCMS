package com.mcms.sfw.sys.model;

import com.mcms.sfw.base.model.BaseModel;

/**
 * Created by Administrator on 2014/4/24.
 */
public class SysGroup extends BaseModel {
    private String CODE;
    private String NAME;
    private String CUSERID;
    private String CDATE;
    private String EUSERID;
    private String EDATE;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCUSERID() {
        return CUSERID;
    }

    public void setCUSERID(String CUSERID) {
        this.CUSERID = CUSERID;
    }

    public String getCDATE() {
        return CDATE;
    }

    public void setCDATE(String CDATE) {
        this.CDATE = CDATE;
    }

    public String getEUSERID() {
        return EUSERID;
    }

    public void setEUSERID(String EUSERID) {
        this.EUSERID = EUSERID;
    }

    public String getEDATE() {
        return EDATE;
    }

    public void setEDATE(String EDATE) {
        this.EDATE = EDATE;
    }
}

