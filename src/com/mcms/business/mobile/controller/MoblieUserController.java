package com.mcms.business.mobile.controller;

import com.mcms.business.mobile.model.MobileUser;
import com.mcms.sfw.base.controller.BaseController;
import com.mcms.business.mobile.service.MobileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2014/4/20.
 */
@Controller
@RequestMapping("/mobile_user")
public class MoblieUserController extends BaseController {
    @Autowired
    MobileUserService service;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<MobileUser> list() throws Exception
    {
        return service.list();
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String edit(HttpServletRequest request, MobileUser po) throws Exception
    {
        String msg= service.add(po);
        return msg;
    }

    @RequestMapping(value = "/toinfo")
    public String save(HttpServletRequest request) throws Exception
    {
        return "mobile_user/info";
    }
}
