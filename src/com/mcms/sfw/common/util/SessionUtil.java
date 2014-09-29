package com.mcms.sfw.common.util;

import com.mcms.sfw.common.Dictionary;
import com.mcms.sfw.sys.model.LoginUserInfo;
import com.mcms.sfw.sys.model.SysPri;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2014/5/8.
 */
public class SessionUtil {
    /**
     * 获取登录用户信息
     *
     * @param request
     * @return LoginUserInfo
     */
    public static LoginUserInfo getLgoinUserInfo(HttpServletRequest request){
        try {
            return (LoginUserInfo) request.getSession(false).getAttribute(Dictionary.LOGON_USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 获取登录用户权限列表
     *
     * @param request
     * @return List<SysPri>
     */
    public static List<SysPri> getLgoinUserPris(HttpServletRequest request){
        try {
            return ((LoginUserInfo) request.getSession(false).getAttribute(Dictionary.LOGON_USER)).getPris();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 获取登录用户名称
     *
     * @param request
     * @return String
     */
    public static String getLgoinUserName(HttpServletRequest request){
        try {
            return ((LoginUserInfo) request.getSession(false).getAttribute(Dictionary.LOGON_USER)).getUser().getNAME();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
