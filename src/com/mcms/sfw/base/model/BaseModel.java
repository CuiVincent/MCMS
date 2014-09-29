package com.mcms.sfw.base.model;

import com.mcms.sfw.common.util.UUIDGenerator;

/**
 * Created by Administrator on 2014/4/22.
 */
public class BaseModel {
    private String ID;

    public BaseModel() {
        this.ID = UUIDGenerator.getUUID();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
