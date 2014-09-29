package com.mcms.sfw.sys.model;

import com.google.gson.annotations.Expose;
import com.mcms.sfw.base.model.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2014/4/18.
 */
public class SysPri extends BaseModel {

    private String NAME;
    private String MENUTYPE;
    private String URL;
    private String MEMO;
    private String LOGFLAG;
    private String PARENT_ID;
    private String CUSERID;
    private String CDATE;
    private String EUSERID;
    private String EDATE;
    private String SORT;
    private String ICON;
    private String ICON_BOOTSTRAP;
    private List<SysPri> children;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getMENUTYPE() {
        return MENUTYPE;
    }

    public void setMENUTYPE(String MENUTYPE) {
        this.MENUTYPE = MENUTYPE;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getMEMO() {
        return MEMO;
    }

    public void setMEMO(String MEMO) {
        this.MEMO = MEMO;
    }

    public String getLOGFLAG() {
        return LOGFLAG;
    }

    public void setLOGFLAG(String LOGFLAG) {
        this.LOGFLAG = LOGFLAG;
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

    public String getSORT() {
        return SORT;
    }

    public void setSORT(String SORT) {
        this.SORT = SORT;
    }

    public String getICON() {
        return ICON;
    }

    public void setICON(String ICON) {
        this.ICON = ICON;
    }

    public List<SysPri> getChildren() {
        return children;
    }

    public void setChildren(List<SysPri> children) {
        this.children = children;
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(String PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

    public String getICON_BOOTSTRAP() {
        return ICON_BOOTSTRAP;
    }

    public void setICON_BOOTSTRAP(String ICON_BOOTSTRAP) {
        this.ICON_BOOTSTRAP = ICON_BOOTSTRAP;
    }
}
