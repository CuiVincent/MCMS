<%@ page import="com.mcms.sfw.sys.model.SysPri" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mcms.sfw.common.util.SessionUtil" %>
<%@ page import="com.mcms.sfw.common.util.ViewUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String webapp = request.getContextPath();
    List<SysPri> pris = SessionUtil.getLgoinUserPris(request);
%>
<!DOCTYPE html>
<html>
<head>
    <title>MCMS</title>
    <meta charset="UTF-8"/>
    <%@ include file="/res/common_page/bootstrap_header_index.jsp" %>
    <%@ include file="/res/common_page/common_header_ajax.jsp" %>
    <script>
        $(function(){
            setContent(null,'/page/main.jsp');
        });
        /*
         登出
         */
        function doLogout() {
            location.href = "<%=webapp %>/sys_login/logout.do";
        }

        function iFrameHeight() {
            var ifm = document.getElementById("iframe");
            var subWeb = document.frames ? document.frames["iframe"].document : ifm.contentDocument;
            if (ifm != null && subWeb != null) {
                ifm.height = subWeb.body.scrollHeight;
            }
        }
        function setContentByMenu(aid, url) {
            if (null != url && "/" != url && "" != url && "null" != url||undefined==url) {
                $('#sidebar li').removeClass("active");
                var a =$("#"+aid);
                a.closest('li').addClass("active");
                $("#iframe").attr("height", 0);
                $("#iframe").attr("src", <%=webapp%>url);
                var header ="";
                var parents_lis=a.parents('li');
                var parents_as=$(parents_lis).children('a');
                for(var i=parents_as.length-1;i>=0;i--){
                    var text= $($(parents_as[i]).children("span")[0]).text() ;
                    var click= $(parents_as[i]).attr("onclick") ;
                    if($(parents_as[i]).attr("id")== aid){
                        header+="<a href='#' class='current' >"+ text +"</a>"
                    }else{
                        header+="<a href='#' onclick=\""+click+"\" >"+ text +"</a>"
                    }
                }
                var header_home="<a href='#' onclick=\"setContent(null,'/page/main.jsp');\" title='去首页' class='tip-bottom'><i class='icon-home'></i>首页</a> ";
                header=header_home+header;
                $("#breadcrumb").html(header);
            }
        }

        function setContent(name, url) {
            if (null != url && "/" != url && "" != url && "null" != url||undefined==url) {
                $('#sidebar li').removeClass("active");
                $("#iframe").attr("height", 0);
                $("#iframe").attr("src", <%=webapp%>url);
                var header = "<a href='#' onclick=\"setContent(null,'/page/main.jsp');\" title='去首页' class='tip-bottom'><i class='icon-home'></i>首页</a> ";
                if(null!=name){
                    header += "<a href='#' class='current' >"+ name +"</a>";
                }
                $("#breadcrumb").html(header);
            }
        }

    </script>
</head>
<body>
<!--Header-part-->
<div id="header">
    <h1><a onclick="setContent(null,'/page/main.jsp');">MCMS</a></h1>
</div>

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li class="dropdown" id="profile-messages"><a title="" href="#" data-toggle="dropdown"
                                                      data-target="#profile-messages" class="dropdown-toggle"><i
                class="icon icon-user"></i> <span class="text">欢迎，<%=SessionUtil.getLgoinUserName(request)%></span><b
                class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#" onclick="setContent('我的资料','/page/main.jsp');"><i class="icon-user"></i>我的资料</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
                <li class="divider"></li>
                <li><a href="#" onclick="doLogout();"><i class="icon-key"></i>登出</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages"
                                                   class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
                class="text">消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i>我的消息</a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i>收件箱</a></li>
                <li class="divider"></li>
                <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i>发件箱</a></li>
                <li class="divider"></li>
                <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i>回收站</a></li>
            </ul>
        </li>
        <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
        <li class=""><a title="" href="#"  onclick="doLogout();"><i class="icon icon-share-alt"></i> <span class="text">登出</span></a>
        </li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<div id="search">
    <input type="text" placeholder="搜索关键字"/>
    <button type="submit" class="tip-bottom" title="搜索"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i>首页</a>
    <ul>
        <li ><a href="#" onclick="setContent(null,'/page/main.jsp');"><i class="icon icon-home"></i>
            <span>首页</span></a></li>

        <%=ViewUtil.getLoginUserMenuHtml(pris)%>

        <li class="content"><span>下载进度</span>

            <div class="progress progress-mini progress-danger active progress-striped">
                <div style="width: 77%;" class="bar"></div>
            </div>
            <span class="percent">77%</span>

            <div class="stat">21419.94 / 14000 MB</div>
        </li>
        <li class="content"><span>磁盘空间</span>

            <div class="progress progress-mini active progress-striped">
                <div style="width: 87%;" class="bar"></div>
            </div>
            <span class="percent">87%</span>

            <div class="stat">604.44 / 4000 MB</div>
        </li>
    </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"></div>
    </div>
    <div class="container-fluid">
        <iframe src="<%=webapp%>/page/main.jsp" id="iframe" width="100%" onLoad="iFrameHeight()" runat="server"
                frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no"
                allowtransparency="yes"></iframe>
    </div>
</div>
<!--end-main-container-part-->

<!--Footer-part-->
<div class="row-fluid">
    <div id="footer" class="span12"> 2014 &copy; MCMS. 版权所有 <a href="/">www.mcms.cn</a></div>
</div>

</body>
</html>
