<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<!--
    这里是具体的哪一个版面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>所有版块显示</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>该板块所有的主贴显示</h1>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>发帖人</th>
                        <th>发帖时间</th>
                    </tr>
                    <c:forEach items="${mainlist}" var="mainPost">
                        <tr>
                            <th>${mainPost.mMainid}</th>
                            <th>标题</th>
                            <th>${mainPost.user.uNickname}</th>
                            <th>${mainPost.mMaindate}</th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
<%--    ${mainlist}--%>

</body>
</html>
