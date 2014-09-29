package com.mcms.sfw.base.controller;

import com.mcms.sfw.common.log.Log;
import org.json.JsonWPUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/4/22.
 */
public class BaseController {
    public void writerResponse(HttpServletResponse response,String text){
        try {
            response.getWriter().write(text);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writerAjaxResponse(HttpServletResponse response,boolean success,Map data){
        writerResponse(response, getAjaxJson(success, data));
    }
    public String getAjaxJson(boolean success,Map data){
        if(null==data){
            data = new HashMap();
        }
        data.put("success",success);
        return  JsonWPUtil.toJson(data);
    }
}
