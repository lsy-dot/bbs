<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/7
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
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
<script>
    function initial(){
        alert("${APP_PATH}/jumpToLogin/login");
    $.ajax({
        url:"${APP_PATH}/jumpToLogin/login",
        type:"post",
        async:false,
        success:function (result) {
            window.location.href="${APP_PATH}/jumpToLogin/login";
        }
    })
    }
</script >
<body onload="initial()">
<%--<div id="info"></div>--%>
<%--<button type="button" class="btn btn-primary">（首选项）Primary</button>--%>
</body>
</html>
