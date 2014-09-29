// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   rk

package com.mcms.sfw.common.exception.handler;

import com.mcms.sfw.common.log.Log;
import com.mcms.sfw.common.util.HttpUtil;
import org.json.JsonWPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MCMSExceptionHandler implements HandlerExceptionResolver
{
    @Autowired
    Log log;

	public MCMSExceptionHandler(){
	}

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        log.loger.error(e.getMessage(),e);
        if(HttpUtil.isAjaxRequest(request)){
            Map model = new HashMap();
            model.put("success", false);
            model.put("msg",e.getMessage());
            model.put("info",e.toString());
            String json= JsonWPUtil.toJson(model);
            try {
                response.getWriter().write(json);
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }else{
            Map model = new HashMap();
            model.put("msg",e.getMessage());
            return new ModelAndView("page/error/error_500",model);
        }
    }
}
