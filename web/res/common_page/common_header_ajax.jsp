<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bhawebapp = request.getContextPath();
%>
<%@ include file="/res/common_page/common_header_gritter.jsp"%>
<script src="<%=bhawebapp%>/res/js/common_js.js"></script>
<script>
    function ajaxCommitForm( form,succcess){
        var url = $(form).attr("action");
        doAjaxCommitForm(url,form,succcess,function(result){
            showGritter("error",result.msg,result.info);
        });
    }
</script>