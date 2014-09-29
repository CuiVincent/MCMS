package com.mcms.business.mobile.model;

import com.mcms.sfw.base.model.BaseModel;

/**
 * Created by Administrator on 2014/4/18.
 */
public class MobileUser extends BaseModel {

    private String USERID;
    private String USERNAME;
    private String CUSERID;
    private String PHONENUM;
    private String IMEI;
    private String CDATE;
    private String ISVALID;
    private String PASSWD;

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getCUSERID() {
        return CUSERID;
    }

    public void setCUSERID(String CUSERID) {
        this.CUSERID = CUSERID;
    }

    public String getPHONENUM() {
        return PHONENUM;
    }

    public void setPHONENUM(String PHONENUM) {
        this.PHONENUM = PHONENUM;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
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

    public String getPASSWD() {
        return PASSWD;
    }

    public void setPASSWD(String PASSWD) {
        this.PASSWD = PASSWD;
    }
}
