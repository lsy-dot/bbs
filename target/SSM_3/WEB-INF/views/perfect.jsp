<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/10
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<!--
    精华帖页面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>精华帖显示</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!--上方的导航栏-->
<div class="top-navigate">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div><h5>BBS论坛</h5></div>
            </div>
        </div>
    </div>
</div>
<!--左部的个人信息栏-->
<div class="left-info">
    <div class="container">
        <div class="row">
            <h4>欢迎使用此bbs论坛</h4>
        </div>
        <div class="row">
            <button class="btn btn-primary" id="emp_add_modal_btn">登录</button>
            <button class="btn btn-danger" id="emp_delete_all">注册</button>
            <a href="${APP_PATH}/index1.jsp">返回主页</a>
        </div>
    </div>
</div>
<!--右部的主页内容栏-->
<div class="right-main">
    <div class="container">
        <!--导航区-->
        <div class="row">
            <div class="col-md-12">
                <div class="nav">
                    <div class="titleShow"><h1>${section.sSectionname}的所有主贴显示</h1></div>
                    <!--显示选择看帖子还是精华帖-->
                    <div class="selects">
                        <div class="row">
                            <div class="col-sm-6"><a href="${APP_PATH}/section/thesection?sectionId=${section.sId}">帖子</a></div>
                            <div class="col-sm-6"><a href="${APP_PATH}/section/perfects?sectionId=${section.sId}">精华帖</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--内容区-->
        <div class="row">
            <div class="col-md-12">
                <!--展示帖子或者精华帖-->
                <div class="allMains">
                    <div class="row">
                        <div class="col-md-12"><!--存放所有的帖子-->
                            <table class="table table-hover">
                                <tr>
                                    <th>序号</th>
                                    <th>标题</th>
                                    <th>内容</th>
                                    <th>发帖人</th>
                                    <th>发帖时间</th>
                                </tr>
                                <c:forEach items="${perfectlist}" var="perfectPost">
                                    <tr>
                                        <th>${perfectPost.mMainid}</th>
                                        <th>标题</th>
                                        <th>${perfectPost.mContent}</th>
                                        <th>${perfectPost.user.uNickname}</th>
                                        <th>${perfectPost.mMaindate}</th>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
</script>
</body>
</html>

