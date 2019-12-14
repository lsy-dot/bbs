<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/14
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跟帖</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <!--
        web路径：
        1.不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
        2.以/开始的相对路径，找资源，以服务器的路径为标准，需要加上项目名称
    -->
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
</head>
<body>

</body>
</html>
<script>
    function initialAjax(){
        $.ajax({
            url:"${APP_PATH}/jumpToLogin/login",
            type:"post",
            async:false,
            success:function (result) {
                window.location.href="${APP_PATH}/jumpToLogin/login";
            }
        })
    }
</script>