<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bhvwebapp = request.getContextPath();
%>
    <script src="<%=bhvwebapp%>/res/jquery/js/jquery.validate.js"></script>
    <script src="<%=bhvwebapp%>/res/jquery/js/jquery.metadata.js"></script>
    <script>
    function initValidate(form){
        $.metadata.setType("attr", "validate");
        form.validate({
            errorClass: "help-inline",
            errorElement: "span",
            highlight:function(element, errorClass, validClass) {
                $(element).parents('.control-group').addClass('error');
            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).parents('.control-group').removeClass('error');
                $(element).parents('.control-group').addClass('success');
            }
        });
    }

    function validate(form){
        $.metadata.setType("attr", "validate");
        return form.validate({
            errorClass: "help-inline",
            errorElement: "span",
            highlight:function(element, errorClass, validClass) {
                $(element).parents('.control-group').addClass('error');
            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).parents('.control-group').removeClass('error');
                $(element).parents('.control-group').addClass('success');
            }
        }).form();
    }
    </script>

