package com.mcms.sfw.common.util;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 该类为Http请求响应工具类
 *
 * @author Leibf
 * @version 2008-4-24
 */
public class HttpUtil {
    public HttpUtil() {
    }

    /**
     * 获取请求url
     *
     * @param request
     * @return url字符串
     */
    public static String getRequestResource(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        StringBuffer stringbuffer = new StringBuffer(servletPath);
        String queryString = request.getQueryString();
        if (queryString != null) {
            stringbuffer.append("?");
            stringbuffer.append(queryString);
        }
        String url = stringbuffer.toString();
        return url;
    }

    /**
     * 判断HttpServletRequest请求是否为Ajax请求
     *
     * @param request
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        boolean isAjaxRequest = false;

        String reaHeader = request.getHeader("__IS_AJAX_REQUEST");
        System.out.println("reaHeader:"+reaHeader);
        if (reaHeader != null) {
            if (reaHeader.trim().equalsIgnoreCase("true")) {
                isAjaxRequest = true;
            }
        }

        return isAjaxRequest;
    }

    /**
     * 设置页面响应无缓存
     *
     * @param httpservletresponse
     */
    public static void setResponseNoCache(HttpServletResponse httpservletresponse) {
        httpservletresponse.setHeader("Cache-Control", "no-cache");
        httpservletresponse.setDateHeader("Expires", 0L);
        httpservletresponse.setHeader("Pragma", "No-cache");
    }

    /**
     * 获取客户端的真实ip地址
     *
     * @param request
     * @return 客户端的真实ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取客户端的MAC地址
     */
    public static String getMACAddress(String ipAddress) {
        String str = "", strMAC = "", macAddress = "";
        try {
            Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        strMAC = str.substring(str.indexOf("MAC Address") + 14,
                                str.length());
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            return "";
        }
//
        if (strMAC.length() < 17) {
            return "";
        }

        macAddress = strMAC.substring(0, 2) + ":" + strMAC.substring(3, 5)
                + ":" + strMAC.substring(6, 8) + ":" + strMAC.substring(9, 11)
                + ":" + strMAC.substring(12, 14) + ":"
                + strMAC.substring(15, 17);
//
        return macAddress;
    }


//	/**
//	 * 判断页面是否为无需session页面(登录等页面)
//	 * @param urlNoContextPath url
//	 * @return
//	 */
//	public static boolean isNoSessionPage(String urlNoContextPath)
//	{
//		return (urlNoContextPath.equals("/")
//				|| urlNoContextPath.equals("")
//				|| urlNoContextPath.endsWith(CONFIG.LOGON_PAGE)
//				|| urlNoContextPath.endsWith(CONFIG.SESSION_TIME_OUT_PAGE)
//				|| urlNoContextPath.endsWith(CONFIG.SYS_ERROR_PAGE)
//				|| urlNoContextPath.endsWith(CONFIG.GLOBAL_ERROR_PAGE)
//				|| urlNoContextPath.endsWith(CONFIG.OUT_OF_ACCESSTIME_PAGE));
//	}
//
//	/**
//	 * 判断action是否为无需session校验的action(如登录action)
//	 * @param urlAction
//	 * @return
//	 */
//	public static boolean isNoSessionAction(String urlAction)
//	{
//		return (urlAction.indexOf("/logonAction") >= 0 || urlAction.indexOf("/logonNewAction") >= 0);
//	}
//
//	/**
//	 * 跳转到权限提示页面
//	 * @param req
//	 * @param response
//	 * @throws java.io.IOException
//	 * @throws ServletException
//	 */
//	public static void forwardToNoAuthJsp(HttpServletRequest req, ServletResponse response) throws IOException, ServletException
//	{
//		HttpServletResponse hres = (HttpServletResponse) response;
//		if (HttpUtil.isAjaxRequest(req) || HttpUtil.isEcsideRequest(req))
//		{
//			//Ajax请求或Ecside请求则alert提示
//			hres.setCharacterEncoding("utf-8");
//			PrintWriter out = hres.getWriter();
//			try
//			{
//				out.println("您暂无权限进行此项操作，如需操作请与管理员联系。");
//			}
//			finally
//			{
//				out.close();
//			}
//		}
//		else
//		{
//			String ctxPath = req.getContextPath();
//			hres.sendRedirect(ctxPath + CONFIG.NO_AUTH_PROMPT_PAGE);
//		}
//	}
//
//	/**
//	 * 跳转到session超时页面
//	 * @param req
//	 * @param response
//	 * @throws Exception
//	 */
//	public static void forwardToSessionOutJsp(HttpServletRequest req, ServletResponse response) throws IOException, ServletException
//	{
//		HttpServletResponse hres = (HttpServletResponse) response;
//		if (HttpUtil.isAjaxRequest(req) || HttpUtil.isEcsideRequest(req))
//		{
//			//Ajax请求或Ecside请求则alert提示
//			hres.setCharacterEncoding("utf-8");
//			PrintWriter out = hres.getWriter();
//			try
//			{
//				out.println("由于您长时间没有对系统进行操作，您的系统会话已经结束，请重新登录。");
//			}
//			finally
//			{
//				out.close();
//			}
//		}
//		else
//		{
//			hres.setContentType("text/html");
//			hres.getWriter().println("<script language='JavaScript'>");
//			String ctxPath = req.getContextPath();
//			hres.getWriter().println("window.open('" + ctxPath + CONFIG.SESSION_TIME_OUT_PAGE + "', '_top');");
//			hres.getWriter().println("</script>");
//		}
//	}
//
//	/**
//	 * 跳转到超过允许访问时间段提示页面
//	 * @param req
//	 * @param response
//	 * @param access_start
//	 * @param access_end
//	 * @throws java.io.IOException
//	 * @throws ServletException
//	 */
//	public static void forwardToOutOfAccessTimeJsp(HttpServletRequest req, ServletResponse response, String access_start, String access_end) throws IOException, ServletException
//	{
//		HttpServletResponse hres = (HttpServletResponse) response;
//		if (HttpUtil.isAjaxRequest(req) || HttpUtil.isEcsideRequest(req))
//		{
//			//Ajax请求或Ecside请求则alert提示
//			hres.setCharacterEncoding("utf-8");
//			PrintWriter out = hres.getWriter();
//			try
//			{
//				boolean bBetweenTwoDays = false; //时间段是否跨两天
//				if(Integer.parseInt(access_start)>Integer.parseInt(access_end))
//				{
//					bBetweenTwoDays = true;
//				}
//				access_start = access_start.substring(0,2) + ":" +access_start.substring(2,4);
//				access_end = access_end.substring(0,2) + ":" +access_end.substring(2,4);
//				if(bBetweenTwoDays)
//				{
//					access_end = "次日" + access_end;
//				}
//				out.println("此项操作只允许在时间段『" + access_start + "-" + access_end + "』进行，如需操作请与管理员联系。");
//			}
//			finally
//			{
//				out.close();
//			}
//		}
//		else
//		{
//			String ctxPath = req.getContextPath();
//			hres.sendRedirect(ctxPath + CONFIG.OUT_OF_ACCESSTIME_PAGE +"?access_start=" +access_start +"&access_end="+access_end);
//		}
//	}


    /**
     * trim掉url最后一个"/"之前的部分和"&"所带的部分
     *
     * @param url
     * @return
     */
    public static String trimUrl(String url) {
        String trimUrl = url;

        if (url != null && !url.trim().equals("")) {
            int firstAnd = url.indexOf("&", 1);
            if (firstAnd < 0) {
                trimUrl = url;
            } else {
                trimUrl = url.substring(0, firstAnd);
            }
        }

        return trimUrl;
    }

}
