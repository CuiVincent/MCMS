<%@ page import="com.mcms.sfw.common.Dictionary" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String webapp = request.getContextPath();
//    String errmsg = (String) request.getAttribute("errmsg");
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
    String userCode = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
        for(int i = 0 ;i < cookies.length ; i ++)
        {
            if (cookies[i].getName().equals(Dictionary.LOGON_USER_CODE))
            {
                userCode = cookies[i].getValue();
                userCode = userCode!=null?userCode.trim():"";
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>MCMS-登录</title>
    <meta charset="UTF-8"/>
    <%@ include file="/res/common_page/bootstrap_header_login.jsp" %>
    <%@ include file="/res/common_page/bootstrap_header_validate.jsp" %>
    <%@ include file="/res/common_page/common_header_ajax.jsp" %>
    <script>
        $(function () {
            initValidate($("#recoverform"));//被动校验，submit时触发校验，不适用于ajax
            $("#usercode").val('<%=userCode%>');
        });

        /*
         登录
         */
        function doLogin() {
//            $("#loginform").submit();
            if (validate($("#loginform")))//主动校验
                ajaxCommitForm($("#loginform"), function () {
                    location.href="<%=webapp %>/sys_login/index.do";
                });
        }
        /*
         显示错误信息
         */
        function doShowErrMsg(errmsg) {
            if (null != errmsg && 'null' != errmsg) {
                showGritter('error', '登录失败', errmsg);
            }
        }
        function doGetPasswd() {
            showGritter('info', 'e-mail已发送!', " ");
            $("#recoverform").submit();
        }
    </script>
</head>
<body>
<div id="loginbox">
    <form id="loginform" class="form-vertical" action="<%=webapp %>/sys_login/login.do" method="post">
        <div class="control-group normal_text"><h3><img src="<%=webapp%>/res/matrix_admin/img/logo.png" alt="MCMS"/>
        </h3></div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" id="usercode"
                                                                                      name="usercode"
                                                                                      validate="{required:true,messages:{required:'请输入用户名'}}"
                                                                                      placeholder="请输入用户名"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" id="passwd"
                                                                                      name="passwd"
                                                                                      validate="{required:true,messages:{required:'请输入密码'}}"
                                                                                      placeholder="请输入密码"/>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">忘记密码?</a></span>
            <span class="pull-right"><a type="submit" class="btn btn-success" onclick="doLogin();">登录</a></span>
        </div>
    </form>
    <form id="recoverform" action="#" class="form-vertical">
        <p class="normal_text">通过e-mail找回密码</p>

        <div class="controls">
            <div class="main_input_box">
                <span class="add-on bg_lo"><i class="icon-envelope"></i></span><input type="text" id="email"
                                                                                      name="email"
                                                                                      validate="{required:true,email:true,messages:{required:'请输入e-mail地址',email:'输入的e-mail地址格式不正确'}}"
                                                                                      placeholder="请输入e-mail地址"/>
            </div>
        </div>

        <div class="form-actions">
            <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">返回登录</a></span>
            <span class="pull-right"><a class="btn btn-info" onclick="doGetPasswd();">找回密码</a></span>
        </div>
    </form>
</div>


</body>

</html>

