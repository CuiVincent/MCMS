<%@ page import="com.mcms.sfw.common.util.StringUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String webapp = request.getContextPath();
%>
<html>
<head>
    <title></title>
    <%@ include file="/res/common_page/bootstrap_header.jsp" %>
</head>
<body>
<!--Action boxes-->
<div class="row-fluid">
    <div class="span12">
        <div class="widget-box">
            <div class="widget-title"><span class="icon"> <i class="icon-info-sign"></i> </span>
                <h5>系统错误</h5>
            </div>
            <div class="widget-content">
                <div class="error_ex">
                    <h1>404</h1>

                    <h3>您所访问的页面不存在</h3>

                    <p>请确认访问地址或联系系统管理员</p>
                    <a class="btn btn-warning btn-big" href="<%=webapp%>/page/login.jsp">返回</a></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
