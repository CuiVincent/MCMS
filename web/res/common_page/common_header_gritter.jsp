<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bhgwebapp = request.getContextPath();
%>
    <link rel="stylesheet" href="<%=bhgwebapp%>/res/jquery/css/jquery.gritter.css" />
    <script src="<%=bhgwebapp%>/res/jquery/js/jquery.gritter.min.js"></script>
    <script>
        function showGritter(type,title,msg){
            var icon='icon_w_info.png';
            var classname = 'gritter-green';
            if(type=="error"){
                icon='icon_w_error.png';
                classname='';
            }
            if(type=="msg"){
                icon='icon_w_msg.png';
                classname='gritter-orange';
            }
            if(type=="letter"){
                icon='icon_w_letter.png';
                classname='gritter-orange';
            }

            // === jQeury Gritter, a growl-like notifications === //
            $.gritter.add({
                title:	title,
                text:	msg,
                image: 	'<%=bhgwebapp%>/res/img/'+icon,
                sticky: false,
                class_name:classname
            });

        }
    </script>