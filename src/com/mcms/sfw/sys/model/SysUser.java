package com.mcms.sfw.sys.model;

import com.mcms.sfw.base.model.BaseModel;

/**
 * Created by Administrator on 2014/4/18.
 */
public class SysUser extends BaseModel {


    private String NAME;
    private String CUSERID;
    private String CDATE;
    private String ISVALID;
    private String EUSERID;
    private String EDATE;
    private String PASSWORD;
    private String CODE;


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

    public String getISVALID() {
        return ISVALID;
    }

    public void setISVALID(String ISVALID) {
        this.ISVALID = ISVALID;
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

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

}
