package com.mcms.sfw.sys.controller;

import com.mcms.sfw.base.controller.BaseController;
import com.mcms.sfw.common.Dictionary;
import com.mcms.sfw.common.exception.BusinessRuleException;
import com.mcms.sfw.common.log.Log;
import com.mcms.sfw.common.log.model.SysLogLogin;
import com.mcms.sfw.common.util.DateUtil;
import com.mcms.sfw.common.util.HttpUtil;
import com.mcms.sfw.common.util.StringUtil;
import com.mcms.sfw.common.util.UUIDGenerator;
import com.mcms.sfw.sys.model.LoginUserInfo;
import com.mcms.sfw.sys.model.SysUser;
import com.mcms.sfw.sys.service.SysLoginService;
import org.json.JsonWPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
@Controller
@RequestMapping("/sys_login")
public class SysLoginController extends BaseController {
    @Autowired
    SysLoginService service;
    @Autowired
    Log log;

    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response, String usercode, String passwd) {

        String errmsg = "";
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String logonId = UUIDGenerator.getUUID();
        String ip = HttpUtil.getIpAddress(request);
        String macs = HttpUtil.getMACAddress(ip);
//        String browserType = HttpUtil.getBrowserType(request);

        SysUser user = service.findByCode(usercode);
        SysLogLogin logl = new SysLogLogin();
        logl.setIP(ip);
        logl.setMAC(macs);
        logl.setLOGINTIME(DateUtil.getNowData());
        logl.setSESSION_ID(sessionId);

        // 1、验证用户是否存在
        if (user == null) {
            errmsg = "用户不存在";
        } else {
            String userid =null;
            String passWd = null;
            String validFlag = null;

            userid=user.getID();
            validFlag = user.getISVALID();
            validFlag = validFlag != null ? validFlag.trim() : "0";
            passWd = user.getPASSWORD();

            // 2、验证用户的有效性
            if (!validFlag.equals("1")) {
                if (validFlag.equals("0")) {
                    errmsg = "登录用户已失效";
                } else if (validFlag.equals("D")) {
                    errmsg = "登录用户已被删除";
                } else {
                    errmsg = "登录用户非正常用户";
                }
            }
            // 3、验证用户密码
            if (!StringUtil.MD5(passwd).equals(passWd)) {
                errmsg = "密码错误";
            }
            logl.setUSER_ID(userid);
        }
        logl.setLOGFAILEDREASON(errmsg);
        log.insertLoginLog(logl);
        if (null!=errmsg&&!"".equals(errmsg)){
            request.setAttribute("errmsg", errmsg);
            throw new BusinessRuleException("登录失败",errmsg);
        }else {
            LoginUserInfo info = new LoginUserInfo(user, logonId, ip);
            // 填装登录用户权限列表
            info.setPris(service.findPriByUserId(user.getID()));
            session.setAttribute(Dictionary.LOGON_USER, info);

            // 登录用户名记录到cookie(有效期为7天)
            Cookie cookie = new Cookie(Dictionary.LOGON_USER_CODE, user.getCODE());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
            writerAjaxResponse(response,true,null);
        }
    }
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "page/index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute(Dictionary.LOGON_USER) != null)
        {
            session.invalidate();
        }
        return "page/login";
    }


}
